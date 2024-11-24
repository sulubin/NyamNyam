package nyamnyam.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class MemberDTO {
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
