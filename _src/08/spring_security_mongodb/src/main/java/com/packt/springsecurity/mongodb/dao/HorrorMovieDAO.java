/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.springsecurity.mongodb.dao;

import com.packt.springsecurity.mongodb.documententity.HorrorMovieEntity;
import java.util.List;
public interface  HorrorMovieDAO {
    public void addHorrorMovie(HorrorMovieEntity  horrorMovie);
    public List< HorrorMovieEntity> getAllHorrorMovies();
    public void deleteHorrorMovie(Integer  horrorMovieId);
}