package nyamnyam.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.OrderInfoCommand;
import nyamnyam.domain.OrderInfoDTO;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.service.AutoNumService;
import nyamnyam.service.UserNumService;

@Service
public class OrderInfoInsertService {
	@Autowired
	AutoNumService autoNumservice;
	@Autowired
	UserNumService userNumService;
	@Autowired
	CartListService cartListService;
	@Autowired
	OrderMapper orderMapper;
	
	public void execute(OrderInfoCommand orderInfoCommand, HttpSession session, Model model) {
		OrderInfoDTO dto = new OrderInfoDTO();
		String orderNum = autoNumservice.execute("order_info", "order_num", "order_", model);
		String memberNum = userNumService.execute(session);
		dto.setOrderNum(orderNum);
		dto.setDeliveryAddr(orderInfoCommand.getDeliveryAddr());
		dto.setDeliveryAddrDetail(orderInfoCommand.getDeliveryAddrDetail());
		dto.setDeliveryPhone(orderInfoCommand.getDeliveryPhone());
		dto.setDeliveryMessage(orderInfoCommand.getDeliveryMessage());
		dto.setOrderMessage(orderInfoCommand.getOrderMessage());
		dto.setOrderPrice(orderInfoCommand.getOrderPrice());
		dto.setMemberNum(memberNum);
		
		orderMapper.orderInfoInsert(dto);
	}
}
