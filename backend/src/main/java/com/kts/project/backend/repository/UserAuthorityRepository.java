package com.kts.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.UserAuthority;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

	UserAuthority findByAuthorityIdAndUserId(Long id, Long id2);

	UserAuthority findByUserId(Long userId);
	
	List<UserAuthority> findAllByAuthorityId(Long id);

}
