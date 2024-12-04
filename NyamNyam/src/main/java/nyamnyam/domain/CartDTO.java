package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cart")
public class CartDTO {
	String menuNum;
	String memberNum;
	String menuOption;
	Integer cartQty;
}
