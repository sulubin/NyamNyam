package nyamnyam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.domain.ZzimDTO;
import nyamnyam.mapper.MemberMapper;

@Service
public class ZzimUpdateService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memberNum, String storeNum) {
		ZzimDTO dto = new ZzimDTO();
		dto.setMemberNum(memberNum);
		dto.setStoreNum(storeNum);
		memberMapper.zzimUpdate(dto);
	}
}
