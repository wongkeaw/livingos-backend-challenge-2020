package io.ong.com.domain;

import javax.persistence.PreUpdate;
import javax.persistence.PrePersist;
import java.util.ArrayList;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Book implements Serializable
{
    private static final long serialVersionUID = -8074459008778563334L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter
    private String title;
    
    @Getter
    @Setter
    private String synopsis;
    
    @Getter
    @Setter
    private String isbn10;
    
    @Getter
    @Setter
    private String isbn13;
    
    @Getter
    @Setter
    private String language;
    
    @Getter
    @Setter
    private String publisher;
    
    @Getter
    @Setter
    private String edition;
    
    @Getter
    @Setter
    @OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "book", orphanRemoval = true)
    private List<Review> review;
    
    @Getter
    @Setter
    @OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "book", orphanRemoval = true)
    private List<Price> price;
    
    @Getter
    @Setter
    private Integer soldAmount;
    
    @Getter
    @Setter
    private Integer currentAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(updatable = false)
    private Date created_At;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updated_At;
    
    public Book() {
        this.review = new ArrayList<Review>();
        this.price = new ArrayList<Price>();
    }
    
    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updated_At = new Date();
    }
    
}