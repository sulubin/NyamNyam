package nyamnyam.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderHistory")
public class OrderHistoryDTO {
	//String storeName;
	//List<String> menuName;
	OrderInfoDTO orderInfoDTO;
	//List<OrderListDTO> orderListDTO;
}
