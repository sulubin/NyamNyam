package nyamnyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nyamnyam.command.MenuCommand;
import nyamnyam.service.menu.MenuDeleteService;
import nyamnyam.service.menu.MenuRegistService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	MenuRegistService menuRegistService;
	@Autowired
	MenuDeleteService menuDeleteService;
	
	@GetMapping("menuRegist")
	public String menuAdd() {
		return "thymeleaf/menu/menuForm";
	}
	@PostMapping("menuRegist")
	public void menuRegist(@Validated MenuCommand menuCommand, HttpServletResponse response, HttpSession session) {
		menuRegistService.execute(menuCommand, session);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>";
				  str += "	window.self.close();";
				  str += "  window.opener.parent.location.reload();";
				  str += "</script>";
			out.print(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("menuDelete")
	public void menuDelte(String menuNum) {
		menuDeleteService.execute(menuNum);
	}
	@GetMapping("menuDetail")
	public String menuDetail(String menuNum) {
		return "thymeleaf/menu/menuDetail";
	}
}
