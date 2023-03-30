package com.example.bookmyshow.Respository;

import com.example.bookmyshow.Models.Movie;
import com.example.bookmyshow.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowRepository extends JpaRepository<Shows,Integer> {
    List<Shows> findBymovie(Movie movie);
}
