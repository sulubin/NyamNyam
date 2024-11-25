package nyamnyam.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import nyamnyam.command.LoginCommand;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.MainMapper;

@Service
public class LoginService {
	@Autowired
	MainMapper mainMapper;
	public void execute(LoginCommand loginCommand, HttpSession session) {
		LoginDTO auth = mainMapper.selectUserInfo(loginCommand.getUserId());
		session.setAttribute("auth", auth);
	}
}
