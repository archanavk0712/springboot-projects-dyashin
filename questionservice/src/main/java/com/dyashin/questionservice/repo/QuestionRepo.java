package com.dyashin.questionservice.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dyashin.questionservice.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query(value = "SELECT id FROM question WHERE category = :category ORDER BY RAND()", nativeQuery = true)
	List<Integer> findRandomQuesByCategory(@Param("category") String category, Pageable pageable);

}
