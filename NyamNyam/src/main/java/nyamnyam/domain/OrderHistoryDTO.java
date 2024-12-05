package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderHistory")
public class OrderHistoryDTO {
	RowspanDTO rowspanDTO;
	OrderInfoDTO orderInfoDTO;
	OrderListDTO orderListDTO;
}
