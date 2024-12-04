package nyamnyam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nyamnyam.domain.CartDTO;
import nyamnyam.domain.CartListDTO;
import nyamnyam.domain.OrderHistoryDTO;
import nyamnyam.domain.OrderInfoDTO;
import nyamnyam.domain.PaymentDTO;

@Mapper
public interface OrderMapper {
	public void cartInsert(CartDTO dto);
	public List<CartListDTO> cartSelectAll(String memberNum);
	public void cartDelete(@Param("menuNum") String menuNum, @Param("memberNum") String memberNum);
	public void orderInfoInsert(OrderInfoDTO dto);
	public void paymentInsert(PaymentDTO dto);
	public OrderInfoDTO orderSelectOne(String orderNum);
	public void orderListInsert(@Param("orderNum") String orderNum, @Param("menuNum") String menuNum);
	public List<OrderInfoDTO> orderInfoSelectOne(String memberNum);
}
