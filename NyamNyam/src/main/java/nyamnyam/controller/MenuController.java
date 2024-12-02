package nyamnyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nyamnyam.command.MenuCommand;
import nyamnyam.domain.MenuDTO;
import nyamnyam.mapper.MenuMapper;
import nyamnyam.service.menu.MenuDeleteService;
import nyamnyam.service.menu.MenuRegistService;
import nyamnyam.service.menu.MenuUpdateService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Autowired
	MenuRegistService menuRegistService;
	@Autowired
	MenuDeleteService menuDeleteService;
	@Autowired
	MenuUpdateService menuUpdateService;
	@Autowired
	MenuMapper menuMapper;
	
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
	@PostMapping("menuModify")
	public String menuModify(@RequestParam("menuNum") String menuNum, Model model) {
		MenuDTO dto = menuMapper.selectMenuOne(menuNum);
		model.addAttribute("dto", dto);
		return "thymeleaf/menu/menuModifyForm";
	}
	@PostMapping("menuUpdate")
	public String menuUpdate(MenuCommand menuCommand, HttpServletResponse response) {
		menuUpdateService.execute(menuCommand);
		return "redirect:/orner/ornerMain";
	}
}
