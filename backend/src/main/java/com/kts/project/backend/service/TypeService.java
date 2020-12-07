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

	public Type findOne(Long id) {
		 return typeRepo.findById(id).orElse(null);
	}

	public Type update(Type entity, Long id) throws Exception {
		Type existingType = typeRepo.findById(id).orElse(null);
	        if(existingType == null){
	            throw new Exception("Cultural content category with given id doesn't exist");
	        }
	        existingType.setName(entity.getName());
	        if(typeRepo.findByNameAndIdNot(existingType.getName(), id) != null){
	            throw new Exception("Cultural content category with given name already exists");
	        }
	        return typeRepo.save(existingType);
	}

	public void delete(Long id) throws Exception {
		Type existingType = typeRepo.findById(id).orElse(null);
        if(existingType == null){
            throw new Exception("Cultural content category with given id doesn't exist");
        }
        typeRepo.delete(existingType);
		
	}
	
    
}
