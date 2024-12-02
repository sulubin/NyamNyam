package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartList")
public class CartListDTO {
	CartDTO cartDTO;
	MenuDTO menuDTO;
}
