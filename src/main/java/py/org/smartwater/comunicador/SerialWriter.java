package py.org.smartwater.comunicador;

import py.com.lib.util.log.json.JSONLogger;

import java.io.IOException;
import java.io.OutputStream;

public class SerialWriter implements Runnable
{
    OutputStream out;

    public SerialWriter ( OutputStream out )
    {
        this.out = out;
    }

    public void run ()
    {
        try
        {
            int c = 0;
            while ( ( c = System.in.read()) > -1 )
            {
                this.write(c);
            }
        }
        catch ( IOException e )
        {
            JSONLogger.error(e);
            System.exit(-1);
        }
    }

    public void write(int c) throws IOException
    {
        this.out.write(c);
    }

    public void write(byte[] data) throws IOException
    {
        this.out.write(data);
    }
}