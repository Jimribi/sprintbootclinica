package hello;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Especialidad implements Serializable {
    @Id
    private long idEspecialidad;

    private String descripEspecialidad;

    public long getIdEspecialidad() {
        return idEspecialidad;
    }

    public String getDescripEspecialidad() {
        return descripEspecialidad;
    }

    public void setIdEspecialidad(long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public void setDescripEspecialidad(String descripEspecialidad) {
        this.descripEspecialidad = descripEspecialidad;
    }

  
    
}

