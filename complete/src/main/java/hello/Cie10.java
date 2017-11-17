package hello;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Cie10 implements Serializable {
 
    @Id
    private long codigoCie;

    private String descripcion;
    private String sexo;

    public long getCodigoCie() {
        return codigoCie;
    }

    public void setCodigoCie(long codigoCie) {
        this.codigoCie = codigoCie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }   
}
