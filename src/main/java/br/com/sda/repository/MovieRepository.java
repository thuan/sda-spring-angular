package br.com.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sda.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("SELECT m FROM Movie m WHERE m.name = ?1")
	Movie findByName(String name);

}
