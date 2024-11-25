package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("storeInfo")
public class StoreInfoDTO {
	StoreDTO storeDTO;
	MenuDTO menuDTO;
	OrnerDTO ornerDTO;
}
