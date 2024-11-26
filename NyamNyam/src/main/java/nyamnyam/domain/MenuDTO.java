package nyamnyam.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("menu")
@AllArgsConstructor
@NoArgsConstructor
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
