package terrace.vo;
/**
 * 가입 요청 메시지 관련 Value Object
 */
public class MsgRegRequestVO {
	//member variable
	private int mrrNo;//가입 요청 메시지 번호
	private String mrrDate;//가입 요청 메시지 보낸 날짜
	private TerraceVO mrrRecTvo;//가입 요청 메시지 받는 테라스 객체
	private MemberVO  mrrSendMvo;//가입 요청 메시지 보내는 회원 객체
	//constructor
	public MsgRegRequestVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgRegRequestVO(int mrrNo, String mrrDate, TerraceVO mrrRecTvo,
			MemberVO mrrSendMvo) {
		super();
		this.mrrNo = mrrNo;
		this.mrrDate = mrrDate;
		this.mrrRecTvo = mrrRecTvo;
		this.mrrSendMvo = mrrSendMvo;
	}
	public int getMrrNo() {
		return mrrNo;
	}
	public void setMrrNo(int mrrNo) {
		this.mrrNo = mrrNo;
	}
	public String getMrrDate() {
		return mrrDate;
	}
	public void setMrrDate(String mrrDate) {
		this.mrrDate = mrrDate;
	}
	public TerraceVO getMrrRecTvo() {
		return mrrRecTvo;
	}
	public void setMrrRecTvo(TerraceVO mrrRecTvo) {
		this.mrrRecTvo = mrrRecTvo;
	}
	public MemberVO getMrrSendMvo() {
		return mrrSendMvo;
	}
	public void setMrrSendMvo(MemberVO mrrSendMvo) {
		this.mrrSendMvo = mrrSendMvo;
	}
	@Override
	public String toString() {
		return "MsgRegRequestVO [mrrNo=" + mrrNo + ", mrrDate=" + mrrDate
				+ ", mrrRecTvo=" + mrrRecTvo + ", mrrSendMvo=" + mrrSendMvo
				+ "]";
	}
	
}