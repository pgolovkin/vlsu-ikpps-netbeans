/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.vlsu.student.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author p.golovkin
 */
@Entity
@Table(name = "ws_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WsUser.findAll", query = "SELECT w FROM WsUser w")
    , @NamedQuery(name = "WsUser.findById", query = "SELECT w FROM WsUser w WHERE w.id = :id")
    , @NamedQuery(name = "WsUser.findByName", query = "SELECT w FROM WsUser w WHERE w.name = :name")
    , @NamedQuery(name = "WsUser.findByBirthday", query = "SELECT w FROM WsUser w WHERE w.birthday = :birthday")
    , @NamedQuery(name = "WsUser.findByBirthdayAndName", query = "SELECT w FROM WsUser w WHERE w.birthday = :birthday and w.name = :name")})
public class WsUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public WsUser() {
    }

    public WsUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WsUser)) {
            return false;
        }
        WsUser other = (WsUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.vlsu.student.entity.WsUser[ id=" + id + " ]";
    }
    
}
