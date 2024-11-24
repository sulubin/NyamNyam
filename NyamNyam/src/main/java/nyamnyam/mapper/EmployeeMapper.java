package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.OrnerDTO;

@Mapper
public interface EmployeeMapper {
	public void insertOrner(OrnerDTO dto);
}
