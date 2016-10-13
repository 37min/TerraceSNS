package terrace.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * 회원 관련 Value Object
 */
public class MemberVO {
	// member variable
	private String memId;// 회원 아이디(이메일)
	private String memPass;// 회원 비밀번호
	private String memName;// 회원 이름
	private String memUniv;// 회원 대학명
	private String memDept;// 회원 학부명
	private String memNo;// 회원 학번
	private String memPhone;// 회원 휴대폰번호
	private int memSleep;// 회원 계정 활성화 유무
	private String memOrgImg;// 클라이언트 업로드 파일이름
	private String memNewImg;// 서버 저장 파일 이름
	private MultipartFile uploadImg;// 실제 파일

	// constructor
	public MemberVO() {
		super();
	}

	public MemberVO(String memId, String memPass, String memName,
			String memUniv, String memDept, String memNo, String memPhone,
			int memSleep, String memOrgImg, String memNewImg,
			MultipartFile uploadImg) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memUniv = memUniv;
		this.memDept = memDept;
		this.memNo = memNo;
		this.memPhone = memPhone;
		this.memSleep = memSleep;
		this.memOrgImg = memOrgImg;
		this.memNewImg = memNewImg;
		this.uploadImg = uploadImg;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPass() {
		return memPass;
	}

	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemUniv() {
		return memUniv;
	}

	public void setMemUniv(String memUniv) {
		this.memUniv = memUniv;
	}

	public String getMemDept() {
		return memDept;
	}

	public void setMemDept(String memDept) {
		this.memDept = memDept;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public int getMemSleep() {
		return memSleep;
	}

	public void setMemSleep(int memSleep) {
		this.memSleep = memSleep;
	}

	public String getMemOrgImg() {
		return memOrgImg;
	}

	public void setMemOrgImg(String memOrgImg) {
		this.memOrgImg = memOrgImg;
	}

	public String getMemNewImg() {
		return memNewImg;
	}

	public void setMemNewImg(String memNewImg) {
		this.memNewImg = memNewImg;
	}

	public MultipartFile getUploadImg() {
		return uploadImg;
	}

	public void setUploadImg(MultipartFile uploadImg) {
		this.uploadImg = uploadImg;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass
				+ ", memName=" + memName + ", memUniv=" + memUniv
				+ ", memDept=" + memDept + ", memNo=" + memNo + ", memPhone="
				+ memPhone + ", memSleep=" + memSleep + ", memOrgImg="
				+ memOrgImg + ", memNewImg=" + memNewImg + ", uploadImg="
				+ uploadImg + "]";
	}
	
}