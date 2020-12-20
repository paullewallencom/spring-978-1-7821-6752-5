package com.packt.springsecurity.mongodb.dao;

import java.util.List;
import com.packt.springsecurity.mongodb.documententity.HorrorMovieEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public class HorrorMovieDaoImpl implements HorrorMovieDAO {

    @Autowired
    private MongoTemplate mongotemplate;
    private MongoOperations mongoOperation = (MongoOperations) mongotemplate;
 private static final Logger logger = Logger.getLogger(HorrorMovieDaoImpl.class);
    @Override
    public void addHorrorMovie(HorrorMovieEntity horrormovie) {
        System.out.println(horrormovie);
        this.mongoOperation.save(horrormovie);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<HorrorMovieEntity> getAllHorrorMovies() {
        List<HorrorMovieEntity> horrorMovieList = mongoOperation.findAll(HorrorMovieEntity.class);
        return horrorMovieList;
    }

    @Override
    public void deleteHorrorMovie(Integer horrorMovieId) {
        Query searchUserQuery = new Query(Criteria.where("horrorMovieId").is("horrorMovieId"));
        mongoOperation.remove(searchUserQuery, HorrorMovieEntity.class);
    }
}
