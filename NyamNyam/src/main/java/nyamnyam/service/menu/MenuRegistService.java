package nyamnyam.service.menu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		String autoNum = mainMapper.selectAutoNum("menu", "menu_num", "menu_");
		dto.setMenuNum(autoNum);
		dto.setMenuName(menuCommand.getMenuName());
		dto.setMenuPrice(menuCommand.getMenuPrice());
		dto.setMenuIntroduction(menuCommand.getMenuIntroduction());
		dto.setMenuOrigin(menuCommand.getMenuOrigin());
		dto.setMenuKind(menuCommand.getMenuKind());
		// 1) 파일 추가
		// 경로
		URL resource = getClass().getClassLoader().getResource("/static/upload");
		System.out.println("resource : " + resource);
		String fileDir = resource.getFile();
		// String fileDir = "D:NyamNyam/target/classes/static/upload";
		// 2) 파일 관련 내용
		MultipartFile mf = menuCommand.getMenuImage();
		String originalFile = mf.getOriginalFilename();
		// 저장하기 위한 이름 짓기
		// 확장자 짓기
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		// 이름 짓기
		String storeName = UUID.randomUUID().toString().replace("-","");
		String storeFileName = storeName + extension;
		// 3) 파일 생성
		File file = new File(fileDir + "/" + storeFileName);
		try {
			mf.transferTo(file);
		} catch (IllegalStateException e) {e.printStackTrace();}
		  catch (IOException e) {e.printStackTrace();}
		dto.setMenuImage(originalFile);
		dto.setMenuStoreImage(storeFileName);
		System.out.println(resource.getFile());
		System.out.println(file);
		menuMapper.menuInsert(dto);
	}
}
