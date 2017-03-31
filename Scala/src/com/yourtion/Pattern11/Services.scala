package com.yourtion.Pattern11

/**
  * Created by Yourtion on 30/03/2017.
  */
object Services {
  case class Movie(movieId: String, title: String)
  case class Video(movieId: String)
  case class DecoratedMovie(movie: Movie, video: Video)

  trait MovieDaoComponent {
    trait MovieDao {
      def getMovie(id: String): Movie
    }
  }

  trait FavoritesServiceComponent {
    trait FavoritesService {
      def getFavoriteVideos(id: String): Vector[Video]
    }
  }

  trait MovieDaoComponentImpl extends MovieDaoComponent {
    class MovieDaoImpl extends MovieDao {
      def getMovie(id: String): Movie = new Movie("42", "A Movie")
    }
  }

  trait FavoritesServiceComponentImpl extends FavoritesServiceComponent {
    class FavoritesServiceImpl extends FavoritesService {
      def getFavoriteVideos(id: String): Vector[Video] = Vector(new Video("1"))
    }
  }

  trait MovieServiceComponentImpl {
    this: MovieDaoComponent with FavoritesServiceComponent =>

    val favoritesService: FavoritesService
    val movieDao: MovieDao

    class MovieServiceImpl {
      def getFavoriteDecoratedMovies(userId: String): Vector[DecoratedMovie] =
        for (
          favoriteVideo <- favoritesService.getFavoriteVideos(userId);
          movie = movieDao.getMovie(favoriteVideo.movieId)
        ) yield DecoratedMovie(movie, favoriteVideo)
    }
  }

  object ComponentRegistry extends MovieServiceComponentImpl
    with FavoritesServiceComponentImpl with MovieDaoComponentImpl {
    val favoritesService = new FavoritesServiceImpl
    val movieDao = new MovieDaoImpl

    val movieService = new MovieServiceImpl
  }

  trait MovieDaoComponentTestImpl extends MovieDaoComponent {
    class MovieDaoTestImpl extends MovieDao {
      def getMovie(id: String): Movie = new Movie("43", "A Test Movie")
    }
  }

  trait FavoritesServiceComponentTestImpl extends FavoritesServiceComponent {
    class FavoritesServiceTestImpl extends FavoritesService {
      def getFavoriteVideos(id: String): Vector[Video] = Vector(new Video("2"))
    }
  }

  object TestComponentRegistery extends MovieServiceComponentImpl
    with FavoritesServiceComponentTestImpl with MovieDaoComponentTestImpl {
    val favoritesService = new FavoritesServiceTestImpl
    val movieDao = new MovieDaoTestImpl

    val movieService = new MovieServiceImpl
  }

  def run(): Unit = {
    println("Moke :")
    for(moive <- TestComponentRegistery.favoritesService.getFavoriteVideos("2")) yield println(moive)
    println(TestComponentRegistery.movieDao.getMovie("43"))
    println()

  }
}
