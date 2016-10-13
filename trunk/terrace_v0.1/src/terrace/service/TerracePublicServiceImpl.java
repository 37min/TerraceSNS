package terrace.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.TerracePublicDAO;
/**
 * 공개된 전체 테라스 관련 서비스
 */
@Service
public class TerracePublicServiceImpl implements TerracePublicService {
	//DAO Dependency Injection
	@Resource(name="terracePublicDAOImpl")
	private TerracePublicDAO terracePublicDAO;
}
