package nyamnyam.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import nyamnyam.domain.LoginDTO;

@Mapper
public interface MainMapper {
	public String selectAutoNum(@Param("tableName") String tableName, @Param("columnName") String columnName,
			 					@Param("sep") String sep);
	public LoginDTO selectUserInfo(String userId); 
}
