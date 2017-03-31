package com.yourtion.Pattern11;

import com.yourtion.Pattern11.ex1.FavoritesService;
import com.yourtion.Pattern11.ex1.MovieDao;

/**
 * Created by Yourtion on 30/03/2017.
 */
public class MovieService {

    private MovieDao movieDao;
    private FavoritesService favoritesService;
    public MovieService(MovieDao movieDao, FavoritesService favoritesService){
        this.movieDao = movieDao;
        this.favoritesService = favoritesService;
    }
}
