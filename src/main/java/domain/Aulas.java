/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "aulas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aulas.findAll", query = "SELECT a FROM Aulas a"),
    @NamedQuery(name = "Aulas.findByIdAulas", query = "SELECT a FROM Aulas a WHERE a.idAulas = :idAulas"),
    @NamedQuery(name = "Aulas.findByPabellon", query = "SELECT a FROM Aulas a WHERE a.pabellon = :pabellon"),
    @NamedQuery(name = "Aulas.findByPiso", query = "SELECT a FROM Aulas a WHERE a.piso = :piso"),
    @NamedQuery(name = "Aulas.findByAula", query = "SELECT a FROM Aulas a WHERE a.aula = :aula"),
    @NamedQuery(name = "Aulas.findByTipo", query = "SELECT a FROM Aulas a WHERE a.tipo = :tipo")})
public class Aulas implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pabellon")
    private String pabellon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "aula")
    private String aula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo")
    private String tipo;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aulas")
    private Integer idAulas;
    @OneToMany(mappedBy = "idAula", fetch = FetchType.LAZY)
    private List<Secciones> seccionesList;

    public Aulas() {
    }

    public Aulas(Integer idAulas) {
        this.idAulas = idAulas;
    }

    public Aulas(Integer idAulas, String pabellon, int piso, String aula, String tipo) {
        this.idAulas = idAulas;
        this.pabellon = pabellon;
        this.piso = piso;
        this.aula = aula;
        this.tipo = tipo;
    }

    public Integer getIdAulas() {
        return idAulas;
    }

    public void setIdAulas(Integer idAulas) {
        this.idAulas = idAulas;
    }


    @XmlTransient
    public List<Secciones> getSeccionesList() {
        return seccionesList;
    }

    public void setSeccionesList(List<Secciones> seccionesList) {
        this.seccionesList = seccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAulas != null ? idAulas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aulas)) {
            return false;
        }
        Aulas other = (Aulas) object;
        if ((this.idAulas == null && other.idAulas != null) || (this.idAulas != null && !this.idAulas.equals(other.idAulas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utp.matriculate.fffffffffffffffffffffffffffff.Aulas[ idAulas=" + idAulas + " ]";
    }

    public String getPabellon() {
        return pabellon;
    }

    public void setPabellon(String pabellon) {
        this.pabellon = pabellon;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
