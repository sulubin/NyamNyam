package nyamnyam.command;

import lombok.Data;

@Data
public class MenuCommand {
	String menuNum;
	String menuName;
	Integer menuPrice;
	String menuContent;
	String menuOrigin;
}
