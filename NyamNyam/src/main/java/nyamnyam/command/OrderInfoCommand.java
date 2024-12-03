package nyamnyam.command;

import java.util.Date;

import lombok.Data;

@Data
public class OrderInfoCommand {
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
}
