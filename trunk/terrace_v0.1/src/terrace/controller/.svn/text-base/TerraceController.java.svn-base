package terrace.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import terrace.service.TerraceService;
import terrace.vo.MemberVO;
import terrace.vo.TerraceVO;
/**
 * 전체 테라스 공통 관련 컨트롤러
 */
@Controller
public class TerraceController {
	//아이콘 이미지 저장 디렉토리
	private String iconPath = "D:\\terrace\\terrace-workspace\\terrace_v0.1\\WebContent\\terIconImg\\";	
	//커버 이미지 저장 디렉토리
	private String coverPath = "D:\\terrace\\terrace-workspace\\terrace_v0.1\\WebContent\\terCoverImg\\";	

	
	// Service Dependency Injection
	@Resource(name="terraceServiceImpl")
	private TerraceService terraceService;
	/**
	 * method : intro
	 * comment : 테라스 서비스 인트로 화면
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규
	 * @date 2014-09-05
	 */
	@RequestMapping("intro.do")
	public String intro(){
		return "home";
	}
	
	/**
	 * method : terraceView
	 * comment : 테라스 목록 화면으로 이동
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	@RequestMapping("terraceView.do")
	public ModelAndView terraceView(){
		ModelAndView mv=new ModelAndView();
		//테라스 목록 반환
		List tpList=terraceService.getTerracePublicList();
		int tpListSize=countTerraceList(tpList);
		
		mv.setViewName("terrace.terrace_view");
		mv.addObject("tpList", tpList);
		mv.addObject("tpListSize", tpListSize);
		return mv;
	}
	/**
	 * method : createTerraceView
	 * comment : 테라스 만들기 화면으로 이동
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	@RequestMapping("auth_createTerraceView.do")
	public String createTerraceView(){
		return "terrace.create_view";
	}
	
	/**
	 * method : createTerrace
	 * comment : 테라스 생성후 해당 테라스 번호 반환
	 * @param tvo
	 * @param session
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	@RequestMapping("createTerrace.do")
	public ModelAndView createTerrace(TerraceVO tvo, HttpSession session){
		//아이콘 이미지 파일 업로드 처리
		MultipartFile mIconFile=tvo.getUploadIconImg();
		String orgIconImg=mIconFile.getOriginalFilename();
		long now=System.currentTimeMillis();
		
		if(mIconFile!=null && !mIconFile.isEmpty()){
			String newIconImg=now+"_"+orgIconImg;//20140905141107_a.jpg
			tvo.setTerIconOrgImg(orgIconImg);//a.jpg
			tvo.setTerIconNewImg(newIconImg);//20140905141107_a.jpg
			
			File copyIconFile=new File(iconPath+newIconImg);
			
			try {
				mIconFile.transferTo(copyIconFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}else{//파일이 없다면 디폴트 이미지로 처리
			String defaultIconImg="terIconDefault.jpg";
			String nowDefaultIconImg=now+"_"+defaultIconImg;
			tvo.setTerIconOrgImg(defaultIconImg);
			tvo.setTerIconNewImg(nowDefaultIconImg);
			File copyIconFile=new File(iconPath+nowDefaultIconImg);
			
			try {
				mIconFile.transferTo(copyIconFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//커버 이미지 파일 업로드 처리
		MultipartFile mCoverFile=tvo.getUploadCoverImg();
		String orgCoverImg=mCoverFile.getOriginalFilename();
		
		if(mCoverFile != null && !mCoverFile.isEmpty() )
		{
			String newCoverImg=now+"_"+orgCoverImg;//20140905141107_a.jpg
			tvo.setTerCoverOrgImg(orgCoverImg);//a.jpg
			tvo.setTerCoverNewImg(newCoverImg);//20140905141107_a.jpg

			File copyCoverFile  = new File(coverPath+newCoverImg);
			
			
			try {
				mCoverFile.transferTo(copyCoverFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}else{
			String defaultCoverImg="terCoverDefault.jpg";
			String nowDefaultCoverImg=now+"_"+defaultCoverImg;
			tvo.setTerCoverOrgImg(defaultCoverImg);
			tvo.setTerCoverNewImg(nowDefaultCoverImg);
			File copyCoverFile=new File(coverPath+nowDefaultCoverImg);
			
			try {
				mCoverFile.transferTo(copyCoverFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		//테라스 관리자 아이디 셋팅
		MemberVO mvo = (MemberVO) session.getAttribute("loginInfo");
		tvo.setTerAdmin(mvo.getMemId());
		
		//조인리스트 셋팅
		tvo.setTerJoinList("/");
		
		terraceService.createTerrace(tvo);
		return new ModelAndView("terrace.board_list","terNo",tvo.getTerNo());
	}
	
	/**
	 * method : countTerraceList
	 * comment : 테라스 목록의 크기 반환
	 * @param list
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	public int countTerraceList(List list){
		int cnt=list.size();
		return cnt;
	}
	/**
	 * method : searchTerraceByCategory
	 * comment : 카테고리에 따른 검색 결과 반환
	 * @param terCategory,listName
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	@RequestMapping("searchTerraceByCategory.do")
	@ResponseBody
	public HashMap searchTerraceByCategory(String terCategory,String listName){
		HashMap map=new HashMap();
		List tcList=terraceService.searchTerraceByCategory(terCategory,listName);
		int tcListSize=countTerraceList(tcList);
		map.put("tcList", tcList);
		map.put("tcListSize", tcListSize);
		return map;
	}
	/**
	 * method : searchTerraceByTerName
	 * comment : 테라스명에 따른 검색 결과 반환
	 * @param terName, listName
	 * @return
	 * 
	 * @author 김병각, 이형철, 제형규, 민준홍
	 * @date 2014-09-05
	 */
	@RequestMapping("searchTerraceByTerName.do")
	@ResponseBody
	public HashMap searchTerraceByTerName(String terName,String listName){
		HashMap map=new HashMap();
		List tnList=terraceService.searchTerraceByTerName(terName,listName);
		int tnListSize=countTerraceList(tnList);
		
		map.put("tnList", tnList);
		map.put("tnListSize", tnListSize);
		return map;
	}
	
}
