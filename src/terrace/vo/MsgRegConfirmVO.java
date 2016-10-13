package terrace.vo;
/**
 * 가입 승인여부 메시지 관련 Value Object
 */
public class MsgRegConfirmVO {
	//member variable
	private int mrcNo;//가입 승인여부 메시지 번호
	private int mrcCofirm;//가입 승인여부 메시지 승인여부
	private String mrcDate;//가입 승인여부 메시지 보낸 날짜
	private TerraceVO mrcSendTvo;//가입 승인여부 메시지 보내는 테라스 객체
	private MemberVO mrcSendMvo;//가입 승인여부 메시지 보내는 회원 객체
	private MemberVO mrcRecMvo;//가입 승인여부 메시지 받는 회원 객체
	//constructor
	public MsgRegConfirmVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgRegConfirmVO(int mrcNo, int mrcCofirm, String mrcDate,
			TerraceVO mrcSendTvo, MemberVO mrcSendMvo, MemberVO mrcRecMvo) {
		super();
		this.mrcNo = mrcNo;
		this.mrcCofirm = mrcCofirm;
		this.mrcDate = mrcDate;
		this.mrcSendTvo = mrcSendTvo;
		this.mrcSendMvo = mrcSendMvo;
		this.mrcRecMvo = mrcRecMvo;
	}
	public int getMrcNo() {
		return mrcNo;
	}
	public void setMrcNo(int mrcNo) {
		this.mrcNo = mrcNo;
	}
	public int getMrcCofirm() {
		return mrcCofirm;
	}
	public void setMrcCofirm(int mrcCofirm) {
		this.mrcCofirm = mrcCofirm;
	}
	public String getMrcDate() {
		return mrcDate;
	}
	public void setMrcDate(String mrcDate) {
		this.mrcDate = mrcDate;
	}
	public TerraceVO getMrcSendTvo() {
		return mrcSendTvo;
	}
	public void setMrcSendTvo(TerraceVO mrcSendTvo) {
		this.mrcSendTvo = mrcSendTvo;
	}
	public MemberVO getMrcSendMvo() {
		return mrcSendMvo;
	}
	public void setMrcSendMvo(MemberVO mrcSendMvo) {
		this.mrcSendMvo = mrcSendMvo;
	}
	public MemberVO getMrcRecMvo() {
		return mrcRecMvo;
	}
	public void setMrcRecMvo(MemberVO mrcRecMvo) {
		this.mrcRecMvo = mrcRecMvo;
	}
	@Override
	public String toString() {
		return "MsgRegConfirmVO [mrcNo=" + mrcNo + ", mrcCofirm=" + mrcCofirm
				+ ", mrcDate=" + mrcDate + ", mrcSendTvo=" + mrcSendTvo
				+ ", mrcSendMvo=" + mrcSendMvo + ", mrcRecMvo=" + mrcRecMvo
				+ "]";
	}
	
}