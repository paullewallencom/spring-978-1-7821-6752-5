package com.packt.springsecurity.mongodb.manager;


import com.packt.springsecurity.mongodb.dao.HorrorMovieDAO;
import com.packt.springsecurity.mongodb.documententity.HorrorMovieEntity;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HorrorMovieManagerImpl implements HorrorMovieManager {
	
	@Autowired
    private HorrorMovieDAO horrorMovieDAO;

	@Override
	@Transactional
	public void addHorrorMovie( HorrorMovieEntity  horrorMovie) {
		 horrorMovieDAO.addHorrorMovie(horrorMovie);
	}

	@Override
	@Transactional
	public List<HorrorMovieEntity> getAllHorrorMovies() {
		return horrorMovieDAO.getAllHorrorMovies();
	}

	@Override
	@Transactional
	public void deleteHorrorMovie(Integer horrorMovieId) {
		horrorMovieDAO.deleteHorrorMovie(horrorMovieId);
	}

	public void setHorrorMovieDAO(HorrorMovieDAO horrorMovieDAO) {
		this.horrorMovieDAO = horrorMovieDAO;
	}
}
