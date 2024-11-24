package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nyamnyam.command.DeliverymanCommand;
import nyamnyam.command.OrnerCommand;
import nyamnyam.service.AutoNumService;
import nyamnyam.service.deliveryman.DeliverymanRegistService;
import nyamnyam.service.orner.OrnerRegistService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	OrnerRegistService ornerRegistService;
	@Autowired
	DeliverymanRegistService deliverymanRegistService;
	
	@RequestMapping("employeeMain")
	public String employeeMain() {
		return "thymeleaf/employeeView/employeeMainPage";
	}
	@GetMapping("ornerRegist")
	public String ornerRegist(Model model) {
		String tableName = "orners";
		String columnName = "orner_num";
		String sep = "orner_"; 
		autoNumService.execute(tableName, columnName, sep, model);
		return "thymeleaf/employeeView/ornerRegistForm";
	}
	@PostMapping("ornerRegist")
	public String ornerRegist(OrnerCommand ornerCommand) {
		ornerRegistService.execute(ornerCommand);
		return "redirect:/employee/employeeMain";
	}
	@GetMapping("deliverymanRegist")
	public String deliverymanRegist(Model model) {
		autoNumService.execute("deliverymans", "deliveryman_num", "deliveryman_", model);
		return "thymeleaf/employeeView/deliverymanRegistForm";
	}
	@PostMapping("deliverymanRegist")
	public String deliverymanRegist(DeliverymanCommand deliverymanCommand) {
		deliverymanRegistService.execute(deliverymanCommand);
		return "redirect:/employee/employeeMain";
	}
}
