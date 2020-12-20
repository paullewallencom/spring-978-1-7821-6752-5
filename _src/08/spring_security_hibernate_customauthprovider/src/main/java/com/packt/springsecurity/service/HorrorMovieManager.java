package com.packt.springsecurity.service;

import java.util.List;

import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;

public interface HorrorMovieManager {
	public void addHorrorMovie(HorrorMovieEntity horrorMovie);
    public List<HorrorMovieEntity> getAllHorrorMovies();
    public void deleteHorrorMovie(Integer horrorMovieId);
}
