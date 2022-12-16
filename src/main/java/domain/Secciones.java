/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "secciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secciones.findAll", query = "SELECT s FROM Secciones s"),
    @NamedQuery(name = "Secciones.findByIdSecciones", query = "SELECT s FROM Secciones s WHERE s.idSecciones = :idSecciones"),
    @NamedQuery(name = "Secciones.findByModalidad", query = "SELECT s FROM Secciones s WHERE s.modalidad = :modalidad"),
    @NamedQuery(name = "Secciones.findByEstado", query = "SELECT s FROM Secciones s WHERE s.estado = :estado")})
public class Secciones implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modalidad")
    private String modalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idseccioM", fetch = FetchType.LAZY)
    private List<Matriculas> matriculasList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_secciones")
    private Integer idSecciones;
    @JoinColumn(name = "id_aula", referencedColumnName = "id_aulas")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aulas idAula;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_cursos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cursos idCurso;
    @JoinColumn(name = "id_docente", referencedColumnName = "id_docentes")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Docentes idDocente;

    public Secciones() {
    }

    public Secciones(Integer idSecciones) {
        this.idSecciones = idSecciones;
    }

    public Secciones(Integer idSecciones, String modalidad, String estado) {
        this.idSecciones = idSecciones;
        this.modalidad = modalidad;
        this.estado = estado;
    }

    public Secciones(String modalidad, String estado, Aulas idAula, Cursos idCurso, Docentes idDocente) {
        this.modalidad = modalidad;
        this.estado = estado;
        this.idAula = idAula;
        this.idCurso = idCurso;
        this.idDocente = idDocente;
    }
    
    

    public Integer getIdSecciones() {
        return idSecciones;
    }

    public void setIdSecciones(Integer idSecciones) {
        this.idSecciones = idSecciones;
    }


    public Aulas getIdAula() {
        return idAula;
    }

    public void setIdAula(Aulas idAula) {
        this.idAula = idAula;
    }

    public Cursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Cursos idCurso) {
        this.idCurso = idCurso;
    }

    public Docentes getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docentes idDocente) {
        this.idDocente = idDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSecciones != null ? idSecciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secciones)) {
            return false;
        }
        Secciones other = (Secciones) object;
        if ((this.idSecciones == null && other.idSecciones != null) || (this.idSecciones != null && !this.idSecciones.equals(other.idSecciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.utp.matriculate.fffffffffffffffffffffffffffff.Secciones[ idSecciones=" + idSecciones + " ]";
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Matriculas> getMatriculasList() {
        return matriculasList;
    }

    public void setMatriculasList(List<Matriculas> matriculasList) {
        this.matriculasList = matriculasList;
    }
    
}
