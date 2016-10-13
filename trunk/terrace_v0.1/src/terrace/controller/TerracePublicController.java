package terrace.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import terrace.service.TerracePublicService;
/**
 * 공개된 전체 테라스 관련 컨트롤러
 */
@Controller
public class TerracePublicController {
	// Service Dependency Injection
	@Resource(name="terracePublicServiceImpl")
	private TerracePublicService terracePublicService;
}
