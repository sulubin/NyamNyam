package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.service.UserNumService;
import nyamnyam.service.order.INIstdpayPcReturn;

@Controller
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	INIstdpayPcReturn iniPayReturnService;
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	UserNumService userNumService;
	
	@RequestMapping("INIstdpay_pc_return")
	public String payReturn(HttpServletRequest request, HttpSession session) {
		iniPayReturnService.execute(request);
		String memberNum = userNumService.execute(session);
		orderMapper.cartDelete(null, memberNum);
		return "thymeleaf/order/buyfinished";
	}
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/order/close";
	}
}
