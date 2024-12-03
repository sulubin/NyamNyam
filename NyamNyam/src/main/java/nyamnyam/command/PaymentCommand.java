package nyamnyam.command;

import lombok.Data;

@Data
public class PaymentCommand {
	String orderNum;
	String confirmNum;
	String cardNum;
	String tid;
	String totalPrice;
	String resultMessage;
	String payMethod;
	String applDate;
	String applTime;
}
