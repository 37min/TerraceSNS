package terrace.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import terrace.vo.MemberVO;
/**
 * 회원 관련 데이터베이스 접근 객체
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public MemberVO loginMember(MemberVO mvo) {
		MemberVO rvo = sqlSessionTemplate.selectOne("mem.loginMember", mvo);
		return rvo;
	}
	
	@Override
	public MemberVO findMemberById(String memId) {
		MemberVO mvo=sqlSessionTemplate.selectOne("mem.findMemberById", memId);
		return mvo;
	}

	@Override
	public List getUnivListByUnivLoc(String univLoc) {
		return sqlSessionTemplate.selectList("univ.getUnivListByUnivLoc",univLoc);
	}

	@Override
	public String getUnivEmailByUnivName(String univName) {
		return sqlSessionTemplate.selectOne("univ.getUnivEmailByUnivName", univName);
	}

	@Override
	public void registerMember(MemberVO mvo) {
		sqlSessionTemplate.insert("mem.registerMember", mvo);
	}

	@Override
	public int memNoCheck(String memNo) {
		return sqlSessionTemplate.selectOne("mem.memNoCheck", memNo);
	}

	@Override
	public MemberVO findMemIdByNameAndMemNo(MemberVO mvo) {
		return sqlSessionTemplate.selectOne("mem.findMemIdByNameAndMemNo", mvo);
	}

	@Override
	public void modifyMember(MemberVO mvo) {
		sqlSessionTemplate.update("mem.modifyMember", mvo);
	}
	
	@Override
	public void modifyMemberAndImg(MemberVO mvo) {
		sqlSessionTemplate.update("mem.modifyMemberAndImg", mvo);
	}

	@Override
	public void modifyPass(MemberVO mvo) {
		sqlSessionTemplate.update("mem.modifyPass", mvo);
	}

	@Override
	public void sleepMember(MemberVO mvo) {
		//계정 활성화 상태 업데이트
		if(mvo.getMemSleep()==1){//계정이 비활성화 상태였다면,
			mvo.setMemSleep(0);
		}else{//계정이 활성화 상태였다면,
			mvo.setMemSleep(1);
		}
		sqlSessionTemplate.update("mem.sleepMember",mvo);
	}

}
