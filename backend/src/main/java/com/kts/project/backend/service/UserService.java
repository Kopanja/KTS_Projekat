package com.kts.project.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.User;
import com.kts.project.backend.model.UserAuthority;
import com.kts.project.backend.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;
	
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	 @Autowired
	    private AuthenticationManager authenticationManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepo.findByEmail(username);
	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
	        } else {
	            return user;
	        }
		
	}
	
	
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


	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}


	// Funkcija pomocu koje korisnik menja svoju lozinku
    public void changePassword(String oldPassword, String newPassword) {

        // Ocitavamo trenutno ulogovanog korisnika
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User) currentUser.getPrincipal()).getEmail();

        if (authenticationManager != null) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
            return;
        }
        User user = (User) loadUserByUsername(username);

        // pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
        // ne zelimo da u bazi cuvamo lozinke u plain text formatu
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }

	
}
