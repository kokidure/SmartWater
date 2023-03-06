package py.org.smartwater.comunicador;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import py.com.lib.util.log.json.JSONLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class ComunicadorSerial implements Comunicador
{
    private String portName;
    private int baudRate;
    private List<String> mensajes = new LinkedList<String>();
    private SerialWriter serialWriter;

    public ComunicadorSerial(String portName, int baudRate)
    {
        this.portName = portName;
        this.baudRate = baudRate;
    }

    @Override
    public boolean enviar(String msg)
    {
        if(this.serialWriter != null)
        {
            try
            {
                this.serialWriter.write(msg.getBytes());
            }
            catch(IOException e)
            {
                JSONLogger.error(e);
                return false;
            }
        }
        else
        {
            JSONLogger.error("No se puede enviar (no contectado)");
            return false;
        }

        return true;
    }

    @Override
    public String recibir()
    {
        String message = this.mensajes.remove(0);
        return message;
    }

    @Override
    public boolean conectar() throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(this.portName);

        if ( portIdentifier.isCurrentlyOwned() )
        {
            JSONLogger.error("Puerto ocupado: " + this.portName);
            return false;
        }
        else
        {
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);

            if ( commPort instanceof SerialPort)
            {
                SerialPort serialPort = (SerialPort) commPort;

                serialPort.setSerialPortParams(this.baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                OutputStream out = serialPort.getOutputStream();
                this.serialWriter = new SerialWriter(out);
                (new Thread(this.serialWriter)).start();

                InputStream in = serialPort.getInputStream();
                serialPort.addEventListener(new SerialReader(in, this.mensajes));
                serialPort.notifyOnDataAvailable(true);
            }
            else
            {
                JSONLogger.error("Puerto no es serial: " + this.portName);
                return false;
            }
        }

        return true;
    }
}