package nyamnyam.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.mapper.MenuMapper;

@Service
public class MenuDeleteService {
	@Autowired
	MenuMapper menuMapper;
	public void execute(String menuNum) {
		menuMapper.menuDelete(menuNum);
	}
}
