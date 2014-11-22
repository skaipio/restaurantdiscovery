/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.kapsi.skaipio.restaurantdiscovery.entity;

import fi.kapsi.skaipio.restaurantdiscovery.constraint.Link;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
@NamedQueries(value = {
    @NamedQuery(name = "Restaurant.findAll", query = "select r from Restaurant r"),
    @NamedQuery(name = "Restaurant.findById", query = "select r from Restaurant r where r.id = :id")
})
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1000L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Size(min = 1, max = 256, message = "Name should have between {min} and {max} characters")
    private String name;
    @NotNull @OneToOne
    private Address address;
    @Link (message = "Home page should be a link")
    private String homepage;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
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
        if (!(object instanceof Restaurant)) {
            return false;
        }
        Restaurant other = (Restaurant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Restaurant[ id=" + id + " ]";
    }
    
}
