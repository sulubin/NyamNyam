package nyamnyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.MemberCommand;
import nyamnyam.mapper.MemberMapper;
import nyamnyam.mapper.StoreMapper;
import nyamnyam.service.UserNumService;
import nyamnyam.service.member.MemberJoinService;
import nyamnyam.service.member.ZzimUpdateService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	UserNumService userNumService;
	@Autowired
	ZzimUpdateService zzimUpdateService;
	
	@Autowired
	StoreMapper storeMapper;
	@Autowired
	MemberMapper memberMapper;
	
	// 회원가입 페이지
	@GetMapping("memberJoin")
	public String memberJoin() {
		return "thymeleaf/member/memberJoinPage";
	}
	// 약관 동의 페이지
	@PostMapping("memberTermCheck")
	public String memberTermCheck() {
		return "thymeleaf/member/memberTermCheckPage";
	}
	// 회원가입 폼 페이지
	@PostMapping("memberJoinForm")
	public String memberJoinForm() {
		return "thymeleaf/member/memberJoinForm";
	}
	// 회원가입 서비스
	@PostMapping("memberJoin")
	public String memberJoin(MemberCommand memberCommand) {
		memberJoinService.execute(memberCommand);
		return "redirect:/";
	}
	
	@PostMapping("zzimCheck")
	public void zzimCheck(HttpSession session, @RequestParam("storeNum") String storeNum) {
		String memberNum = userNumService.execute(session);
		zzimUpdateService.execute(memberNum, storeNum);
	}
	
	@GetMapping("zzimList")
	public String zzimList(HttpSession session, Model model) {
		String memberNum = userNumService.execute(session);
		List<String> zzimList = memberMapper.zzimSelectAll(memberNum);
		model.addAttribute("zzimList", zzimList);
		return "thymeleaf/memberView/zzimListPage";
	}
}
