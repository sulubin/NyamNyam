package nyamnyam.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.MenuCommand;
import nyamnyam.domain.MenuDTO;
import nyamnyam.mapper.MenuMapper;

@Service
public class MenuUpdateService {
	@Autowired
	MenuMapper menuMapper;
	public void execute(MenuCommand menuCommand) {
		MenuDTO dto = new MenuDTO();
		dto.setMenuNum(menuCommand.getMenuNum());
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		dto.setMenuKind(menuCommand.getMenuKind());
		dto.setMenuIntroduction(menuCommand.getMenuIntroduction());
		//dto.setMenuImage(menuCommand.getMenuImage());
		dto.setMenuOrigin(menuCommand.getMenuOrigin());
		menuMapper.menuUpdate(dto);
	}
}
