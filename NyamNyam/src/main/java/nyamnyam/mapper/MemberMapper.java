package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;

import nyamnyam.domain.MemberDTO;

@Mapper
public interface MemberMapper {
	public void memberInsert(MemberDTO dto);
}
