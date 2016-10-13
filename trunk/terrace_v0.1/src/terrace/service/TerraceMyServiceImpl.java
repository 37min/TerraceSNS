package terrace.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.TerraceMyDAO;
/**
 * 마이 테라스 관련 서비스
 */
@Service
public class TerraceMyServiceImpl implements TerraceMyService{
	//DAO Dependency Injection
	@Resource(name="terraceMyDAOImpl")
	private TerraceMyDAO terraceMyDAO;
}
