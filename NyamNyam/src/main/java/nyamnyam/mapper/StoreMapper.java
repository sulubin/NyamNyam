package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.StoreDTO;
import nyamnyam.domain.StoreInfoDTO;

@Mapper
public interface StoreMapper {
	public void storeInsert(StoreDTO dto);
	public String selectStoreNum(String ornerNum);
	public StoreInfoDTO selectStoreInfoList(String storeNum);
}
