package terrace.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import terrace.vo.MemberVO;

public interface MemberService {
	/***
	 * method : loginMember
	 * comment : 회원 로그인 처리
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	public MemberVO loginMember(MemberVO mvo);
	/**
	 * method : publishKey
	 * comment : 이메일 인증키 발급 처리
	 * @param memId
	 * @param session
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public HashMap publishKey(String memId);
	/**
	 * method : findMemberById
	 * comment : 회원 아이디를 통한 회원정보 검색 처리
	 * @param memId
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public MemberVO findMemberById(String memId);
	/**
	 * method : getUnivListByLocation
	 * comment : 지역에 따른 대학명 목록 반환 처리
	 * @param univLoc
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public List getUnivListByUnivLoc(String univLoc);
	/**
	 * method : getUnivEmailByUnivName
	 * comment : 대학명에 따른 대학교 이메일 주소 반환 처리
	 * @param univName
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public String getUnivEmailByUnivName(String univName);
	/**
	 * method : registerMember
	 * comment : 회원가입 처리
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public void registerMember(MemberVO mvo);
	/**
	 * method : memNoCheck
	 * comment : 회원 학번 중복 여부 체크
	 * @param memNo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public boolean memNoCheck(String memNo);
	/**
	 * method : findMemIdByNameAndMemNo
	 * comment : 아이디 찾기 수행(회원이름과 학번)
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public String findMemIdByNameAndMemNo(MemberVO mvo);
	/**
	 * method : modifyMember
	 * comment : 회원정보 수정 처리
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public MemberVO modifyMember(MemberVO mvo);
	/**
	 * method : encryptStr
	 * comment : 문자열 해싱 변환
	 * @param str
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public String encryptStr(String str);
	/**
	 * method : modifyPass
	 * comment : 비밀번호 수정
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public MemberVO modifyPass(MemberVO mvo);
	/**
	 * method : sleepMember
	 * comment : 계정 비활성화 처리
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public void sleepMember(MemberVO mvo);
	/**
	 * method : modifyMemberAndImg
	 * comment : 이미지 수정을 포함한 회원정보 수정
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-07
	 */
	public MemberVO modifyMemberAndImg(MemberVO mvo);
}
