package nyamnyam.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.StoreCommand;
import nyamnyam.domain.StoreDTO;
import nyamnyam.mapper.StoreMapper;

@Service
public class StoreUpdateService {
	@Autowired
	StoreMapper storeMapper;
	public void execute(StoreCommand storeCommand) {
		StoreDTO dto = new StoreDTO();
		dto.setStoreNum(storeCommand.getStoreNum());
		dto.setStoreName(storeCommand.getStoreName());
		dto.setStoreType(storeCommand.getStoreName());
		dto.setStoreAddr(storeCommand.getStoreName());
		dto.setStoreAddrDetail(storeCommand.getStoreName());
		dto.setStorePhone(storeCommand.getStoreName());
		dto.setStoreOpenTime(storeCommand.getStoreName());
		dto.setStoreIntroduction(storeCommand.getStoreIntroduction());
		dto.setStoreProfileImage(storeCommand.getStoreName());
		dto.setStoreBannerImage(storeCommand.getStoreName());
		storeMapper.storeUpdate(dto);
	}
}
