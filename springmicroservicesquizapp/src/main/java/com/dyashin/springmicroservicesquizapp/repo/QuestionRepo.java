package com.dyashin.springmicroservicesquizapp.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dyashin.springmicroservicesquizapp.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value = "SELECT * FROM question WHERE category = :category ORDER BY RAND()", nativeQuery = true)
	List<Question> findRandomQuesByCategory(@Param("category") String category, Pageable pageable);

}
