package hello;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Especialista implements Serializable {
    
    @Id
    private long idEspecialista;
    private long idTipoDoc;
    private String nombres;
    private String apellidos;
    private String direccion;
    private long telefono;
    private long idEspecialidad;

    public long getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(long idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public long getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(long idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    
    
}
