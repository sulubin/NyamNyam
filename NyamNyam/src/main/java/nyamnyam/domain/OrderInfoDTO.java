package nyamnyam.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderInfo")
public class OrderInfoDTO {
	String orderNum;
	String deliveryAddr;
	String deliveryAddrDetail;
	String deliveryPhone;
	String deliveryMessage;
	String orderMessage;
	String orderStatus;
	Date orderDate;
	Integer orderPrice;
	String memberNum;
	String storeNum;
	//List<OrderListDTO> orderListDTO;
}
