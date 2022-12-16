/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "matriculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matriculas.findAll", query = "SELECT m FROM Matriculas m"),
    @NamedQuery(name = "Matriculas.findByIdMatriculas", query = "SELECT m FROM Matriculas m WHERE m.idMatriculas = :idMatriculas"),
@NamedQuery(name = "Matriculas.findByIdMatriculasAlumno", query = "SELECT m FROM Matriculas m WHERE m.idalumM = :idalumM")


})
public class Matriculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matriculas")
    private Integer idMatriculas;
    @JoinColumn(name = "id_alumM", referencedColumnName = "id_alumnos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Alumnos idalumM;
    @JoinColumn(name = "id_seccioM", referencedColumnName = "id_secciones")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Secciones idseccioM;

    public Matriculas() {
    }

    public Matriculas(Alumnos idalumM) {
        this.idalumM = idalumM;
    }

    public Matriculas(Alumnos idalumM, Secciones idseccioM) {
        this.idalumM = idalumM;
        this.idseccioM = idseccioM;
    }

    public Matriculas(Integer idMatriculas) {
        this.idMatriculas = idMatriculas;
    }

    public Integer getIdMatriculas() {
        return idMatriculas;
    }

    public void setIdMatriculas(Integer idMatriculas) {
        this.idMatriculas = idMatriculas;
    }

    public Alumnos getIdalumM() {
        return idalumM;
    }

    public void setIdalumM(Alumnos idalumM) {
        this.idalumM = idalumM;
    }

    public Secciones getIdseccioM() {
        return idseccioM;
    }

    public void setIdseccioM(Secciones idseccioM) {
        this.idseccioM = idseccioM;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatriculas != null ? idMatriculas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matriculas)) {
            return false;
        }
        Matriculas other = (Matriculas) object;
        if ((this.idMatriculas == null && other.idMatriculas != null) || (this.idMatriculas != null && !this.idMatriculas.equals(other.idMatriculas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matriculas{" + "idMatriculas=" + idMatriculas + ", idalumM=" + idalumM + ", idseccioM=" + idseccioM + '}';
    }

    
}
