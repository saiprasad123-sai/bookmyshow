package com.example.bookmyshow.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private int id;

    private String name;

    private String email;

    private long phno;

    private String password;
}
