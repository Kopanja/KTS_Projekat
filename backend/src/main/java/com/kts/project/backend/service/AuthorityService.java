package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.Authority;
import com.kts.project.backend.repository.AuthorityRepository;

@Service
public class AuthorityService {

	@Autowired
	AuthorityRepository authorityRepo;

	@Autowired
	UserAuthorityService userAuthService;
	
	public List<Authority> findAll() {
		return authorityRepo.findAll();
	}

	public Page<Authority> findAll(Pageable pageable) {
		return authorityRepo.findAll(pageable);
	}

	public Authority findOne(Long id) {
		return authorityRepo.findById(id).orElse(null);
	}
	
	public Authority findByName(String name) {
		return authorityRepo.findByName(name);
	}

	public Authority create(Authority authority) throws Exception {
		 if(authorityRepo.findByName(authority.getName()) != null){
	            throw new Exception("Cultural content category with given name already exists");
	        }
	        return authorityRepo.save(authority);
	}

	public Authority update(Authority entity, Long id) throws Exception {
		Authority existingAuthority = authorityRepo.findById(id).orElse(null);
        if(existingAuthority == null){
            throw new Exception("Authority with given id doesn't exist");
        }
        existingAuthority.setName(entity.getName());
        if(authorityRepo.findByNameAndIdNot(existingAuthority.getName(), id) != null){
            throw new Exception("Authority with given name already exists");
        }
        return authorityRepo.save(existingAuthority);
	}

	public void delete(Long id) throws Exception {
		Authority existingAuthority = authorityRepo.findById(id).orElse(null);
        if(existingAuthority == null){
            throw new Exception("Cultural content category with given id doesn't exist");
        }
        userAuthService.deleteByAuthority(id);
        authorityRepo.delete(existingAuthority);
		
	}
}
