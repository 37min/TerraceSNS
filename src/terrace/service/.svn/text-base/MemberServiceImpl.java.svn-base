package terrace.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.MemberDAO;
import terrace.email.MemberSendEmail;
import terrace.vo.MemberVO;
/**
 * 회원 관련 서비스
 */
@Service
public class MemberServiceImpl implements MemberService{
	//DAO Dependency Injection
	@Resource(name="memberDAOImpl")
	private MemberDAO memberDAO;

	@Override
	public MemberVO loginMember(MemberVO mvo) {
		//비밀번호 암호화 작업
		String memPass=mvo.getMemPass();
		mvo.setMemPass(encryptStr(memPass));
		MemberVO rvo = memberDAO.loginMember(mvo);
		return rvo;
	}
	
	@Override
	public HashMap publishKey(String memId) {
		HashMap map=new HashMap();
		String publishKey="";//리턴할 암호
		
		MemberVO mvo=findMemberById(memId);
		
		if(mvo==null){//아이디가 중복이 아닌 경우
			//이메일을 통한 암호화 작업
			publishKey=encryptStr(memId);
		}else{//아이디가 중복될 경우
			publishKey="";
		}
		map.put("publishKey", publishKey);//중복여부를 HashMap형태로 반환
		//email처리
		MemberSendEmail email = new MemberSendEmail();
		email.sendEmail(memId, "[테라스 서비스] 요청하신 인증번호입니다.", "요청하신 인증번호는 "+publishKey +" 입니다.");
		return map;
	}

	@Override
	public MemberVO findMemberById(String memId) {
		return memberDAO.findMemberById(memId);
	}

	@Override
	public List getUnivListByUnivLoc(String univLoc) {
		return memberDAO.getUnivListByUnivLoc(univLoc);
	}

	@Override
	public String getUnivEmailByUnivName(String univName) {
		return memberDAO.getUnivEmailByUnivName(univName);
	}

	@Override
	public void registerMember(MemberVO mvo) {
		//비밀번호 암호화 작업
		String memPass=mvo.getMemPass();
		mvo.setMemPass(encryptStr(memPass));
		memberDAO.registerMember(mvo);		
	}

	@Override
	public boolean memNoCheck(String memNo) {
		int cnt=memberDAO.memNoCheck(memNo);
		if(cnt==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public String findMemIdByNameAndMemNo(MemberVO mvo) {
		String result="";
		MemberVO rvo=memberDAO.findMemIdByNameAndMemNo(mvo);
		
		if(rvo==null){
			return "noData";
		}else{
			String memId=rvo.getMemId();
			//bagette112@ajou.ac.kr일 경우, bage******@ajou.ac.kr
			int tokenIndex=memId.indexOf('@');
			String univId=memId.substring(0, tokenIndex-1);//학교 아이디
			String univEmail=memId.substring(tokenIndex);//학교 이메일 주소
			int univIdLength=univId.length();//학교 아이디 길이
			
			for(int i=0;i<=univIdLength;i++){
				if(i<4){
					result=result+univId.charAt(i);
				}else{
					result=result+"*";
				}
			}
			result=result+univEmail;
			return result;
		}
	}

	@Override
	public MemberVO modifyMember(MemberVO mvo) {
		memberDAO.modifyMember(mvo);
		MemberVO rvo=memberDAO.findMemberById(mvo.getMemId());
		return rvo;
	}
	

	@Override
	public MemberVO modifyMemberAndImg(MemberVO mvo) {
		memberDAO.modifyMemberAndImg(mvo);
		MemberVO rvo=memberDAO.findMemberById(mvo.getMemId());
		return rvo;
	}
	
	@Override
	public String encryptStr(String str) {
		String[] pass=new String[str.length()];//문자열 크기 초기화
		String publishKey="";
		for(int i=0;i<str.length();i++){
			pass[i]=str.substring(i,i+1);
			pass[i]=String.valueOf(pass[i].hashCode()*127);
			pass[i]=pass[i].substring(0,1);
			publishKey=publishKey+pass[i];
		}
		publishKey.hashCode();
		return publishKey;
	}

	@Override
	public MemberVO modifyPass(MemberVO mvo) {
		//비밀번호 암호화 작업
		String memPass=mvo.getMemPass();
		mvo.setMemPass(encryptStr(memPass));
		memberDAO.modifyPass(mvo);
		return memberDAO.findMemberById(mvo.getMemId());
		
	}

	@Override
	public void sleepMember(MemberVO mvo) {
		memberDAO.sleepMember(mvo);
	}

}
