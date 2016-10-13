package terrace.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import terrace.service.TerraceMyService;
/**
 * 마이 테라스 관련 컨트롤러
 */
@Controller
public class TerraceMyController {
	// Service Dependency Injection
	@Resource(name="terraceMyServiceImpl")
	private TerraceMyService terraceMyService;
}
