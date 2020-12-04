package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kts.project.backend.model.SubType;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.repository.SubTypeRepository;

@Service
public class SubTypeService {

	@Autowired
	SubTypeRepository subTypeRepo;
	
	public List<SubType> findAll() {

        return subTypeRepo.findAll();
    }
	
	  public Page<SubType> findAll(Pageable pageable) {
	        return subTypeRepo.findAll(pageable);
	    }
	
	public SubType findByName(String name){
		return subTypeRepo.findByName(name);
	}

	public SubType create(SubType entity) throws Exception {
		if(subTypeRepo.findByName(entity.getName()) != null){
            throw new Exception("Cultural content category with given name already exists");
        }
        return subTypeRepo.save(entity);
	}
}
