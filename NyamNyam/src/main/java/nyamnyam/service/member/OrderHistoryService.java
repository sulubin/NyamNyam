package nyamnyam.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import nyamnyam.domain.OrderInfoDTO;
import nyamnyam.mapper.OrderMapper;
import nyamnyam.mapper.StoreMapper;

@Service
public class OrderHistoryService {
	@Autowired
	OrderMapper orderMapper;
	@Autowired
	StoreMapper storeMapper;
	
	public void execute(String memberNum, Model model) {
		List<OrderInfoDTO> list = orderMapper.orderInfoSelectOne(memberNum);
		model.addAttribute("list", list);
		System.out.println(list);
	}
}
