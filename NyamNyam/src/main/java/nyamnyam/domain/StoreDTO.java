package nyamnyam.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Alias("store")
//@Component
public class StoreDTO {
	String storeNum;
	String storeName;
	String ornerNum;
	String storeType;
	String storeAddr;
	String storeAddrDetail;
	String storePhone;
	String storeOpenTime;
	String storeIntroduction;
	String storeBannerImage;
	String storeBannerStoreImage;
	String storeProfileImage;
	String storeProfileStoreImage;
}
