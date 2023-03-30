package com.example.bookmyshow.Converters;

import com.example.bookmyshow.Models.Shows;
import com.example.bookmyshow.RequestDto.ShowRequestDto;
import com.example.bookmyshow.ResponseDto.ShowResponseDto;
import java.util.*;
public class ShowConverter {
    public static Shows convertDtoToEntity(ShowRequestDto showRequestDto){
        Shows shows = Shows.builder()
                .showDate(showRequestDto.getShowDate())
                .startTime(showRequestDto.getStartTime())
                .endTime(showRequestDto.getEndTime()).build();
        return shows;
    }

    public static List<ShowResponseDto> convertEntityListToDto(List<Shows> showsList){
        List<ShowResponseDto> showResponseDtos = new ArrayList<>();
        for(Shows shows:showsList){
            ShowResponseDto showResponseDto = ShowResponseDto.builder()
                    .movie(shows.getMovie().getName())
                    .startTime(shows.getStartTime())
                    .endTime(shows.getEndTime())
                    .showDate(shows.getShowDate()).build();
            showResponseDtos.add(showResponseDto);
        }
        return showResponseDtos;
    }
}