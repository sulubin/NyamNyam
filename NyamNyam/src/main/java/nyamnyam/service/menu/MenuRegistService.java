package nyamnyam.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.MenuCommand;
import nyamnyam.domain.MenuDTO;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.MenuMapper;

@Service
public class MenuRegistService {
	@Autowired
	MenuMapper menuMapper;
	@Autowired
	MainMapper mainMapper;
	public void execute(MenuCommand menuCommand) {
		MenuDTO dto = new MenuDTO();
		String autoNum = mainMapper.selectAutoNum("menus", "menu_num", "menu_");
		dto.setMenuNum(autoNum);
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		dto.setMenuContent(menuCommand.getMenuContent());
		dto.setMenuOrigin(menuCommand.getMenuOrigin());
		menuMapper.menuInsert(dto);
	}
}
