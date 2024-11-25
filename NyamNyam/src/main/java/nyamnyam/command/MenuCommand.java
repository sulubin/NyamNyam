package nyamnyam.command;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MenuCommand {
	String menuNum;
	String menuName;
	Integer menuPrice;
	String menuKind;
	String menuIntroduction;
	MultipartFile menuImage;
	String menuOrigin;
	String storeNum;
}
