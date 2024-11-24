package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	public void menuInsert(MenuDTO dto);
}
