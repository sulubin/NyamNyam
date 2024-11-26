package nyamnyam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.MemberCommand;
import nyamnyam.domain.MemberDTO;
import nyamnyam.mapper.MainMapper;
import nyamnyam.mapper.MemberMapper;

@Service
public class MemberJoinService {
	@Autowired
	MainMapper mainMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		String autoNum = mainMapper.selectAutoNum("members", "member_num", "mem_");
		dto.setMemberNum(autoNum);
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberPw(memberCommand.getMemberPw());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberGender(memberCommand.getMemberGender());
		dto.setMemberBirthDate(memberCommand.getMemberBirthDate());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddrDetail());
		dto.setMemberPost(memberCommand.getMemberPost());
		System.out.println("mapper로 전달 성공");
		memberMapper.memberInsert(dto);
	}
}
