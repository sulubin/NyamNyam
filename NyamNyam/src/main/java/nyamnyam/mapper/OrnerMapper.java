package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.OrnerDTO;

@Mapper
public interface OrnerMapper {
	public void ornerInsert(OrnerDTO dto);
}
