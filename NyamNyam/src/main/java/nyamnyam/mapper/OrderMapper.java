package nyamnyam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nyamnyam.domain.CartDTO;
import nyamnyam.domain.CartListDTO;

@Mapper
public interface OrderMapper {
	public void cartInsert(CartDTO dto);
	public List<CartListDTO> cartSelectAll(String memberNum);
	public void cartDelete(@Param("menuNum") String menuNum, @Param("memberNum") String memberNum);
}
