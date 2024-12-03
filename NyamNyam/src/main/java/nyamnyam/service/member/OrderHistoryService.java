package nyamnyam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.mapper.OrderMapper;

@Service
public class OrderHistoryService {
	@Autowired
	OrderMapper orderMapper;
	public void execute(String memberNum) {
		orderMapper.orderHistorySelectAll(memberNum);
	}
}
