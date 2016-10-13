package terrace.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import terrace.dao.MessageDAO;
/**
 * 메시지 관련 서비스
 */
@Service
public class MessageServiceImpl implements MessageService{
	//DAO Dependency Injection
	@Resource(name="messageDAOImpl")
	private MessageDAO messageDAO;
}
