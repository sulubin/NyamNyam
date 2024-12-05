package nyamnyam.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("rowspan")
public class RowspanDTO {
	Integer rowspan;
}
