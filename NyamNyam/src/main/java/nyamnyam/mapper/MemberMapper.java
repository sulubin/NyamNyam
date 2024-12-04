package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nyamnyam.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
	public Integer checkZzim(@Param("storeNum") String storeNum, @Param("memberNum") String memberNum);
}
