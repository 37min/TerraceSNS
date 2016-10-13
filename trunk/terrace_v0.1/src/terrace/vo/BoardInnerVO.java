package terrace.vo;
/**
 * 테라스 내부 게시판 관련 Value Object
 */
public class BoardInnerVO {
	//member variable
	private int biNo;//내부게시판 글번호
	private String biContents;//내부게시판 글내용
	private String biDate;//내부게시판 작성날짜
	private String biLock;//내부게시판 게시글 공개여부
	private MemberVO mvo;//내부게시판 작성자 객체
	private TerraceVO tvo;//내부게시판 테라스 객체
	//constructor
	public BoardInnerVO() {
		super();
	}	
	public BoardInnerVO(int biNo, String biContents, String biDate,
			String biLock, MemberVO mvo, TerraceVO tvo) {
		super();
		this.biNo = biNo;
		this.biContents = biContents;
		this.biDate = biDate;
		this.biLock = biLock;
		this.mvo = mvo;
		this.tvo = tvo;
	}


	//setter/getter
	public int getBiNo() {
		return biNo;
	}
	public void setBiNo(int biNo) {
		this.biNo = biNo;
	}

	public MemberVO getMvo() {
		return mvo;
	}
	public void setMvo(MemberVO mvo) {
		this.mvo = mvo;
	}
	public TerraceVO getTvo() {
		return tvo;
	}
	public void setTvo(TerraceVO tvo) {
		this.tvo = tvo;
	}
	public String getBiContents() {
		return biContents;
	}
	public void setBiContents(String biContents) {
		this.biContents = biContents;
	}
	public String getBiDate() {
		return biDate;
	}
	public void setBiDate(String biDate) {
		this.biDate = biDate;
	}
	public String getBiLock() {
		return biLock;
	}
	public void setBiLock(String biLock) {
		this.biLock = biLock;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoardInnerVO [biNo=" + biNo + ", biContents=" + biContents
				+ ", biDate=" + biDate + ", biLock=" + biLock + ", mvo=" + mvo
				+ ", tvo=" + tvo + "]";
	}
	
}
