package terrace.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
/**
 * 메시지관련 데이터베이스  임플먼트
 */
@Repository
public class MessageDAOImpl implements MessageDAO{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
}
