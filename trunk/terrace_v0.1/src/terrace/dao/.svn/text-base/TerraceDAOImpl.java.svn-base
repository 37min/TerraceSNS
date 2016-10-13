package terrace.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import terrace.vo.TerraceVO;

/**
 * 테라스 데이터베이스 
 */
@Repository
public class TerraceDAOImpl implements TerraceDAO{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List getTerracePublicList() {
		return sqlSessionTemplate.selectList("ter.getTerracePublicList");
	}

	@Override
	public void createTerrace(TerraceVO tvo) {
		sqlSessionTemplate.insert("ter.createTerrace", tvo);
	}

	@Override
	public List searchTerraceByCategory(String terCategory, String listName) {
		List list;
		if(terCategory.equals("전체")){
			return getTerracePublicList();
		}else{
			if(listName.equals("all")){
				list=sqlSessionTemplate.selectList("ter.searchCatAll", terCategory);
			}else if(listName.equals("my")){
				list=sqlSessionTemplate.selectList("ter.searchCatMy", terCategory);
			}else if(listName.equals("registerable")){
				list=sqlSessionTemplate.selectList("ter.searchCatRegisterable", terCategory);
			}else{
				list=null;
			}
		}
		return list;
	}

	@Override
	public List searchTerraceByTerName(String terName, String listName) {
		List list;
		if(listName.equals("all")){
			list=sqlSessionTemplate.selectList("ter.searchNameAll", terName);
		}else if(listName.equals("my")){
			list=sqlSessionTemplate.selectList("ter.searchNameMy", terName);
		}else if(listName.equals("registerable")){
			list=sqlSessionTemplate.selectList("ter.searchNameRegisterable", terName);
		}else{
			list=null;
		}
		return list;
	}

}


