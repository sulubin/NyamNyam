package nyamnyam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@RequestMapping("employeeMain")
	public String employeeMain() {
		return "thymeleaf/employeeView/employeeMainPage";
	}
}
