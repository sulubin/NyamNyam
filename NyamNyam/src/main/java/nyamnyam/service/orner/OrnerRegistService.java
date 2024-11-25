package nyamnyam.service.orner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nyamnyam.command.OrnerCommand;
import nyamnyam.domain.OrnerDTO;
import nyamnyam.mapper.OrnerMapper;

@Service
public class OrnerRegistService {
	@Autowired
	OrnerMapper ornerMapper;
	public void execute(OrnerCommand ornerCommand) {
		OrnerDTO dto = new OrnerDTO();
		dto.setOrnerNum(ornerCommand.getOrnerNum());
		dto.setOrnerId(ornerCommand.getOrnerId());
		dto.setOrnerPw(ornerCommand.getOrnerPw());
		dto.setOrnerName(ornerCommand.getOrnerName());
		dto.setOrnerPhone(ornerCommand.getOrnerPhone());
		dto.setOrnerEmail(ornerCommand.getOrnerEmail());
		ornerMapper.ornerInsert(dto);
	}
}
