package nyamnyam.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.CartCommand;
import nyamnyam.domain.CartDTO;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.OrderMapper;

@Service
public class CartInsertService {
	@Autowired
	OrderMapper orderMapper;
	
	public void execute(CartCommand cartCommand, HttpSession session) {
		CartDTO dto = new CartDTO();
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String memberNum = auth.getUserNum();
		dto.setMenuNum(cartCommand.getMenuNum());
		dto.setCartQty(cartCommand.getCartQty());
		dto.setMemberNum(memberNum);
		orderMapper.cartInsert(dto);
	}
}
