package nyamnyam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.StoreDTO;
import nyamnyam.domain.StoreInfoDTO;

@Mapper
public interface StoreMapper {
	public void storeInsert(StoreDTO dto);
	public String selectStoreNum(String ornerNum);
	public List<StoreDTO> storeSelectAll();
	public StoreInfoDTO selectStoreInfoList(String storeNum);
	//public void changeStoreImage()
}
