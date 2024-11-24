package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("deliveryman")
public class DeliverymanDTO {
	String deliverymanNum;
	String deliverymanId;
	String deliverymanPw;
	String deliverymanName;
	String deliverymanPhone;
	String deliverymanEmail;
}
