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
            (new TwoWaySerialComm()).connect("/dev/cu.usbmodem14131", 9600);
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
