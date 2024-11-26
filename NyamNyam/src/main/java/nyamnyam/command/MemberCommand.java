package nyamnyam.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	char memberGender; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirthDate;
	Date memberRegistDate;
	String memberAddr;
	String memberAddrDetail;
	Integer memberPost;
}
