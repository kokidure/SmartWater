package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args )
    {
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
}
