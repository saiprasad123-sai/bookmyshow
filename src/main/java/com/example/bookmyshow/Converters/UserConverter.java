package com.example.bookmyshow.Converters;

import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.RequestDto.userRequestDto;
import com.example.bookmyshow.ResponseDto.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static User convertDtoToEntity(userRequestDto userdto){
        User user = User.builder().email(userdto.getEmail())
                .phno(userdto.getPhno())
                .password(userdto.getPassword())
                .name(userdto.getName()).build();
        return user;
    }

    public static UserResponseDto convertEntityToDto(User user){
        UserResponseDto userdto = UserResponseDto.builder().email(user.getEmail())
                .phno(user.getPhno())
                .password(user.getPassword())
                .name(user.getName())
                .id(user.getId()).build();
        return userdto;
    }

    public static List<UserResponseDto> convertEntityListToDto(List<User> userList) {
        List<UserResponseDto> list = new ArrayList<>();
        for(User user:userList){
            UserResponseDto userReponseDto = UserConverter.convertEntityToDto(user);
            list.add(userReponseDto);
        }
        return list;
    }
}

