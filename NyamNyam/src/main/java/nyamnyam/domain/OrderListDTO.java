package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orderList")
public class OrderListDTO {
	String orderNum;
	String menuNum;
	String menuOption;
}
