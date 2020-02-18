
package io.ong.com.domain;

import javax.persistence.PreUpdate;
import javax.persistence.PrePersist;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Price implements Serializable
{
    private static final long serialVersionUID = -762647383547680946L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter
    private Integer sellPrice;
    
    @Getter
    @Setter
    private String chanale;
    
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", updatable = false, nullable = false)
    @JsonIgnore
    private Book book;
    
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date created_At;
    
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated_At;
    
    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
    
   
}