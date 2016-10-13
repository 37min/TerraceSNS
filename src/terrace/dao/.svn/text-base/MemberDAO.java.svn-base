package terrace.dao;

import java.util.List;

import terrace.vo.MemberVO;

public interface MemberDAO {
	/**
	 * method : loginMember
	 * comment : 로그인 정보를 통한 회원정보 조회 처리
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-03
	 */
	public MemberVO loginMember(MemberVO mvo);
	/**
	 * method : findMemberById
	 * comment : 회원 아이디를 통한 회원정보 조회 처리
	 * @param memId
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public MemberVO findMemberById(String memId);
	/**
	 * method : getUnivListByLocation
	 * comment : 지역명을 통한 대학명 목록 조회 처리
	 * @param univLoc
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public List getUnivListByUnivLoc(String univLoc);
	/**
	 * method : getUnivEmailByUnivName
	 * comment : 대학명을 통한 대학 이메일 주소 조회 처리
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
	 * comment : 회원 학번 중복여부를 체크하기 위해 DB에 해당하는 학번을 가진 회원수 조회
	 * @param memNo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public int memNoCheck(String memNo);
	/**
	 * method : findMemIdByNameAndMemNo
	 * comment : 아이디 찾기 수행. 회원 이름과 학번으로 DB에서 조회
	 * @param mvo
	 * @return
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public MemberVO findMemIdByNameAndMemNo(MemberVO mvo);
	/**
	 * method : modifyMember
	 * comment : 수정될 정보를 DB에 전달하여 업데이트 수행
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public void modifyMember(MemberVO mvo);
	/**
	 * method : modifyPass
	 * comment : 비밀번호 수정
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public void modifyPass(MemberVO mvo);
	/**
	 * method : sleepMember
	 * comment : 계정 비활성화를 위해 DB에서 활성화 여부 업데이트
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-04
	 */
	public void sleepMember(MemberVO mvo);
	/**
	 * method : modifyMemberAndImg
	 * comment : 프로필이미지 수정포함 회원정보 수정
	 * @param mvo
	 * 
	 * @author 김병각, 김철준, 최성환
	 * @date 2014-09-07
	 */
	public void modifyMemberAndImg(MemberVO mvo);
}
