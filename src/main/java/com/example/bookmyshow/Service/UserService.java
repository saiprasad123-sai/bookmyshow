package com.example.bookmyshow.Service;

import com.example.bookmyshow.Converters.UserConverter;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Respository.UserRepository;
import com.example.bookmyshow.RequestDto.userRequestDto;
import com.example.bookmyshow.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void addUser(userRequestDto userDto) throws Exception{
        try{
            User user = UserConverter.convertDtoToEntity(userDto);
            userRepository.save(user);
        }
        catch (Exception e) {
            throw new Exception();
        }
    }

    public UserResponseDto getUserById(int id) throws Exception{
        try {
            User user = userRepository.getOne(id);
            if(user!=null)
                return UserConverter.convertEntityToDto(user);
            throw new Exception();
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public List<UserResponseDto> getUsersByName(String name) {
        List<User> userList = userRepository.findAllByName(name);
        return UserConverter.convertEntityListToDto(userList);
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return UserConverter.convertEntityListToDto(userList);
    }

    public void updateUser(userRequestDto userRequestDto) throws Exception {
        try {
            User user = userRepository.findByemail(userRequestDto.getEmail());
            if(user==null)
                throw new Exception();
            user.setName(userRequestDto.getName());
            user.setPhno(userRequestDto.getPhno());
            user.setPassword(userRequestDto.getPassword());
            userRepository.save(user);
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public void deleteUser(String email,String password) throws Exception {
        try {
            User user = userRepository.findByemail(email);
            if (user == null || user.getPassword().equals(password)==false) throw new Exception();
            userRepository.delete(user);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
