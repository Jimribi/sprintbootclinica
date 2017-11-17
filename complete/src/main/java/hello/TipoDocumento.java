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

@Entity
public class TipoDocumento implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idTipoDoc;

    private String descripTipoDoc;

    public long getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(long idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getDescripTipoDoc() {
        return descripTipoDoc;
    }

    public void setDescripTipoDoc(String descripTipoDoc) {
        this.descripTipoDoc = descripTipoDoc;
    }
    
    
}
