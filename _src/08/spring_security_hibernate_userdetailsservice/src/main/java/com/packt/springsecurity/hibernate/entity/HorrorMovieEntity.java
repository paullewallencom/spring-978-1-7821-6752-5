package com.packt.springsecurity.hibernate.entity;

import javax.persistence.*;

@Entity (name = "HorrorMovie")
@Table(name="HORRORMOVIE")
public class  HorrorMovieEntity {
     
    @Id
    @Column(name="HORRORMOVIE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer horrormovie_id;
    @Column(name="HORRORMOVIE_NAME")
    private String horrormovie_name;
    @Column(name="HORRORMOVIE_DIRECTOR")
    private String horrormovie_director;

    public String getHorrormovie_director() {
        return horrormovie_director;
    }

    public void setHorrormovie_director(String horrormovie_director) {
        this.horrormovie_director = horrormovie_director;
    }

    public Integer getHorrormovie_id() {
        return horrormovie_id;
    }

    public void setHorrormovie_id(Integer horrormovie_id) {
        this.horrormovie_id = horrormovie_id;
    }

    public String getHorrormovie_name() {
        return horrormovie_name;
    }

    public void setHorrormovie_name(String horrormovie_name) {
        this.horrormovie_name = horrormovie_name;
    }

    public HorrorMovieEntity() {
    }
 
  
   
 
      
    
}