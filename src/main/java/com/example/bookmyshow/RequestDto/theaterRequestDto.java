package com.example.bookmyshow.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class theaterRequestDto {


    private String name;

    private String place;

    private int totalSeats;


}