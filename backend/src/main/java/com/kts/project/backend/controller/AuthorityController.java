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

import com.kts.project.backend.dto.AuthorityDTO;
import com.kts.project.backend.dto.TypeDTO;
import com.kts.project.backend.model.Authority;
import com.kts.project.backend.model.Type;
import com.kts.project.backend.service.AuthorityService;


@RestController
@RequestMapping(value="api/authorities")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
	
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AuthorityDTO>> getAllAuthorities() {
        
		List<Authority> authorities = authorityService.findAll();
        return new ResponseEntity<>(authoritiesToDTOs(authorities), HttpStatus.OK);
    }
	
	@RequestMapping(value= "/by-page",method = RequestMethod.GET)
    public ResponseEntity<Page<AuthorityDTO>> getAuthorityPageable(Pageable pageable) {
		
        Page<Authority> page = authorityService.findAll(pageable);
        List<AuthorityDTO> authorityDTOs = authoritiesToDTOs(page.toList());
        Page<AuthorityDTO> pageAuthorities = new PageImpl<>(authorityDTOs,page.getPageable(),page.getTotalElements());

        return new ResponseEntity<>(pageAuthorities, HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<AuthorityDTO> getAuthorityById(@PathVariable Long id) {      
		Authority authority = authorityService.findOne(id);
		
        if(authority == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AuthorityDTO authorityDTO = new AuthorityDTO(authority.getId(), authority.getName());
        return new ResponseEntity<>(authorityDTO, HttpStatus.OK);
    }
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorityDTO> createNewAuthority(@RequestBody AuthorityDTO authorityDTO){
        
		Authority authority = new Authority();
        try {
        	authorityDTO.setId(null);
        	authority.setName(authorityDTO.getName());
        	authority = authorityService.create(authority);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AuthorityDTO(authority.getId(), authority.getName()), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorityDTO> updateAuthority(
            @RequestBody AuthorityDTO authorityDTO, @PathVariable Long id){
		Authority authority = new Authority();
        try {
        	authority.setName(authorityDTO.getName());
        	authority = authorityService.update(authority, id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new AuthorityDTO(authority.getId(), authority.getName()), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> deleteAuthority(@PathVariable Long id){
        try {
        	authorityService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private List<AuthorityDTO> authoritiesToDTOs(List<Authority> authorities){
		List<AuthorityDTO> dtos = new ArrayList<AuthorityDTO>();
		
		for(Authority authority : authorities) {
			dtos.add(new AuthorityDTO(authority.getId(), authority.getName()));
		}
		
		return dtos;
	}
}
