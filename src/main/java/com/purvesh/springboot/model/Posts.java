package com.purvesh.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "posts")
@NamedQueries({
        @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p")})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_id")
    private Integer postId;
    @Size(max = 455)
    @Column(name = "post_title")
    private String postTitle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "post_body")
    private String postBody;
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Column(name = "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @JoinColumn(name = "published_by", referencedColumnName = "user_id")
    private Users publishedBy;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postId != null ? postId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.postId == null && other.postId != null) || (this.postId != null && !this.postId.equals(other.postId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.blog.models.Posts[ postId=" + postId + " ]";
    }
}