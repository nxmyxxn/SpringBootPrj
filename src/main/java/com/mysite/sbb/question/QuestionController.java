package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import lombok.RequiredArgsConstructor;
import com.mysite.sbb.answer.AnswerForm;


@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {	
	//private final QuestionRepository questionRepository;
	private final QuestionService questionService;
		
		@GetMapping("/list")
		
		//매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
		//Model 객체는 java class와 template 간의 연결 고리 역할
		public String list(Model model,@RequestParam(value="page", defaultValue="0") int page) {
			//List<Question> questionList = this.questionRepository.findAll();
			Page<Question> paging = this.questionService.getList(page);
	        model.addAttribute("paging", paging);
			return "question_list";
		}
		
		@GetMapping(value="/detail/{id}")
		public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
			
			Question question = this.questionService.getQuestion(id);
	        model.addAttribute("question", question);
			
			return "question_detail";
		}
		
		@GetMapping("/create")
	    public String questionCreate(QuestionForm questionForm) {
	        return "question_form";
	    }
		
		@PostMapping("/create")
	    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
	            return "question_form";
	        }
			this.questionService.create(questionForm.getSubject(), questionForm.getContent());
	        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
	    }
		

	

}
