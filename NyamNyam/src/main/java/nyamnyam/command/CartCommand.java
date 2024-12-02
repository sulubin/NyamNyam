package nyamnyam.command;

import lombok.Data;

@Data
public class CartCommand {
	String menuNum;
	String memberNum;
	Integer cartQty;
}
