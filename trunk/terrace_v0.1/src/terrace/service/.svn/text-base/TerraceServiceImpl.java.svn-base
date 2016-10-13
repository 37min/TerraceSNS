package terrace.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.TerraceDAO;
import terrace.vo.TerraceVO;
/**
 * 테라스 전체 관련 서비스
 */
@Service
public class TerraceServiceImpl implements TerraceService {
	//DAO Dependency Injection
	@Resource(name="terraceDAOImpl")
	private TerraceDAO terraceDAO;

	@Override
	public List getTerracePublicList() {
		List tpList=terraceDAO.getTerracePublicList();
		return tpList;
	}

	@Override
	public void createTerrace(TerraceVO tvo) {
		terraceDAO.createTerrace(tvo);
	}

	@Override
	public List searchTerraceByCategory(String terCategory, String listName) {
		return terraceDAO.searchTerraceByCategory(terCategory,listName);
	}

	@Override
	public List searchTerraceByTerName(String terName, String listName) {
		return terraceDAO.searchTerraceByTerName(terName, listName);
	}
}
