package nyamnyam.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import nyamnyam.domain.CartListDTO;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.OrderMapper;

@Service
public class CartListService {
	@Autowired
	OrderMapper orderMapper;
	public Integer execute(HttpSession session, Model model) {
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		List<CartListDTO> cartList = orderMapper.cartSelectAll(auth.getUserNum());
		model.addAttribute("cartList", cartList);
		Integer totPrice = 0;
		for(CartListDTO dto : cartList) {
			totPrice += dto.getCartDTO().getCartQty() * dto.getMenuDTO().getMenuPrice();
		}
		model.addAttribute("totPrice", totPrice);
		return totPrice;
	}
}
