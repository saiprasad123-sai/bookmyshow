package com.example.bookmyshow.ResponseDto;

import com.example.bookmyshow.Models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDto {

    private Date showDate;

    private Date startTime;

    private Date endTime;

    private String movie;
}