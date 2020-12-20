package com.packt.springsecurity.mongodb.manager;

import com.packt.springsecurity.mongodb.documententity.HorrorMovieEntity;
import java.util.List;



public interface HorrorMovieManager {
	public void addHorrorMovie(HorrorMovieEntity horrorMovie);
    public List<HorrorMovieEntity> getAllHorrorMovies();
    public void deleteHorrorMovie(Integer horrorMovieId);
}
