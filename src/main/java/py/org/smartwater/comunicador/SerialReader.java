package py.org.smartwater.comunicador;

import com.google.gson.Gson;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import py.com.lib.database.service.Database;
import py.com.lib.util.exceptions.DataAccessException;
import py.com.lib.util.log.Messages;
import py.com.lib.util.log.json.JSONLogger;
import py.org.smartwater.entities.Medicion;
import py.org.smartwater.entities.MedicionPojo;
import py.org.smartwater.etc.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SerialReader implements SerialPortEventListener
{
    private InputStream in;
    private byte[] buffer = new byte[1024];
    List<String> messages;

    public SerialReader ( InputStream in)
    {
        this.in = in;
        this.messages = new LinkedList<String>();
    }

    public SerialReader ( InputStream in, List<String> messages)
    {
        this.in = in;
        this.messages = messages;
    }

    public void serialEvent(SerialPortEvent arg0)
    {
        int data;

        try
        {
            int len = 0;
            while ( ( data = in.read()) > -1 )
            {
                buffer[len++] = (byte) data;
            }

            String lectura = new String(buffer,0, len);

            this.messages.add(lectura);

            Messages.message(lectura);
            storeDB(lectura);
        }
        catch ( IOException e )
        {
            JSONLogger.error(e);
            System.exit(-1);
        }
    }

    private void storeDB(String lectura)
    {
        Gson gson = new Gson();

        String trimmed = lectura.replace("\r", "").replace("\n", " ").trim();

        if(trimmed.startsWith("{") && trimmed.endsWith("}"))
        {
            MedicionPojo medicionPojo = gson.fromJson(trimmed, MedicionPojo.class);

            try
            {
                savePojo(medicionPojo);
            }
            catch (DataAccessException e)
            {
                JSONLogger.error(e);
            }
        }
        else
        {
            JSONLogger.error("No se recibio un JSON");
        }
    }

    private static void savePojo(MedicionPojo medicionPojo) throws DataAccessException
    {
        System.out.println("Save pojo: " + medicionPojo.toString());
        Medicion medicion = new Medicion();

        medicion.setFieldValues(medicionPojo.getId(), new Date(), medicionPojo.getDevice_id(), medicionPojo.getName(), medicionPojo.getValue());

        System.out.println(medicion);
        System.out.println(medicion.describe());

        Config.initialize();

        Database db = new Database();

        db.insert(medicion);
        db.commit();

        db.silentClose();
    }
}
