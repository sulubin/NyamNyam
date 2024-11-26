package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nyamnyam.command.MemberCommand;
import nyamnyam.service.member.MemberJoinService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
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
		System.out.println("커맨드 전달 성공");
		memberJoinService.execute(memberCommand);
		return "redirect:/";
	}
}
