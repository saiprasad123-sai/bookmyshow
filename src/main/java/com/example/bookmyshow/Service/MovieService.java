package com.example.bookmyshow.Service;

import com.example.bookmyshow.Converters.MovieConverters;
import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Respository.MovieRepository;
import com.example.bookmyshow.RequestDto.movieRequestDto;
import com.example.bookmyshow.ResponseDto.MovieResponseDto;
import com.example.bookmyshow.Respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(movieRequestDto movieRequestDto) {
        Movie movie = MovieConverters.convertDtoToEntity(movieRequestDto);
        movieRepository.save(movie);
    }

    public List<MovieResponseDto> getMoviesByName(String name) {
        List<Movie> movieList = movieRepository.findAllByName(name);
        return MovieConverters.convertEntityListToDto(movieList);
    }

    public MovieResponseDto getMovieByName(String name) {
        Movie movie = movieRepository.findByName(name);
        return MovieConverters.convertEntityToDto(movie);
    }

    public List<MovieResponseDto> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return MovieConverters.convertEntityListToDto(movieList);
    }
}
