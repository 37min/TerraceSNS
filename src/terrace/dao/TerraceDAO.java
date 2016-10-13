package terrace.dao;

import java.util.List;

import terrace.vo.TerraceVO;

public interface TerraceDAO {
	/***
	 * method : getTerracePublicList
	 * comment : DB에서 공개처리된 전체 테라스 목록을 조회
	 * @return
	 * 
	 * @author 김병각, 제형규, 이형철
	 * @date 2014-09-05
	 */
	public List getTerracePublicList();
	/**
	 * method : createTerrace
	 * comment : DB에서 테라스 생성 후, 테라스 번호 조회
	 * @param tvo
	 * 
	 * @author 김병각, 제형규, 이형철, 민준홍
	 * @date 2014-09-05
	 */
	public void createTerrace(TerraceVO tvo);
	/**
	 * method : searchTerraceByCategory
	 * comment : DB에서 카테고리에 따라 테라스 목록 조회
	 * @param terCategory
	 * @param listName
	 * @return
	 * 
	 * @author 김병각, 제형규, 이형철, 민준홍
	 * @date 2014-09-05
	 */
	public List searchTerraceByCategory(String terCategory, String listName);
	/**
	 * method : searchTerraceByTerName
	 * comment : DB에서 테라스명에 따라 테라스 목록 조회
	 * @param terName
	 * @param listName
	 * @return
	 * 
	 * @author 김병각, 제형규, 이형철, 민준홍
	 * @date 2014-09-05
	 */
	public List searchTerraceByTerName(String terName, String listName);

}
