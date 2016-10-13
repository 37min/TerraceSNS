package terrace.service;

import java.util.List;

import terrace.vo.TerraceVO;

public interface TerraceService {
	/**
	 * method : getTerracePublicList
	 * comment : 공개된 전체 테라스 목록 반환
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규
	 * @date 2014-09-05
	 */
	public List getTerracePublicList();
	/**
	 * method : createTerrace
	 * comment : 테라스 생성 서비스 
	 * @param tvo
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	public void createTerrace(TerraceVO tvo);
	/**
	 * method : searchTerraceByCategory
	 * comment : 테라스 카테고리별 검색 서비스
	 * @param terCategory
	 * @param listName
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	public List searchTerraceByCategory(String terCategory, String listName);
	/**
	 * method : searchTerraceByTerName
	 * comment : 테라스 테라스명 검색 서비스
	 * @param terName
	 * @param listName
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	public List searchTerraceByTerName(String terName, String listName);

}
