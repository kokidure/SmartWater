package py.org.smartwater.entities;

import java.util.Date;

public class MedicionPojo {
    private Long id;
    private Date instante;
    private String device_id;
    private String name;
    private Double value;

    public MedicionPojo(Date instante, String device_id, String name, Double value) {
        this.instante = instante;
        this.device_id = device_id;
        this.name = name;
        this.value = value;
    }

    public MedicionPojo() {
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

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Medicion{" +
                "id=" + id +
                ", instante=" + instante +
                ", deviceId='" + device_id + '\'' +
                ", nombre='" + name + '\'' +
                ", valor=" + value +
                '}';
    }
}
