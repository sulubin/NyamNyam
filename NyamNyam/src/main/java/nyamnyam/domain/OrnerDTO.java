package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("orner")
public class OrnerDTO {
	String ornerNum;
	String ornerId;
	String ornerPw;
	String ornerName;
	String ornerPhone;
	String ornerEmail;
}
