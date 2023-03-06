package py.org.smartwater.comunicador;

public interface Comunicador
{
    public boolean enviar(String msg);
    public boolean enviar(int msg);
    public String recibir();
    public boolean conectar() throws Exception;
}
