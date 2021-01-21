package com.kts.project.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.dto.ContentDTO;
import com.kts.project.backend.model.Content;
import com.kts.project.backend.service.ContentService;
import com.kts.project.backend.util.mapper.ContentMapper;

@RestController
@RequestMapping(value="api/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	ContentMapper contentMapper = new ContentMapper();
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ContentDTO>> getAllContent() {
        
		List<Content> allContent = contentService.getAll();
		//List<Content> allContent = contentService.findByUserId(1L);
		return new ResponseEntity<>(toContentDTOList(allContent), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<ContentDTO> getContentById(@PathVariable Long id) {
        
		Content content = contentService.findById(id);
        if(content == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contentMapper.toDto(content), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Content> deleteContent(@PathVariable Long id) {
		
		try {
			contentService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ContentDTO> createNewContent(@RequestBody ContentDTO contentDTO){
        
		Content newContent;
        try {
        	newContent = contentService.create(contentDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(contentMapper.toDto(newContent), HttpStatus.CREATED);
    }
	
	private List<ContentDTO> toContentDTOList(List<Content> contentList) {
        List<ContentDTO> contentDTOS = new ArrayList<>();
       
        for (Content content: contentList) {
        	contentDTOS.add(contentMapper.toDto(content));
        }
        return contentDTOS;
    }

}
