package nyamnyam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import nyamnyam.domain.LoginDTO;
import nyamnyam.mapper.MainMapper;

@Service
public class UserNumService {
	@Autowired
	MainMapper mainMapper;
	public String execute(HttpSession session) {
		LoginDTO auth = (LoginDTO)session.getAttribute("auth");
		String userNum = auth.getUserNum();
		return userNum;
	}
}
