package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.Authority;
import com.kts.project.backend.model.User;
import com.kts.project.backend.model.UserAuthority;
import com.kts.project.backend.repository.UserAuthorityRepository;

@Service
public class UserAuthorityService {

	@Autowired
	UserAuthorityRepository userAuthorityRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthorityService authService;
	
	public UserAuthority create(Long userId, String role) throws Exception {
		User user = userService.findOne(userId);
		Authority authority = authService.findByName(role);
		
		UserAuthority userAuth = new UserAuthority(user,authority);
		if(userAuthorityRepo.findByAuthorityIdAndUserId(authority.getId(),user.getId()) != null){
            throw new Exception("Cultural content category with given name already exists");
        }
        return userAuthorityRepo.save(userAuth);
	}
	
	public void deleteByUser(Long userId) throws Exception {
		UserAuthority userAuth = userAuthorityRepo.findByUserId(userId);
		if(userAuth == null) {
			throw new Exception("UserAuthority with given User ID doesn't exist");
		}
		userAuthorityRepo.delete(userAuth);
		
	}
	
	public void deleteByAuthority(Long authorityId) throws Exception {
		List<UserAuthority> userAuths = userAuthorityRepo.findAllByAuthorityId(authorityId);
		if(userAuths == null) {
			throw new Exception("UserAuthority with given User ID doesn't exist");
		}
		for(UserAuthority userAuth : userAuths) {
			userAuthorityRepo.delete(userAuth);
		}
	}
}
