/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author usuario
 */
@Entity
public class DetConsulta implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idDetConsulta;
    
    private long idConsulta;
    private String peso;
    private String estatura;
    private String tension;
    private String sintoma;
    private long codigoCie;
    private String recomendacion;

    public long getIdDetConsulta() {
        return idDetConsulta;
    }

    public void setIdDetConsulta(long idDetConsulta) {
        this.idDetConsulta = idDetConsulta;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public long getCodigoCie() {
        return codigoCie;
    }

    public void setCodigoCie(long codigoCie) {
        this.codigoCie = codigoCie;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }  
    
}
