package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

//Question 엔티티로 레포지토리 생성
//Question 기본 entity가 Integer
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);
}
