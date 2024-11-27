package nyamnyam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.MenuDTO;

@Mapper
public interface MenuMapper {
	public void menuInsert(MenuDTO dto);
	public List<MenuDTO> selectMenuList(String storeNum);
	public void menuDelete(String menuNum);
}
