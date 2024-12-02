package nyamnyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.StoreCommand;
import nyamnyam.domain.CartListDTO;
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.MenuDTO;
import nyamnyam.domain.StoreInfoDTO;
import nyamnyam.mapper.MenuMapper;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.order.CartListService;
import nyamnyam.service.store.StoreUpdateService;

@Controller
@RequestMapping("store")
public class StoreController {
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	StoreUpdateService storeUpdateService;
	@Autowired
	CartListService cartListService;
	
	@PostMapping("storeManage")
	public String storeManage(@RequestParam("ornerNum") String ornerNum, HttpSession session, Model model) {
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		// 가게 정보 가져오기
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);  
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		// 메뉴 정보 가져오기
		List<MenuDTO> menuList = menuMapper.selectMenuList(storeNum);
		model.addAttribute("menuList", menuList);
		return "thymeleaf/ornerView/storeMenuManagePage";
	}
	@PostMapping("storeInformationManage")
	public String storeInformationManage(@RequestParam("ornerNum") String ornerNum, HttpSession session, Model model) {
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		// 가게 정보 가져오기
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);  
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		return "thymeleaf/ornerView/storeInformationPage";
	}
	
	@PostMapping("storeModify")
	public String storeModify(StoreCommand storeCommand, HttpSession session) {
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String storeNum = storeMapper.selectStoreNum(auth.getUserNum());
		storeUpdateService.execute(storeCommand, storeNum);
		return "redirect:/orner/ornerMain";
	}
	@GetMapping("storeDetail")
	public String storeDetail(@RequestParam("storeNum") String storeNum, HttpSession session, Model model) {
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		// 메뉴 정보 가져오기
		List<MenuDTO> menuList = menuMapper.selectMenuList(storeNum);
		model.addAttribute("menuList", menuList);	
		// 카트 정보 가져오기
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		if(auth == null) {
			return "thymeleaf/store/storeDetail";
		}else {
			cartListService.execute(session, model);
			return "thymeleaf/store/storeDetail";
		}
	}
	
	
}
