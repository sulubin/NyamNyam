package nyamnyam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nyamnyam.domain.MemberDTO;
import nyamnyam.domain.ZzimDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
	public int checkZzim(@Param("storeNum") String storeNum, @Param("memberNum") String memberNum);
	public void zzimUpdate(ZzimDTO dto);
	public List<String> zzimSelectAll(String memberNum);
}
