package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("zzim")
public class ZzimDTO {
	String memberNum;
	String storeNum;
}
