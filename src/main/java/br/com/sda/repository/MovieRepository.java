package br.com.sda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sda.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("SELECT m FROM Movie m WHERE m.name = ?1")
	Movie findByName(String name);
	
	@Query("SELECT m FROM Movie m WHERE m.favorite = ?1")
	List<Movie> findFavorites(Boolean favorite);

}
