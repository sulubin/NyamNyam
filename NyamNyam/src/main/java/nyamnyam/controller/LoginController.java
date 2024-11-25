package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.LoginCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.login.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	MainMapper mainMapper;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	LoginService loginService;
	
	@PostMapping("login")
	public String login(LoginCommand loginCommand, HttpSession session, Model model) {
		// 로그인하기
		loginService.execute(loginCommand, session);
		// loginCommand에 입력된 값으로 user정보 가져오기
		LoginDTO dto = mainMapper.selectUserInfo(loginCommand.getUserId());
		// if문을 통해 userNum과 관련된 페이지를 return 하기	
		String grade = dto.getGrade();
		if(grade.equals("member")) return "thymeleaf/memberView/memberMainPage";
		else if(grade.equals("employee")) return "redirect:/employee/employeeMain";//"thymeleaf/employeeView/employeeMainPage";
		else if(grade.equals("orner")) {
			return "redirect:/orner/ornerMain";
		}
		else return "thymeleaf/deliverymanView/deliverymanMainPage";
	}
}
