package nyamnyam.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import nyamnyam.mapper.MemberMapper;

@Service
public class ZzimCheckService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String storeNum, String memberNum, Model model) {
		System.out.println("zzim서비스 옴");
		Integer checkZzim = memberMapper.checkZzim(storeNum, memberNum);
		System.out.println("찜일까" + checkZzim);
		if(checkZzim == 1) model.addAttribute("checkZzim", checkZzim);
		else model.addAttribute("checkZzim", checkZzim);
		
	}
}
