/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.hibernate.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anjana.m
 */
@Entity
@Table(name = "USER_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByRoleId", query = "SELECT u FROM UserRole u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "UserRole.findByUserId", query = "SELECT u FROM UserRole u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserRole.findByRole", query = "SELECT u FROM UserRole u WHERE u.role = :role")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long roleId;
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "ROLE")
    private String role;

    public UserRole() {
    }

    public UserRole(Long roleId) {
        this.roleId = roleId;
    }

    public UserRole(Long roleId, long userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.packt.springsecurity.hibernate.entity.UserRole[ roleId=" + roleId + " ]";
    }
    
}
