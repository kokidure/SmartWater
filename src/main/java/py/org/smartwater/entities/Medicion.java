package py.org.smartwater.entities;

import java.util.Date;

public class Medicion {
    private Long id;
    private Date instante;
    private String deviceId;
    private String nombre;
    private Double valor;

    public Medicion(Date instante, String deviceId, String nombre, Double valor) {
        this.instante = instante;
        this.deviceId = deviceId;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Medicion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                "id=" + id +
                ", instante=" + instante +
                ", deviceId='" + deviceId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }
}
