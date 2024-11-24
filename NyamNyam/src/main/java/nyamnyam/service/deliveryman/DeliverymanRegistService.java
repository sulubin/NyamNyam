package nyamnyam.service.deliveryman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.DeliverymanCommand;
import nyamnyam.domain.DeliverymanDTO;
import nyamnyam.mapper.DeliverymanMapper;

@Service
public class DeliverymanRegistService {
	@Autowired
	DeliverymanMapper deliverymanMapper;
	public void execute(DeliverymanCommand deliverymanCommand) {
		DeliverymanDTO dto = new DeliverymanDTO();
		dto.setDeliverymanNum(deliverymanCommand.getDeliverymanNum());
		dto.setDeliverymanId(deliverymanCommand.getDeliverymanId());
		dto.setDeliverymanPw(deliverymanCommand.getDeliverymanPw());
		dto.setDeliverymanName(deliverymanCommand.getDeliverymanName());
		dto.setDeliverymanPhone(deliverymanCommand.getDeliverymanPhone());
		dto.setDeliverymanEmail(deliverymanCommand.getDeliverymanEmail());
		deliverymanMapper.deliverymanInserst(dto);
	}
}
