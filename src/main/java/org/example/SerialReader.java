package org.example;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;

public class SerialReader implements SerialPortEventListener
{
    private InputStream in;
    private byte[] buffer = new byte[1024];

    public SerialReader ( InputStream in )
    {
        this.in = in;
    }

    public void serialEvent(SerialPortEvent arg0)
    {
        int data;

        try
        {
            int len = 0;
            while ( ( data = in.read()) > -1 )
            {
//                if ( data == '\n' )
//                {
//                    break;
//                }
                buffer[len++] = (byte) data;
            }
            System.out.print(new String(buffer,0,len));
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
