/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "produtos", catalog = "xepa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByCodPro", query = "SELECT p FROM Produtos p WHERE p.codPro = :codPro"),
    @NamedQuery(name = "Produtos.findByNomePro", query = "SELECT p FROM Produtos p WHERE p.nomePro = :nomePro"),
    @NamedQuery(name = "Produtos.findByTipoPro", query = "SELECT p FROM Produtos p WHERE p.tipoPro = :tipoPro"),
    @NamedQuery(name = "Produtos.findByPrecoPro", query = "SELECT p FROM Produtos p WHERE p.precoPro = :precoPro")})
public class Produtos implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_pro")
    private Integer codPro;
    @Basic(optional = false)
    @Column(name = "nome_pro")
    private String nomePro;
    @Column(name = "tipo_pro")
    private String tipoPro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_pro")
    private BigDecimal precoPro;

    public Produtos() {
    }

    public Produtos(Integer codPro) {
        this.codPro = codPro;
    }

    public Produtos(Integer codPro, String nomePro) {
        this.codPro = codPro;
        this.nomePro = nomePro;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        Integer oldCodPro = this.codPro;
        this.codPro = codPro;
        changeSupport.firePropertyChange("codPro", oldCodPro, codPro);
    }

    public String getNomePro() {
        return nomePro;
    }

    public void setNomePro(String nomePro) {
        String oldNomePro = this.nomePro;
        this.nomePro = nomePro;
        changeSupport.firePropertyChange("nomePro", oldNomePro, nomePro);
    }

    public String getTipoPro() {
        return tipoPro;
    }

    public void setTipoPro(String tipoPro) {
        String oldTipoPro = this.tipoPro;
        this.tipoPro = tipoPro;
        changeSupport.firePropertyChange("tipoPro", oldTipoPro, tipoPro);
    }

    public BigDecimal getPrecoPro() {
        return precoPro;
    }

    public void setPrecoPro(BigDecimal precoPro) {
        BigDecimal oldPrecoPro = this.precoPro;
        this.precoPro = precoPro;
        changeSupport.firePropertyChange("precoPro", oldPrecoPro, precoPro);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Produtos[ codPro=" + codPro + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
