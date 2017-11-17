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
public class TipoConsulta implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idTipo;

    private String DescripTipo;

    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripTipo() {
        return DescripTipo;
    }

    public void setDescripTipo(String DescripTipo) {
        this.DescripTipo = DescripTipo;
    }
    
}
