package com.kts.project.backend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.dto.TypeDTO;
import com.kts.project.backend.dto.UserDTO;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.model.User;
import com.kts.project.backend.service.UserService;
import com.kts.project.backend.util.mapper.UserMapper;

@RestController
@RequestMapping(value="api/users")
public class UserController {
	@Autowired
	UserService userService;
	UserMapper userMapper = new UserMapper();
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        
		List<User> users = userService.findAll();
        return new ResponseEntity<>(toUserDTOList(users), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/by-page",method = RequestMethod.GET)
    public ResponseEntity<Page<UserDTO>> getUserPageable(Pageable pageable) {
		
        Page<User> page = userService.findAll(pageable);
        List<UserDTO> userDTOS = toUserDTOList(page.toList());
        Page<UserDTO> pageUserDTOS = new PageImpl<>(userDTOS,page.getPageable(),page.getTotalElements());

        return new ResponseEntity<>(pageUserDTOS, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        
		User user = userService.findOne(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createNewUser(@RequestBody @Valid UserDTO userDTO){
        
		User user;
        try {
        	userDTO.setId(null);
        	System.out.println(userDTO.getId());
            user = userService.create(userMapper.toEntity(userDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        try {
            userService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(
            @RequestBody UserDTO userDTO, @PathVariable Long id){
		User user;
        try {
            user = userService.update(userMapper.toEntity(userDTO), id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }
	private List<UserDTO> toUserDTOList(List<User> users) {
        List<UserDTO> usersDTOS = new ArrayList<>();
       
        for (User user: users) {
            usersDTOS.add(userMapper.toDto(user));
        }
        return usersDTOS;
    }
	
}
