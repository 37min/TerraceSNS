package terrace.common;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import terrace.service.MemberService;
import terrace.vo.MemberVO;

//회원 로그인 여부에 관한 인터셉터 정의
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Resource(name = "memberServiceImpl")
	private MemberService memberService;

	/**
	 * method : preHandler comment : 컨트롤러 접근 전 핸들러
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * 
	 * @author 김병각
	 * @date 2014-09-02
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		boolean autoLoginFlag = false;// 쿠키에 저장여부를 확인하는 variable
		String memberCookieInfo = "";// 쿠키에 저장된 내용을 저장하는 variable

		if (session == null || session.getAttribute("loginInfo") == null) {// 비로그인 상태일 경우
			
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
				for(int i=0;i<cookies.length;i++){//사용자의 모든 쿠키를 확인
					if(cookies[i].getName().equals("terrace_autoLogin")){//자동로그인 쿠키가 존재하면,
						autoLoginFlag=true;//자동로그인 여부 true
						memberCookieInfo=cookies[i].getValue();//쿠키에 저장된 회원 정보를 추출
					}//if
				}//for
			}//if
			if(autoLoginFlag==true){//쿠키에 회원정보가 저장되어 있으면, 로그인 적용
				//저장된 회원 정보 형태 -> "memId/memPass"
				String[] info=null;
				info=memberCookieInfo.split("/");
					
				MemberVO mvo=new MemberVO();
					
				mvo.setMemId(info[0]);
				mvo.setMemPass(info[1]);
				MemberVO rvo=memberService.loginMember(mvo);
				if(rvo!=null){
					session.setAttribute("loginInfo", rvo);
				}
			}else{//쿠키에 회원정보가 없으면, 로그인화면으로 redirect
				response.sendRedirect(request.getContextPath()+"/loginView.do");
				return false;
			}
		}	
		return true;	
		}
}
