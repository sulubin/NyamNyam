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
		int checkZzim = memberMapper.checkZzim(storeNum, memberNum);
		if(checkZzim == 1) model.addAttribute("checkZzim", checkZzim);
		else if(checkZzim == 0) model.addAttribute("checkZzim", checkZzim);
		
	}
}
