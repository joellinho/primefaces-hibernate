/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.jadv.eb.MobileShoppingCart.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u14138
 */
@Entity
@Table(name = "role")
@XmlRootElement
@NamedQuery(name = "RoleDAO.findAll", query = "SELECT r FROM RoleDAO r")
public class RoleDAO implements Serializable, ICatalogItem {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
    private List<UserDAO> userDAOList;
    */
    public RoleDAO() {
    }

    public RoleDAO(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleDAO(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getItemId() {
        return this.roleId;
    }

    @Override
    public String getItemDescription() {
        return this.name;
    }
    
    /*
    @XmlTransient
    public List<UserDAO> getUserDAOList() {
        return userDAOList;
    }

    public void setUserDAOList(List<UserDAO> userDAOList) {
        this.userDAOList = userDAOList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }
    */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleDAO)) {
            return false;
        }
        RoleDAO other = (RoleDAO) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RoleDAO[ roleId=" + roleId + " ]";
    }
    
}
