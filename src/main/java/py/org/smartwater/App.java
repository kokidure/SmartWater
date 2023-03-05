package py.org.smartwater;

import py.com.lib.database.service.Database;
import py.com.lib.util.exceptions.DataAccessException;
import py.com.lib.util.templates.Result;
import py.org.smartwater.entities.Medicion;
import py.org.smartwater.etc.Config;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args ) throws Exception
    {
//        pruebaConexionSerial();
        //pruebaEntidad();
        pruebaBD();
    }

    private static void pruebaBD() throws DataAccessException {
        Config.initialize();

        Medicion medicion = pruebaEntidad();

        Result r = new Result();

        r.setEntityName("mediciones");
        r.setFieldNames("id", "instante", "device_id", "nombre", "valor");
        r.setFieldTitles("id", "instante", "device_id", "nombre", "valor");
        r.setFieldTypes(Integer.class, Date.class, String.class, String.class, Double.class);
        r.setFieldValues(medicion.getId(), medicion.getInstante(), medicion.getDeviceId(), medicion.getNombre(), medicion.getValor());

        System.out.println(r);

        Database db = new Database();

        db.insert(r);
        db.commit();

        db.silentClose();
    }

    private static void pruebaConexionSerial() {
        try
        {
            String portName = "/dev/cu.usbmodem14101";
//            String portName = "COM6";
            (new TwoWaySerialComm()).connect(portName, 9600);
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    private static Medicion pruebaEntidad() {
        Medicion m = new Medicion(
                new Date(),
                "ARDU1",
                "temperatura_celsius",
                526D
        );

        System.out.println(m);

        return m;
    }
}
