/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osmadeit.mystory.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author litem
 */
@Entity
@Table(name = "stories", catalog = "mystory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stories.findAll", query = "SELECT s FROM Stories s")
    , @NamedQuery(name = "Stories.findById", query = "SELECT s FROM Stories s WHERE s.id = :id")
    , @NamedQuery(name = "Stories.findByTitle", query = "SELECT s FROM Stories s WHERE s.title = :title")
    , @NamedQuery(name = "Stories.findByStory", query = "SELECT s FROM Stories s WHERE s.story = :story")
    , @NamedQuery(name = "Stories.findByCreatedAt", query = "SELECT s FROM Stories s WHERE s.createdAt = :createdAt")})
public class Stories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 199)
    @Column(name = "title", nullable = false, length = 199)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4999)
    @Column(name = "story", nullable = false, length = 4999)
    private String story;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Stories() {
    }

    public Stories(Integer id) {
        this.id = id;
    }

    public Stories(Integer id, String title, String story, Date createdAt) {
        this.id = id;
        this.title = title;
        this.story = story;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof Stories)) {
            return false;
        }
        Stories other = (Stories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.osmadeit.mystory.entities.Stories[ id=" + id + " ]";
    }
    
}
