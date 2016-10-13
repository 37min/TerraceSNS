package terrace.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
/**
 * 마이 테라스 관련 데이터베이스 접근 객체
 */
@Repository
public class TerraceMyDAOImpl implements TerraceMyDAO{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
}
