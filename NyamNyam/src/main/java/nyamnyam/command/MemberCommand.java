package nyamnyam.command;

import java.util.Date;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberName;
	char memberGender; 
	Date memberBirthDate;
	Date memberRegistDate;
	String memberAddr;
	String memberAddrDetail;
	Integer memberPost;
}
