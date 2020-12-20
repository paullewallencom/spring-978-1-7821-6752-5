package com.packt.springsecurity.dao;

import java.util.List;
import com.packt.springsecurity.hibernate.entity.HorrorMovieEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;




@Repository
public class HorrorMovieDaoImpl implements HorrorMovieDAO  {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public void addHorrorMovie(HorrorMovieEntity horrormovie) {
		this.sessionFactory.getCurrentSession().save(horrormovie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HorrorMovieEntity> getAllHorrorMovies() {
		return this.sessionFactory.getCurrentSession().createQuery("from HorrorMovie").list();
	}

	@Override
	public void deleteHorrorMovie(Integer horrorMovieId) {
		HorrorMovieEntity horrorMovie = (HorrorMovieEntity) sessionFactory.getCurrentSession().load(HorrorMovieEntity.class, horrorMovieId);
        if (null != horrorMovie) {
        	this.sessionFactory.getCurrentSession().delete(horrorMovie);
        }
	}
}
