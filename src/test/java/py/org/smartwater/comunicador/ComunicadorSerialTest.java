package py.org.smartwater.comunicador;

import com.google.gson.Gson;
import javafx.scene.chart.ScatterChart;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import py.com.lib.util.log.json.JSONLogger;
import py.org.smartwater.entities.MedicionPojo;

public class ComunicadorSerialTest extends TestCase
{
    private static final int SLEEP_MS = 1000;
    private Comunicador comunicador;
    private boolean conectado;
    private Gson gson;

    @BeforeClass
    public void setUp ()
    {
        String portName = "COM6";
        int baudRate = 9600;
        this.comunicador = new ComunicadorSerial(portName, baudRate);
        this.gson = new Gson();

        try
        {
            this.conectado = this.comunicador.conectar();
        }
        catch (Exception e)
        {
            JSONLogger.error(e);
        }
    }

    @Test
    public void testVerificarConexion()
    {
        Assert.assertTrue(this.conectado);
    }
    @Test
    public void testVerificarSolicitudPresion()
    {
        this.comunicador.enviar("p");

        try
        {
            Thread.sleep(SLEEP_MS);
        }
        catch(InterruptedException e)
        {
            Thread.interrupted();
        }

        String lectura = this.comunicador.recibir();

        String trimmed = lectura.replace("\r", "").replace("\n", " ").trim();
        MedicionPojo medicionPojo = gson.fromJson(trimmed, MedicionPojo.class);

        String name = medicionPojo.getName();

        Assert.assertEquals("presion_kPa", name);
    }

    @Test
    public void testVerificarSolicitudTemperatura ()
    {
        this.comunicador.enviar("t");

        try
        {
            Thread.sleep(SLEEP_MS);
        }
        catch(InterruptedException e)
        {
            Thread.interrupted();
        }

        String lectura = this.comunicador.recibir();

        String trimmed = lectura.replace("\r", "").replace("\n", " ").trim();
        MedicionPojo medicionPojo = gson.fromJson(trimmed, MedicionPojo.class);

        String name = medicionPojo.getName();

        Assert.assertEquals("temperatura_celsius", name);
    }

    @Test
    public void testVerificarSolicitudCaudal ()
    {
        this.comunicador.enviar("c");

        try
        {
            Thread.sleep(SLEEP_MS);
        }
        catch(InterruptedException e)
        {
            Thread.interrupted();
        }

        String lectura = this.comunicador.recibir();

        String trimmed = lectura.replace("\r", "").replace("\n", " ").trim();
        MedicionPojo medicionPojo = gson.fromJson(trimmed, MedicionPojo.class);

        String name = medicionPojo.getName();

        Assert.assertEquals("caudal_m3_seg", name);
    }
}