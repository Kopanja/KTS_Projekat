package com.kts.project.backend.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.kts.project.backend.dto.SubTypeDTO;
import com.kts.project.backend.dto.TypeDTO;
import com.kts.project.backend.model.SubType;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.service.SubTypeService;
import com.kts.project.backend.service.TypeService;
import com.kts.project.backend.util.mapper.SubTypeMapper;
import com.kts.project.backend.util.mapper.TypeMapper;

@RestController
@RequestMapping(value =  "/api/category-types", produces = MediaType.APPLICATION_JSON_VALUE)
public class TypeController {
	@Autowired
	TypeService typeService;
	
	@Autowired
	SubTypeService subTypeService;
	
	
	TypeMapper typeMapper = new TypeMapper();
	SubTypeMapper subTypeMapper = new SubTypeMapper();
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        
		List<Type> types = typeService.findAll();
        return new ResponseEntity<>(toTypeDTOList(types), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/by-page",method = RequestMethod.GET)
    public ResponseEntity<Page<TypeDTO>> getTypePageable(Pageable pageable) {
		
        Page<Type> page = typeService.findAll(pageable);
        List<TypeDTO> typeDTOS = toTypeDTOList(page.toList());
        Page<TypeDTO> pageCulturalContentCategoryDTOS = new PageImpl<>(typeDTOS,page.getPageable(),page.getTotalElements());

        return new ResponseEntity<>(pageCulturalContentCategoryDTOS, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        
		Type type = typeService.findOne(id);
        if(type == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeMapper.toDto(type), HttpStatus.OK);
    }
	
	@RequestMapping(value="/name/{name}",method = RequestMethod.GET)
    public ResponseEntity<TypeDTO> getTypeByName(@PathVariable String name) {
        
		Type type = typeService.findByName(name);
        if(type == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeMapper.toDto(type), HttpStatus.OK);
    }

	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypeDTO> createNewType(@RequestBody TypeDTO typeDTO){
        
		Type type;
        try {
        	typeDTO.setId(null);
        	System.out.println(typeDTO.getId());
            type = typeService.create(typeMapper.toEntity(typeDTO));
            System.out.println(type.getName());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(typeMapper.toDto(type), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TypeDTO> updateType(
            @RequestBody TypeDTO typeDTO, @PathVariable Long id){
		Type type;
        try {
            type = typeService.update(typeMapper.toEntity(typeDTO), id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(typeMapper.toDto(type), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteType(@PathVariable Long id){
        try {
            typeService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private List<TypeDTO> toTypeDTOList(List<Type> categoryTypes) {
        List<TypeDTO> categoryTypeDTOS = new ArrayList<>();
       
        for (Type categoryType: categoryTypes) {
            categoryTypeDTOS.add(typeMapper.toDto(categoryType));
        }
        return categoryTypeDTOS;
    }
	
	//------------------------------SUB TYPE-----------------------------------------------------
	//Ako ih budem spajao ipak
	
	@RequestMapping(value = "/sub-types",method = RequestMethod.GET)
    public ResponseEntity<List<SubTypeDTO>> getAllSubTypes() {
        List<SubType> types = subTypeService.findAll();
        return new ResponseEntity<>(toSubTypeDTOList(types), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/sub-types/by-page",method = RequestMethod.GET)
    public ResponseEntity<Page<SubTypeDTO>> getAllCulturalContentCategories(Pageable pageable) {
        Page<SubType> page = subTypeService.findAll(pageable);
        List<SubTypeDTO> subTypeDTOS = toSubTypeDTOList(page.toList());
        Page<SubTypeDTO> pageCulturalContentCategoryDTOS = new PageImpl<>(subTypeDTOS,page.getPageable(),page.getTotalElements());

        return new ResponseEntity<>(pageCulturalContentCategoryDTOS, HttpStatus.OK);
    }
	
	@RequestMapping(value="/sub-types/{name}",method = RequestMethod.GET)
    public ResponseEntity<SubTypeDTO> getAllCulturalContentCategories(@PathVariable String name) {
        SubType type = subTypeService.findByName(name);
        if(type == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subTypeMapper.toDto(type), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{typeId}/sub-types",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypeDTO> createNewType(@PathVariable Long typeId,@RequestBody SubTypeDTO subTypeDTO){
        
		SubType subType;
        try {
        	subTypeDTO.setId(null);
        	
        	Type type = typeService.findOne(typeId);
        	TypeDTO typeDTO = typeMapper.toDto(type);
        	subTypeDTO.setParentType(typeDTO);
        	
        	subType = subTypeService.create(subTypeMapper.toEntity(subTypeDTO));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(subTypeMapper.toDto(subType), HttpStatus.CREATED);
    }
	
	private List<SubTypeDTO> toSubTypeDTOList(List<SubType> categorySubTypes) {
        List<SubTypeDTO> categorySubTypeDTOS = new ArrayList<>();
        for (SubType categoryType: categorySubTypes) {
            categorySubTypeDTOS.add(subTypeMapper.toDto(categoryType));
        }
        return categorySubTypeDTOS;
    }
	
	//CRUD Operacije za podtipove konkretnog tipa
	
	@RequestMapping(value = "/{typeId}/sub-types", method = RequestMethod.GET)
    public ResponseEntity<List<SubTypeDTO>> getAllSubTypesFromParent(@PathVariable Long typeId) {
        List<SubType> categoryTypes = subTypeService.findAll(typeId);
        return new ResponseEntity<>(toSubTypeDTOList(categoryTypes), HttpStatus.OK);
    }
	
	 @RequestMapping(value="/{typeId}/sub-types/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<SubTypeDTO> updateSubType(
	            @RequestBody SubTypeDTO subTypeDTO,@PathVariable Long typeId, @PathVariable Long id){
	        SubType subType;
	        
	        Type type = typeService.findOne(typeId);
        	TypeDTO typeDTO = typeMapper.toDto(type);
        	subTypeDTO.setParentType(typeDTO);
        	
	        try {
	            subType = subTypeService.update(subTypeMapper.toEntity(subTypeDTO), id, typeId);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        return new ResponseEntity<>(subTypeMapper.toDto(subType), HttpStatus.OK);
	    }
	 
	 @RequestMapping(value="/{typeId}/sub-types/{id}", method=RequestMethod.DELETE)
	    public ResponseEntity<Void> deleteCategoryType(@PathVariable Long typeId, @PathVariable Long id){
	        try {
	            subTypeService.delete(id, typeId);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
