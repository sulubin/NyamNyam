package nyamnyam.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StoreCommand {
	String storeNum;
	String storeName;
	String ornerNum;
	String storeType;
	String storeAddr;
	String storeAddrDetail;
	String storePhone;
	String storeOpenTime;
	String storeIntroduction;
	MultipartFile storeBannerImage;
	MultipartFile storeProfileImage;
}
