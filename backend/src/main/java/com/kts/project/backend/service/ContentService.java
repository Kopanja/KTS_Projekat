package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.dto.ContentDTO;
import com.kts.project.backend.dto.SubscriptionDTO;
import com.kts.project.backend.model.Content;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.repository.ContentRepository;

@Service
public class ContentService {

	@Autowired
	ContentRepository contentRepo;
	
	public List<Content> getAll() {
		return contentRepo.findAll();
	}

	public Content findById(Long id) {
		return contentRepo.findById(id).orElse(null);
	}

	public void delete(Long id) throws Exception {
		Content content = contentRepo.findById(id).orElse(null);
        if(content == null){
            throw new Exception("User given id doesn't exist");
        }
        contentRepo.delete(content);		
	}
	
	public Content create(ContentDTO ContentDTO) {
		Content newContent = new Content();

        return contentRepo.save(newContent);
	}
	
	public List<Content> findByUserId(Long id) {
		return contentRepo.findByUserId(id);
	}
}
