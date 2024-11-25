package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("login")
public class LoginDTO {
	String userNum;
	String userId;
	String userPw;
	String grade;
}
