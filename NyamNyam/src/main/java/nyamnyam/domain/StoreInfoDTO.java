package nyamnyam.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("storeInfo")
public class StoreInfoDTO {
	StoreDTO storeDTO;
	OrnerDTO ornerDTO;
}
