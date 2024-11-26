package nyamnyam.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Alias("menu")
@AllArgsConstructor
public class MenuDTO {
	String menuNum;
	String menuName;
	Integer menuPrice;
	String menuKind;
	String menuIntroduction;
	String menuImage;
	String menuStoreImage;
	String menuOrigin;
	String storeNum;
}
