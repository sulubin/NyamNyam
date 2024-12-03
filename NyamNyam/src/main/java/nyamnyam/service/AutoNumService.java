package nyamnyam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import nyamnyam.mapper.MainMapper;

@Service
public class AutoNumService {
	@Autowired
	MainMapper mainMapper;
	
	public String execute(String tableName, String columnName, String sep, Model model) {
		String autoNum = mainMapper.selectAutoNum(tableName, columnName, sep);
		model.addAttribute("autoNum", autoNum);
		return autoNum;
	}
}
