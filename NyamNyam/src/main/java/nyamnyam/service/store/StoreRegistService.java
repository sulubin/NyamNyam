package nyamnyam.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		String storeNum = mainMapper.selectAutoNum("stores", "store_num", "store_");
		dto.setStoreNum(storeNum);
		dto.setStoreName(storeCommand.getStoreName());
		dto.setStoreType(storeCommand.getStoreType());
		dto.setStoreAddr(storeCommand.getStoreAddr());
		dto.setStoreAddrDetail(storeCommand.getStoreAddrDetail());
		dto.setOrnerNum(storeCommand.getOrnerNum());
		storeMapper.storeInsert(dto);
	}
}
