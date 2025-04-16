package com.mysite.sbb.question;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.mysite.sbb.HelloController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {	
	private final QuestionRepository questionRepository;

		
		@GetMapping("/question/list")
		
		//매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
		//Model 객체는 java class와 template 간의 연결 고리 역할
		public String list(Model model) {
			List<Question> questionList = this.questionRepository.findAll();
			System.out.println("question_list  "+questionList);
			model.addAttribute("questionList", questionList);
			return "question_list";
		}

	

}
