package com.example.bookmyshow.Respository;

import com.example.bookmyshow.Models.TheaterSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeat,Integer> {
    public TheaterSeat findByseatNo(String seatNo);
}
