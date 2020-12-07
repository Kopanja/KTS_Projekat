package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.Type;
import com.kts.project.backend.model.User;
import com.kts.project.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public User create(User entity) throws Exception {
		if(userRepo.findByEmail(entity.getEmail()) != null){
            throw new Exception("User with given email already exists");
        }
        return userRepo.save(entity);
	}

	public void delete(Long id) throws Exception {
		User existingUser = userRepo.findById(id).orElse(null);
        if(existingUser == null){
            throw new Exception("User given id doesn't exist");
        }
        userRepo.delete(existingUser);		
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public Page<User> findAll(Pageable pageable) {
		return userRepo.findAll(pageable);
	}

	public User findOne(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	public User update(User entity, Long id) throws Exception {
		User existingUser = userRepo.findById(id).orElse(null);
        if(existingUser == null){
            throw new Exception("User with given id doesn't exist");
        }
        existingUser.setEmail(entity.getEmail());
        if(userRepo.findByEmailAndIdNot(existingUser.getEmail(), id) != null){
            throw new Exception("User with given email already exists");
        }
        return userRepo.save(existingUser);
	}
}
