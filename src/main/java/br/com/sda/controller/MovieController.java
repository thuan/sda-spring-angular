package br.com.sda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sda.model.Movie;
import br.com.sda.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findMovies() {
		return repo.findAll();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Movie findByName(@PathVariable String name) {
		return repo.findByName(name);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie movie) {
		movie.setId(null);
		return repo.saveAndFlush(movie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Movie updateMovie(@RequestBody Movie updatedMovie, @PathVariable Integer id) {
		updatedMovie.setId(id);
		return repo.saveAndFlush(updatedMovie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable Integer id) {
		repo.delete(id);
	}
}
