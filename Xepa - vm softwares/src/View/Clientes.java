/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "clientes", catalog = "xepa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByCodCli", query = "SELECT c FROM Clientes c WHERE c.codCli = :codCli"),
    @NamedQuery(name = "Clientes.findByNomeCli", query = "SELECT c FROM Clientes c WHERE c.nomeCli = :nomeCli"),
    @NamedQuery(name = "Clientes.findByEmailCli", query = "SELECT c FROM Clientes c WHERE c.emailCli = :emailCli"),
    @NamedQuery(name = "Clientes.findByCpfCli", query = "SELECT c FROM Clientes c WHERE c.cpfCli = :cpfCli")})
public class Clientes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cli")
    private Integer codCli;
    @Basic(optional = false)
    @Column(name = "nome_cli")
    private String nomeCli;
    @Column(name = "email_cli")
    private String emailCli;
    @Column(name = "cpf_cli")
    private BigInteger cpfCli;

    public Clientes() {
    }

    public Clientes(Integer codCli) {
        this.codCli = codCli;
    }

    public Clientes(Integer codCli, String nomeCli) {
        this.codCli = codCli;
        this.nomeCli = nomeCli;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        Integer oldCodCli = this.codCli;
        this.codCli = codCli;
        changeSupport.firePropertyChange("codCli", oldCodCli, codCli);
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        String oldNomeCli = this.nomeCli;
        this.nomeCli = nomeCli;
        changeSupport.firePropertyChange("nomeCli", oldNomeCli, nomeCli);
    }

    public String getEmailCli() {
        return emailCli;
    }

    public void setEmailCli(String emailCli) {
        String oldEmailCli = this.emailCli;
        this.emailCli = emailCli;
        changeSupport.firePropertyChange("emailCli", oldEmailCli, emailCli);
    }

    public BigInteger getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(BigInteger cpfCli) {
        BigInteger oldCpfCli = this.cpfCli;
        this.cpfCli = cpfCli;
        changeSupport.firePropertyChange("cpfCli", oldCpfCli, cpfCli);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCli != null ? codCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codCli == null && other.codCli != null) || (this.codCli != null && !this.codCli.equals(other.codCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Clientes[ codCli=" + codCli + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
