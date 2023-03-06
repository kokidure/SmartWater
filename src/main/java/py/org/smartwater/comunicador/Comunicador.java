package py.org.smartwater.comunicador;

public interface Comunicador
{
    public boolean enviar(String msg);
    public String recibir();
    public boolean conectar() throws Exception;
}
