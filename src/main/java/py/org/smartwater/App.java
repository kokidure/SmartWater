package py.org.smartwater;

import py.org.smartwater.entities.Medicion;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args )
    {
//        pruebaConexionSerial();
        pruebaEntidad();
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

    private static void pruebaEntidad() {
        Medicion m = new Medicion(
                new Date(),
                "ARDU1",
                "temperatura_celsius",
                526D
        );

        System.out.println(m);
    }
}
