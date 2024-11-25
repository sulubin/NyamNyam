package nyamnyam.command;

import lombok.Data;

@Data
public class LoginCommand {
	String userNum;
	String userId;
	String userPw;
	String grade;
}
