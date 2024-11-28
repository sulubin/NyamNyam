package nyamnyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nyamnyam.command.DeliverymanCommand;
import nyamnyam.command.OrnerCommand;
import nyamnyam.command.StoreCommand;
import nyamnyam.service.AutoNumService;
import nyamnyam.service.deliveryman.DeliverymanRegistService;
import nyamnyam.service.orner.OrnerRegistService;
import nyamnyam.service.store.StoreRegistService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	AutoNumService autoNumService;
	@Autowired
	DeliverymanRegistService deliverymanRegistService;
	
	// 직원 메인 페이지
	@RequestMapping("employeeMain")
	public String employeeMain() {
		return "thymeleaf/employeeView/employeeMainPage";
	}
	// 사장 등록 페이지
	@GetMapping("ornerRegist")
	public String ornerRegist(Model model) {
		String tableName = "orner";
		String columnName = "orner_num";
		String sep = "orner_"; 
		autoNumService.execute(tableName, columnName, sep, model);
		return "thymeleaf/employeeView/ornerRegistForm";
	}
	// 사장 및 가게 등록 
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
