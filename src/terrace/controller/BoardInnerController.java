package terrace.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import terrace.service.BoardInnerService;
/**
 * 특정 테라스 내부 게시판 관련 컨트롤러
 */
@Controller
public class BoardInnerController {
	
	public BoardInnerController() {
		super();
	}

	// Service Dependency Injection
	@Resource(name="boardInnerServiceImpl")
	private BoardInnerService boardInnerService;
	
	@RequestMapping("boardInnerList.do")
	public String boardInnerList(){
		return "terrace.board_list";
	}
}
