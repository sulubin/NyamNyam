package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.OrnerCommand;
import nyamnyam.command.StoreCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.StoreInfoDTO;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.menu.MenuRegistService;
import nyamnyam.service.orner.OrnerRegistService;
import nyamnyam.service.store.StoreRegistService;

@Controller
@RequestMapping("orner")
public class OrnerController {
	@Autowired
	MenuRegistService menuRegistService;
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	OrnerRegistService ornerRegistService;
	@Autowired
	StoreRegistService storeRegistService;
	
	@GetMapping("ornerMain")
	public String ornerMain(HttpSession session, Model model) {
		// session에서 정보 가져오기
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String ornerNum = auth.getUserNum();
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		// model로 뿌리기
		//StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);  
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		return "thymeleaf/OrnerView/ornerMainPage";
	}
	
	@PostMapping("ornerRegist")
	public String ornerRegist(OrnerCommand ornerCommand, StoreCommand storeCommand) {
		ornerRegistService.execute(ornerCommand);
		storeRegistService.execute(storeCommand);
		return "redirect:/employee/employeeMain";
	}
	
	@PostMapping("orderManage")
	public String orderManage(@RequestParam("ornerNum") String ornerNum) {
		return "thymeleaf/OrnerView/orderManagePage";
	}
}
