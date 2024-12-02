package nyamnyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nyamnyam.command.LoginCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.ClosePopupService;
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
	@Autowired
	ClosePopupService closePopupService;
	
	@GetMapping("login")
	public String login() {
		return "thymeleaf/login/loginPage";
	}
	
	@GetMapping("loginPopup")
	public String loginPopup() {
		return "thymeleaf/login/loginPopup";
	}
	@PostMapping("login")
	public String login(LoginCommand loginCommand, HttpSession session, Model model) {
		// 로그인하기
		loginService.execute(loginCommand, session);
		// loginCommand에 입력된 값으로 user정보 가져오기
		LoginDTO dto = mainMapper.selectUserInfo(loginCommand.getUserId());
		// if문을 통해 userNum과 관련된 페이지를 return 하기	
		String grade = dto.getGrade();
		if(grade.equals("member")) return "redirect:/";
		else if(grade.equals("employee")) return "redirect:/employee/employeeMain";//"thymeleaf/employeeView/employeeMainPage";
		else if(grade.equals("orner")) {
			return "redirect:/orner/ornerMain";
		}
		else return "thymeleaf/deliverymanView/deliverymanMainPage";
	}
	@PostMapping("loginPopup")
	public void loginPopup(LoginCommand loginCommand, HttpServletResponse response, HttpSession session, Model model) {
		loginService.execute(loginCommand, session);
		LoginDTO dto = mainMapper.selectUserInfo(loginCommand.getUserId());
		String grade = dto.getGrade();
		if(grade.equals("member")) {
			closePopupService.execute(response, true, session);
		}
		else {
			closePopupService.execute(response, false, session);
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
