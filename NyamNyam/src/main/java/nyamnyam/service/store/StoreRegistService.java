package nyamnyam.service.store;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import nyamnyam.command.StoreCommand;
import nyamnyam.domain.StoreDTO;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.StoreMapper;

@Service
public class StoreRegistService {
	@Autowired
	MainMapper mainMapper;
	@Autowired
	StoreMapper storeMapper;
	public void execute(StoreCommand storeCommand) {
		StoreDTO dto = new StoreDTO();
		String storeNum = mainMapper.selectAutoNum("store", "store_num", "store_");
		dto.setStoreNum(storeNum);
		dto.setStoreName(storeCommand.getStoreName());
		dto.setStoreType(storeCommand.getStoreType());
		dto.setStoreAddr(storeCommand.getStoreAddr());
		dto.setStoreAddrDetail(storeCommand.getStoreAddrDetail());
		dto.setOrnerNum(storeCommand.getOrnerNum());
		// 파일 경로 찾기
		URL resource = getClass().getClassLoader().getResource("static/upload");
		String fileDir = resource.getFile();
		// 이미지 가져오기
		MultipartFile mf = storeCommand.getStoreProfileImage();
		String originalFile = mf.getOriginalFilename();
		// 저장 이름 짓기
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName + extension;
		// 파일 생성
		File file = new File(fileDir + "/" + storeFileName);
		try {
			mf.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dto.setStoreProfileImage(originalFile);
		dto.setStoreProfileStoreImage(storeFileName);
		storeMapper.storeInsert(dto);
	}
}
