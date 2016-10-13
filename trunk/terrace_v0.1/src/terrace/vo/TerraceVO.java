package terrace.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * 테라스 관련 Value Object
 */
public class TerraceVO {
	//member variable
	private int terNo;//테라스 시퀀스 번호
	private String terName;//테라스 이름
	private String terIntro;//테라스 소개글
	private String terAdmin;//테라스 관리자 아이디
	private int terLock;//테라스 공개여부
	private int terRegister;//테라스 가입가능 여부
	private String terCategory;//테라스 카테고리
	private String terJoinList;//조인된 테라스 목록( ex) 1/3/4/5 )
	private String terIconOrgImg;//클라이언트 테라스 아이콘 이미지 imgname.jpg
	private String terIconNewImg;//서버측 테라스 아이콘 이미지 20141010130_imgname.jpg
	private MultipartFile uploadIconImg;//실제 아이콘 이미지 
	private String terCoverOrgImg;//테라스 커버 이미지
	private String terCoverNewImg;//테라스 커버 이미지
	private MultipartFile uploadCoverImg;//실제 아이콘 이미지
	//constructor
	public TerraceVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TerraceVO(int terNo, String terName, String terIntro,
			String terAdmin, int terLock, int terRegister, String terCategory,
			String terJoinList, String terIconOrgImg, String terIconNewImg,
			MultipartFile uploadIconImg, String terCoverOrgImg,
			String terCoverNewImg, MultipartFile uploadCoverImg) {
		super();
		this.terNo = terNo;
		this.terName = terName;
		this.terIntro = terIntro;
		this.terAdmin = terAdmin;
		this.terLock = terLock;
		this.terRegister = terRegister;
		this.terCategory = terCategory;
		this.terJoinList = terJoinList;
		this.terIconOrgImg = terIconOrgImg;
		this.terIconNewImg = terIconNewImg;
		this.uploadIconImg = uploadIconImg;
		this.terCoverOrgImg = terCoverOrgImg;
		this.terCoverNewImg = terCoverNewImg;
		this.uploadCoverImg = uploadCoverImg;
	}
	public int getTerNo() {
		return terNo;
	}
	public void setTerNo(int terNo) {
		this.terNo = terNo;
	}
	public String getTerName() {
		return terName;
	}
	public void setTerName(String terName) {
		this.terName = terName;
	}
	public String getTerIntro() {
		return terIntro;
	}
	public void setTerIntro(String terIntro) {
		this.terIntro = terIntro;
	}
	public String getTerAdmin() {
		return terAdmin;
	}
	public void setTerAdmin(String terAdmin) {
		this.terAdmin = terAdmin;
	}
	public int getTerLock() {
		return terLock;
	}
	public void setTerLock(int terLock) {
		this.terLock = terLock;
	}
	public int getTerRegister() {
		return terRegister;
	}
	public void setTerRegister(int terRegister) {
		this.terRegister = terRegister;
	}
	public String getTerCategory() {
		return terCategory;
	}
	public void setTerCategory(String terCategory) {
		this.terCategory = terCategory;
	}
	public String getTerJoinList() {
		return terJoinList;
	}
	public void setTerJoinList(String terJoinList) {
		this.terJoinList = terJoinList;
	}
	public String getTerIconOrgImg() {
		return terIconOrgImg;
	}
	public void setTerIconOrgImg(String terIconOrgImg) {
		this.terIconOrgImg = terIconOrgImg;
	}
	public String getTerIconNewImg() {
		return terIconNewImg;
	}
	public void setTerIconNewImg(String terIconNewImg) {
		this.terIconNewImg = terIconNewImg;
	}
	public MultipartFile getUploadIconImg() {
		return uploadIconImg;
	}
	public void setUploadIconImg(MultipartFile uploadIconImg) {
		this.uploadIconImg = uploadIconImg;
	}
	public String getTerCoverOrgImg() {
		return terCoverOrgImg;
	}
	public void setTerCoverOrgImg(String terCoverOrgImg) {
		this.terCoverOrgImg = terCoverOrgImg;
	}
	public String getTerCoverNewImg() {
		return terCoverNewImg;
	}
	public void setTerCoverNewImg(String terCoverNewImg) {
		this.terCoverNewImg = terCoverNewImg;
	}
	public MultipartFile getUploadCoverImg() {
		return uploadCoverImg;
	}
	public void setUploadCoverImg(MultipartFile uploadCoverImg) {
		this.uploadCoverImg = uploadCoverImg;
	}
	@Override
	public String toString() {
		return "TerraceVO [terNo=" + terNo + ", terName=" + terName
				+ ", terIntro=" + terIntro + ", terAdmin=" + terAdmin
				+ ", terLock=" + terLock + ", terRegister=" + terRegister
				+ ", terCategory=" + terCategory + ", terJoinList="
				+ terJoinList + ", terIconOrgImg=" + terIconOrgImg
				+ ", terIconNewImg=" + terIconNewImg + ", uploadIconImg="
				+ uploadIconImg + ", terCoverOrgImg=" + terCoverOrgImg
				+ ", terCoverNewImg=" + terCoverNewImg + ", uploadCoverImg="
				+ uploadCoverImg + "]";
	}
	
}