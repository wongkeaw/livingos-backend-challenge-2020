
package io.ong.com.domain;

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
public class Review implements Serializable
{
    private static final long serialVersionUID = -8061834813457728226L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    
    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", updatable = false, nullable = false)
    @JsonIgnore
    private Book book;
    
    @Getter
    @Setter
    private Integer score;
    
    @Getter
    @Setter
    private String description;
    
    
}
