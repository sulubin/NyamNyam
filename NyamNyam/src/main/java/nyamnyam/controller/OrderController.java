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
import nyamnyam.command.CartCommand;
import nyamnyam.command.OrderInfoCommand;
import nyamnyam.domain.CartListDTO;
import nyamnyam.domain.LoginDTO;
import nyamnyam.domain.MenuDTO;
import nyamnyam.mapper.MenuMapper;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.service.AutoNumService;
import nyamnyam.service.UserNumService;
import nyamnyam.service.order.CartInsertService;
import nyamnyam.service.order.CartListService;
import nyamnyam.service.order.IniPayReqService;
import nyamnyam.service.order.OrderInfoInsertService;

@Controller
@RequestMapping("order")
public class OrderController {
	@Autowired
	CartInsertService cartInsertService;
	@Autowired
	CartListService cartListService;
	@Autowired
	OrderInfoInsertService orderInfoInsertService;
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	UserNumService userNumService;
	@Autowired
	IniPayReqService iniPayReqService;
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
	
	@GetMapping("menuOrder")
	public String menuOrder(HttpSession session, Model model) {
		String memberNum = userNumService.execute(session);
		List<CartListDTO> list = orderMapper.cartSelectAll(memberNum);
		model.addAttribute("list", list);
		cartListService.execute(session, model);
		return "thymeleaf/order/menuOrderPage";
	}
	
	@PostMapping("menuOrder")
	public String menuOrder(OrderInfoCommand orderInfoCommad, HttpSession session, Model model) {
		String orderNum = autoNumService.execute("order_info", "order_num", "order_", model);
		orderInfoInsertService.execute(orderInfoCommad, session, model);
		try {
			iniPayReqService.execute(orderNum, model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/order/orderPayment";
	}
	
}
