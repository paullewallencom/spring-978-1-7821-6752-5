package com.packt.springsecurity.mongodb.documententity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "horrormovie")
public class  HorrorMovieEntity {
     
   
  @Id
    private Integer horrormovie_id;
    
    private String horrormovie_name;
    
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