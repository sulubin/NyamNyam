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
	public void execute(StoreCommand storeCommand, String storeNum) {
		StoreDTO dto = new StoreDTO();
		dto.setStoreNum(storeNum);
		dto.setStoreName(storeCommand.getStoreName());
		dto.setStoreType(storeCommand.getStoreType());
		dto.setStoreAddr(storeCommand.getStoreAddr());
		dto.setStoreAddrDetail(storeCommand.getStoreAddrDetail());
		dto.setStorePhone(storeCommand.getStorePhone());
		dto.setStoreOpenTime(storeCommand.getStoreOpenTime());
		dto.setStoreIntroduction(storeCommand.getStoreIntroduction());
		//dto.setStoreProfileImage(storeCommand.getStoreName());
		//dto.setStoreBannerImage(storeCommand.getStoreName());
		storeMapper.storeUpdate(dto);
	}
}
