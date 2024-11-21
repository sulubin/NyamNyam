package nyamnyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class NyamNyamApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyamNyamApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "thymeleaf/index";
	}
}
