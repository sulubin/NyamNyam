package nyamnyam.command;

import lombok.Data;

@Data
public class OrderListCommand {
	String orderNum;
	String menuNum;
	String menuOption;
}
