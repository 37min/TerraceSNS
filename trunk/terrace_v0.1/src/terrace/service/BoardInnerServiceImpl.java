package terrace.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.BoardInnerDAO;
/**
 * 테라스 내부 게시판 관련 서비스
 */
@Service
public class BoardInnerServiceImpl implements BoardInnerService{
	//DAO Dependency Injection
	@Resource(name="boardInnerDAOImpl")
	private BoardInnerDAO boardInnerDAO;
}
