package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("menu")
public class MenuDTO {
	String menuNum;
	String menuName;
	Integer menuPrice;
	String menuContent;
	String menuOrigin;
}
