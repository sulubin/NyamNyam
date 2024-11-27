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
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.MenuDTO;
import nyamnyam.domain.StoreInfoDTO;
import nyamnyam.mapper.MenuMapper;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.store.ChangeStoreImageService;

@Controller
@RequestMapping("store")
public class StoreController {
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	ChangeStoreImageService changeStoreImageService;
	
	@PostMapping("storeManage")
	public String storeManage(@RequestParam("ornerNum") String ornerNum, HttpSession session, Model model) {
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		// 가게 정보 가져오기
		StoreInfoDTO storeInfoDTO = storeMapper.selectStoreInfoList(storeNum);  
		model.addAttribute("storeInfoDTO", storeInfoDTO);
		// 메뉴 정보 가져오기
		List<MenuDTO> menuList = menuMapper.selectMenuList(storeNum);
		//System.out.println("메뉴 정보 : " + menuList);
		model.addAttribute("menuList", menuList);
		return "thymeleaf/ornerView/storeManagePage";
	}
	
	@GetMapping("changeProfileImage")
	public String changeProfileImage() {
		return "thymeleaf/store/profileImageForm";
	}
	@PostMapping("changeStoreImage")
	public void changeProfileImage(StoreCommand storeComamd, HttpSession session) {
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String ornerNum = auth.getUserNum();
		String storeNum = storeMapper.selectStoreNum(ornerNum);
		//changeStoreImageService.execute(storeCommand);
	};
}
