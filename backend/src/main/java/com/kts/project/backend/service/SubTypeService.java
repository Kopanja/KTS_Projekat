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

	public List<SubType> findAll(Long categoryId) {
		return subTypeRepo.findByTypeId(categoryId);
	}

	public SubType update(SubType entity, Long id, Long typeId) throws Exception {
		SubType existingSubType = null;
		existingSubType =  subTypeRepo.findByTypeIdAndId(typeId, id);
        if(existingSubType == null){
            throw new Exception("Category type with given id doesn't exist");
        }
        existingSubType.setName(entity.getName());
        if(subTypeRepo.findByNameAndIdNot(existingSubType.getName(), id) != null){
            throw new Exception("Category type with given name already exists");
        }
        return subTypeRepo.save(existingSubType);
	}

	public void delete(Long id, Long typeId) throws Exception {
		SubType existingCategoryType = subTypeRepo.findByTypeIdAndId(typeId, id);
        if(existingCategoryType == null){
            throw new Exception("Category type with given id doesn't exist");
        }
        subTypeRepo.delete(existingCategoryType);		
	}
}
