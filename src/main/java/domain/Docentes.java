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
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByIdDocentes", query = "SELECT d FROM Docentes d WHERE d.idDocentes = :idDocentes"),
    @NamedQuery(name = "Docentes.findByDni", query = "SELECT d FROM Docentes d WHERE d.dni = :dni"),
    @NamedQuery(name = "Docentes.findByNombre", query = "SELECT d FROM Docentes d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docentes.findByApellido", query = "SELECT d FROM Docentes d WHERE d.apellido = :apellido"),
    @NamedQuery(name = "Docentes.findByTipoDocente", query = "SELECT d FROM Docentes d WHERE d.tipoDocente = :tipoDocente"),
    @NamedQuery(name = "Docentes.findByCorreo", query = "SELECT d FROM Docentes d WHERE d.correo = :correo"),
    @NamedQuery(name = "Docentes.findByFacultad", query = "SELECT d FROM Docentes d WHERE d.facultad = :facultad"),
    @NamedQuery(name = "Docentes.findByCarrera", query = "SELECT d FROM Docentes d WHERE d.carrera = :carrera")})
public class Docentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_docentes")
    private Integer idDocentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipo_docente")
    private String tipoDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "facultad")
    private String facultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "carrera")
    private String carrera;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente", fetch = FetchType.LAZY)
    private List<Secciones> seccionesList;

    public Docentes() {
    }

    public Docentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public Docentes(Integer idDocentes, String dni, String nombre, String apellido, String tipoDocente, String correo, String facultad, String carrera) {
        this.idDocentes = idDocentes;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocente = tipoDocente;
        this.correo = correo;
        this.facultad = facultad;
        this.carrera = carrera;
    }

    public Integer getIdDocentes() {
        return idDocentes;
    }

    public void setIdDocentes(Integer idDocentes) {
        this.idDocentes = idDocentes;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idDocentes != null ? idDocentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.idDocentes == null && other.idDocentes != null) || (this.idDocentes != null && !this.idDocentes.equals(other.idDocentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.gm.sga.domain.Docentes[ idDocentes=" + idDocentes + " ]";
    }
    
}
