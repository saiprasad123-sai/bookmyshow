package com.example.bookmyshow.Respository;

import com.example.bookmyshow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    List<Theater> findByplace(String city);
}
