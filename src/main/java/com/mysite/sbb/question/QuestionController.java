package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
		
		@GetMapping("/list")
		
		//매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
		//Model 객체는 java class와 template 간의 연결 고리 역할
		public String list(Model model) {
			//List<Question> questionList = this.questionRepository.findAll();
			List<Question> questionList = this.questionService.getList();
			System.out.println("question_list  "+questionList);
			model.addAttribute("questionList", questionList);
			return "question_list";
		}
		
		@GetMapping(value="/detail/{id}")
		public String detail(Model model, @PathVariable("id") Integer id) {
			
			Question question = this.questionService.getQuestion(id);
	        model.addAttribute("question", question);
			
			return "question_detail";
		}
		
		@GetMapping("/create")
	    public String questionCreate() {
	        return "question_form";
	    }
		
		@PostMapping("/create")
	    public String questionCreate(@RequestParam(value="subject") String subject, @RequestParam(value="content") String content) {
			this.questionService.create(subject, content);
	        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
	    }
		

	

}
