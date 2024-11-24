package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.DeliverymanDTO;

@Mapper
public interface DeliverymanMapper {
	public void deliverymanInserst(DeliverymanDTO dto);
}
