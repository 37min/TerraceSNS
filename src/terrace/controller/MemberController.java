package terrace.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import terrace.service.MemberService;
import terrace.vo.MemberVO;

/**
 * 회원 관련 컨트롤러
 */
@Controller
public class MemberController {
	//이미지 저장하려는 디렉토리 경로
	private String path = "C:\\terrace\\terrace-workspace\\terrace_v0.1\\WebContent\\memImg\\";	
	
	// Service Dependency Injection
	@Resource(name = "memberServiceImpl")
	private MemberService memberService;

	/**
	 * method : loginView 
	 * comment : 로그인 화면으로 이동
	 * 
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	@RequestMapping("loginView.do")
	public String loginView() {
		return "member.login_view";
	}

	/**
	 * method : loginMember
	 * comment : 로그인 처리
	 * 
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	@RequestMapping(value = "loginMember.do", method = RequestMethod.POST)
	public ModelAndView loginMember(HttpServletResponse response, MemberVO mvo, HttpSession session, String autoLogin) {
		
		if(autoLogin.equals("on")){//자동로그인 상태이면,
			String memberInfo="";
			//회원아이디/암호화된 비밀번호 
			memberInfo=mvo.getMemId()+"/"+memberService.encryptStr(mvo.getMemPass());
			
			//쿠키에 회원정보 저장
			Cookie userCookie=new Cookie("terrace_autoLogin",memberInfo);
			userCookie.setMaxAge(3600);//하루 자동로그인 유지
			response.addCookie(userCookie);
		}
		String sleepCheck="default";
		MemberVO rvo = memberService.loginMember(mvo);
		//로그인 시 활성화 상태로 변경
		if(rvo.getMemSleep()==1){
			sleepCheck="wakeUp";
			memberService.sleepMember(rvo);
			rvo=memberService.findMemberById(mvo.getMemId());
		}
		
		// 로그인 정보에 해당하는 회원이 없을 경우 fail을 디폴트로 viewName 설정
		String viewName = "member.login_fail";
		if (rvo != null) {// 로그인 정보에 해당하는 회원 존재
			viewName = "member.login_ok";
			session.setAttribute("loginInfo", rvo);
		}
		return new ModelAndView(viewName,"sleepCheck",sleepCheck);
	}

	/**
	 * method : registerMemberView
	 * comment : 회원가입 뷰 이동
	 * 
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	@RequestMapping(value = "registerMemberView.do")
	public ModelAndView registerMemberView(String memId,String memUniv, HttpSession session) {
		session.removeAttribute("publishKey");//인증완료 후 세션 제거
		MemberVO mvo = new MemberVO();
		mvo.setMemId(memId);
		mvo.setMemUniv(memUniv);
		ModelAndView mv = new ModelAndView("member.register_view","mvo",mvo);
		return mv;
	}

	/**
	 * method : registerMember
	 * comment : 회원가입
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	@RequestMapping(value = "registerMember.do")
	public String registerMember(MemberVO mvo) {
		
		MultipartFile mFile = mvo.getUploadImg();//업로드한 실제 파일
		String orgImg = mFile.getOriginalFilename();//클라이언트가 업로드한 파일명
		
		if(mFile != null && !mFile.isEmpty()){//업로드한 파일이 존재하면,
			long now = System.currentTimeMillis();//단위 시간 측정
			String newImg = now+"_"+orgImg;//단위 시간_파일명 으로 유니크한 새파일명 생성
			mvo.setMemOrgImg(orgImg);//멤버객체에 실제 파일명 할당
			mvo.setMemNewImg(newImg);//멤버객체에 새파일명 할당
			File copyFile = new File(path+newImg);

			try {
				mFile.transferTo(copyFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		
		}else{//업로드한 파일이 존재하지 않으면,
			//default Img 첨부
			String defaultImg="memDefault.jpg";
			mvo.setMemOrgImg(defaultImg);
			mvo.setMemNewImg(defaultImg);
			File copyFile = new File(path+defaultImg);
			try {
				mFile.transferTo(copyFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		memberService.registerMember(mvo);
		return "redirect:loginView.do";
	}
	
	/***
	 * method : publishKeyView
	 * comment : 이메일 인증하기 화면 이동
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	@RequestMapping("publishKeyView.do")
	public String publishKeyView(HttpSession session){
		return "member.publishkey_view";
	}
	
	/**
	 * method : publishKey
	 * comment : 이메일 주소를 통해 인증번호 발급
	 * @param memId
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("publishKey.do")
	@ResponseBody
	public HashMap publishKey(String memId){
		HashMap map=memberService.publishKey(memId);
		return map;
	}
	/**
	 * method : getUnivListByLocation
	 * comment : 지역명을 통해 대학명 목록 반환 처리
	 * @param univLoc
	 * @return
	 * @throws Exception
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("univNameList.do")
	@ResponseBody
	public List getUnivListByUnivLoc(String univLoc){
		//지역정보에 따른 대학 목록 반환
		List univListByUnivLoc=memberService.getUnivListByUnivLoc(univLoc);
		return univListByUnivLoc;
	}
	
	/***
	 * method : getUnivEmailByUnivName
	 * comment : 대학명을 통해 대학 이메일 주소 반환 처리
	 * @param univName
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("univEmail.do")
	@ResponseBody
	public HashMap getUnivEmailByUnivName(String univName){
		HashMap map=new HashMap();
		String univEmailByUnivName=memberService.getUnivEmailByUnivName(univName);//문자열 반환 안됨
		map.put("univEmail", univEmailByUnivName);
		return map;
	}
	/***
	 * method : memNoCheck
	 * comment : 회원 학번의 중복여부 확인 처리
	 * @param memNo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("memNoCheck.do")
	@ResponseBody
	public HashMap memNoCheck(String memNo){
		HashMap map=new HashMap();
		//중복여부를 HashMap형태로 반환
		map.put("flag", memberService.memNoCheck(memNo));
		return map;
	}
	/**
	 * method : findIdOrPassView
	 * comment : 아이디 찾기/비밀번호 재발급 화면으로 이동
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("findIdOrPassView.do")
	public String findIdOrPassView() {
		return "member.findIdOrPass_view";
	}
	/**
	 * method : findmemId
	 * comment : 회원 아이디 찾기 처리
	 * @param findMemName, findMemNo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping(value="findMemId.do", method = RequestMethod.POST)
	public ModelAndView findMemId(String findMemName, String findMemNo){
		MemberVO mvo=new MemberVO();
		mvo.setMemName(findMemName);
		mvo.setMemNo(findMemNo);
		String result= memberService.findMemIdByNameAndMemNo(mvo);
		return new ModelAndView("member.findMemId_result","findMemId",result);
	}
	
	/**
	 * method : 
	 * comment : 회원정보 수정 뷰페이지 이동
	 * @param session
	 * @return	 
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_modifyMemberView.do")
	public String modifyMemberView(HttpSession session){		
		return "member.modifyMember_view";
	}
	/**
	 * method : logoutMember
	 * comment : 세션을 종료시킴으로써 로그아웃 수행
	 * @param request
	 * @param session
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_logoutMember.do")
	public String logoutMember(HttpServletRequest request,HttpSession session){
		session=request.getSession(false);//세션이 존재하지 않을 경우 null 반환
		if(session!= null){//회원이 로그인한 상태
			session.invalidate();//세션을 종료시킨다
		}
		return "home";
	}
	/**
	 * method : modifyMember
	 * comment : 회원정보 수정 처리 및 수정된 정보를 세션에 세팅
	 * @param session
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_modifyMember.do")
	public String modifyMember(HttpSession session, MemberVO mvo){
		MemberVO rvo= null;
		//이미지 수정 포함한 회원정보 수정
		if(mvo.getUploadImg()!=null){
			//mvo.setMemImg("noImg");
			MultipartFile mFile = mvo.getUploadImg();//업로드한 실제 파일
			String orgImg = mFile.getOriginalFilename();//클라이언트가 업로드한 파일명
			long now = System.currentTimeMillis();//단위 시간 측정
			String newImg = now+"_"+orgImg;//단위 시간_파일명 으로 유니크한 새파일명 생성
			mvo.setMemOrgImg(orgImg);//멤버객체에 실제 파일명 할당
			mvo.setMemNewImg(newImg);//멤버객체에 새파일명 할당
			File copyFile = new File(path+newImg);
			rvo=memberService.modifyMemberAndImg(mvo);
			try {
				mFile.transferTo(copyFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{//이미지 수정 포함하지 않는 회원정보 수정			
			rvo=memberService.modifyMember(mvo);
		}
		session.setAttribute("loginInfo", rvo);//업데이트 된 Member 정보로 Session 셋팅
		return "redirect:auth_modifyMemberView.do";
	}
	/**
	 * method : modifyPass
	 * comment : 비밀번호 수정 후 세션 세팅
	 * @param session
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_modifyPass.do")
	public String modifyPass(HttpSession session, MemberVO mvo){
		//비밀번호 수정
		MemberVO rvo=memberService.modifyPass(mvo);
		session.setAttribute("loginInfo", rvo);//Session 셋팅
		return "redirect:auth_modifyMemberView.do";
	}
	/**
	 * method : modifyPassView
	 * comment : 비밀번호 수정 페이지로 이동
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_modifyPassView.do")
	public String modifyPassView(){
		return "member.modifyPass_view";
	}
	/**
	 * method : sleepMemberView
	 * comment : 계정 비활성화 화면으로 이동
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_sleepMemberView.do")
	public String sleepMemberView(){
		return "member.sleepMember_View";
	}
	/**
	 * method : memPassCheck
	 * comment : 비밀번호 체크 - 재로그인 형태
	 * @param session
	 * @param memPass
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_memPassCheck.do")
	@ResponseBody
	public HashMap memPassCheck(HttpSession session, String memPass){
		HashMap map=new HashMap();
		MemberVO mvo=(MemberVO) session.getAttribute("loginInfo");
		mvo.setMemPass(memberService.encryptStr(memPass));
		if(memberService.loginMember(mvo)!=null){//비밀번호가 
			map.put("flag", "true");
		}else{
			map.put("flag", "false");
		}
		return map;
	}
	/**
	 * method : sleepMember
	 * comment : 활성화 유무 계정 업데이트
	 * @param session
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	@RequestMapping("auth_sleepMember.do")
	public String sleepMember(HttpSession session){
		MemberVO mvo=(MemberVO) session.getAttribute("loginInfo");
		memberService.sleepMember(mvo);
		return "member.sleepMember_ok";
	}
}


