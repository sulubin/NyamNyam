package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.CartCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.MenuDTO;
import nyamnyam.mapper.MenuMapper;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.service.order.CartInsertService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	CartInsertService cartInsertService;
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	OrderMapper orderMapper;
	
	@PostMapping("cartForm")
	public String cartForm(@RequestParam("menuNum") String menuNum, Model model) {
		model.addAttribute("menuNum", menuNum);
		return "thymeleaf/order/cartForm";
	}
	
	@PostMapping("cartAdd")
	public String cartAdd(CartCommand cartCommand, HttpSession session, Model model) {
		cartInsertService.execute(cartCommand, session);
		MenuDTO menu = menuMapper.selectMenuOne(cartCommand.getMenuNum());
		return "redirect:/store/storeDetail?storeNum=" + menu.getStoreNum();
	}
	
	@PostMapping("cartDel")
	public String cartDel(@RequestParam("menuNum") String menuNum, HttpSession session, Model model) {
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		orderMapper.cartDelete(menuNum, memberNum);
		MenuDTO menu = menuMapper.selectMenuOne(menuNum);
		return "redirect:/store/storeDetail?storeNum=" + menu.getStoreNum();
	}
	
	@PostMapping("menuOrder")
	public String menuOrder() {
		return "thymeleaf/order/menuOrderPage";
	}
}
