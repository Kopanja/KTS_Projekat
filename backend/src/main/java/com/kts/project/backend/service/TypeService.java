package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.Type;
import com.kts.project.backend.repository.TypeRepository;

@Service
public class TypeService {

	@Autowired
	TypeRepository typeRepo;
	
	
	public List<Type> findAll() {

        return typeRepo.findAll();
    }
	
	  public Page<Type> findAll(Pageable pageable) {
	        return typeRepo.findAll(pageable);
	    }
	
	
	public Type findByName(String name){
		return typeRepo.findByName(name);
	}

	public Type create(Type entity) throws Exception {
		 if(typeRepo.findByName(entity.getName()) != null){
	            throw new Exception("Cultural content category with given name already exists");
	        }
	        return typeRepo.save(entity);
	}
}
