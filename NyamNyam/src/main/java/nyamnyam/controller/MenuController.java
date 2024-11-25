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
import nyamnyam.command.MenuCommand;
import nyamnyam.service.menu.MenuRegistService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	MenuRegistService menuRegistService;
	
	@GetMapping("menuRegist")
	public String menuAdd() {
		return "thymeleaf/ornerView/menuForm";
	}
	@PostMapping("menuRegist")
	public void menuRegist(@Validated MenuCommand menuCommand, HttpServletResponse response) {
		System.out.println("서비스마저 못가는중");
		menuRegistService.execute(menuCommand);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			String str = "<script>";
				  str += "	window.self.close()";
				  str += "</script>";
			out.print(str);
			out.close();
			System.out.println("창이 닫혔어요");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
