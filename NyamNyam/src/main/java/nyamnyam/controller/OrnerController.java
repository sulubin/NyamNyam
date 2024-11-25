package nyamnyam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nyamnyam.command.MenuCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.StoreInfoDTO;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.menu.MenuRegistService;

@Controller
@RequestMapping("orner")
public class OrnerController {
	@Autowired
	MenuRegistService menuRegistService;
	@Autowired
	StoreMapper storeMapper;
	
	@GetMapping("ornerMain")
	public String ornerMain(HttpSession session, Model model) {
		// session에서 정보 가져오기
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String ornerNum = auth.getUserNum();
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		System.out.println(ornerNum);
		System.out.println(storeNum);
		// model로 뿌리기
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);  
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		return "thymeleaf/OrnerView/ornerMainPage";
	}
	@PostMapping("storeManage")
	public String storeManage(@RequestParam("ornerNum") String ornerNum) {
		return "thymeleaf/ornerView/storeManagePage";
	}
	@GetMapping("menuRegist")
	public String menuAdd() {
		return "thymeleaf/ornerView/menuForm";
	}
	@PostMapping("menuRegist")
	public void menuRegist(MenuCommand menuCommand, HttpServletResponse response) {
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
