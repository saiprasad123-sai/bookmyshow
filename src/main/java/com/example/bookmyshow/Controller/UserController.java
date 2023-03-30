package com.example.bookmyshow.Controller;

import com.example.bookmyshow.RequestDto.userRequestDto;
import com.example.bookmyshow.ResponseDto.UserResponseDto;
import com.example.bookmyshow.ResponseDto.UserResponseDto;
import com.example.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> addUser(@RequestBody userRequestDto userDto){
        try {
            userService.addUser(userDto);
            return new ResponseEntity<>("successfully added user", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("error in creating user",HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getById")
    public ResponseEntity<UserResponseDto> getUserById(@RequestParam int id){
        try{
            return new ResponseEntity<>(userService.getUserById(id),HttpStatus.FOUND);
        }
        catch (Exception e){
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<UserResponseDto>> getUsersByName(@RequestParam String name){
        List<UserResponseDto> list = userService.getUsersByName(name);

        return new ResponseEntity<>(list,HttpStatus.OK);

    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> list = userService.getAllUsers();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody userRequestDto userRequestDto){
        try{
            userService.updateUser(userRequestDto);
            return new ResponseEntity<>("user is updated successfully"+userRequestDto,HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>("User is valid",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("email") String email,@RequestParam String password){
        try{
            userService.deleteUser(email,password);
            return new ResponseEntity<>("The given user is deleted successfull",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("The given user is not existing or the password is incorrect",HttpStatus.BAD_REQUEST);
        }
    }


}
