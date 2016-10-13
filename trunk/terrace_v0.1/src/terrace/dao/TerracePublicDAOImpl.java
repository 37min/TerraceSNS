package terrace.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
/**
 * 공개된 전체 테라스 관련 데이터베이스 접근객체
 */
@Repository
public class TerracePublicDAOImpl implements TerracePublicDAO{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
}
