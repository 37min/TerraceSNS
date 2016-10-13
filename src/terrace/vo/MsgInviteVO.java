package terrace.vo;

/**
 * 테라스 초대 메시지 관련 Value Object
 */
public class MsgInviteVO {
	// member variable
	private int miNo;// 초대 메시지 번호
	private String miDate;// 초대 메시지 보낸 날짜
	private TerraceVO miTvo;// 초대 메시지 보내는 테라스 객체
	private MemberVO miSendMvo;// 초대 메시지 보내는 회원 객체
	private MemberVO miRecMvo;// 초대 메시지 받는 회원 객체

	// constructor
	public MsgInviteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MsgInviteVO(int miNo, String miDate, TerraceVO miTvo,
			MemberVO miSendMvo, MemberVO miRecMvo) {
		super();
		this.miNo = miNo;
		this.miDate = miDate;
		this.miTvo = miTvo;
		this.miSendMvo = miSendMvo;
		this.miRecMvo = miRecMvo;
	}

	public int getMiNo() {
		return miNo;
	}

	public void setMiNo(int miNo) {
		this.miNo = miNo;
	}

	public String getMiDate() {
		return miDate;
	}

	public void setMiDate(String miDate) {
		this.miDate = miDate;
	}

	public TerraceVO getMiTvo() {
		return miTvo;
	}

	public void setMiTvo(TerraceVO miTvo) {
		this.miTvo = miTvo;
	}

	public MemberVO getMiSendMvo() {
		return miSendMvo;
	}

	public void setMiSendMvo(MemberVO miSendMvo) {
		this.miSendMvo = miSendMvo;
	}

	public MemberVO getMiRecMvo() {
		return miRecMvo;
	}

	public void setMiRecMvo(MemberVO miRecMvo) {
		this.miRecMvo = miRecMvo;
	}

	@Override
	public String toString() {
		return "MsgInviteVO [miNo=" + miNo + ", miDate=" + miDate + ", miTvo="
				+ miTvo + ", miSendMvo=" + miSendMvo + ", miRecMvo=" + miRecMvo
				+ "]";
	}
	
}
