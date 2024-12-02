package nyamnyam.service;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class ClosePopupService {
	public String execute(HttpServletResponse response, boolean correct, HttpSession session) {
		if(correct) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				String str = "<script>";
					  str += "	window.self.close();";
					  str += "  window.opener.parent.location.reload();";
					  str += "</script>";
				out.print(str);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}
		else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				String str = "<script>";
					  str += "	alert('접근 권한이 없습니다.');";
					  str += "	window.self.close();";
					  str += "  window.opener.parent.location.reload();";
					  str += "	window.opener.location.href='/'";
					  str += "</script>";
				out.print(str);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			session.invalidate();
			return "redirect:/login/logout";
		}
	}
}
