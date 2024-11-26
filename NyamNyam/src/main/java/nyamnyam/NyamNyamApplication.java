package nyamnyam;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import nyamnyam.domain.StoreDTO;
import nyamnyam.mapper.StoreMapper;

@Controller
@SpringBootApplication //(exclude = {MybatisAutoConfiguration.class})
@MapperScan
public class NyamNyamApplication {
	@Autowired
	StoreMapper storeMapper;
	public static void main(String[] args) {
		SpringApplication.run(NyamNyamApplication.class, args);
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<StoreDTO> list = storeMapper.storeSelectAll();
		model.addAttribute("list", list);
		return "thymeleaf/index";
	}
	@PostMapping("/")
	public ModelAndView storeList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		return mav;
	}
}
