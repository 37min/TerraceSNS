package terrace.vo;
/**
 * 조인 메시지 Value Object
 */
public class MsgJoinVO {
	//member variable
	private int mjNo;//조인메시지 번호
	private String mjSendMembers;//보내는 테라스 회원명단
	private String mjSendTitle;//보내는 메시지 제목
	private String mjSendMsg;//보내는 메시지 내용
	private String mjDate;//보낸 날짜
	private TerraceVO mjSendTvo;//보내는 테라스 객체
	private TerraceVO mjRecTvo;//받는 테라스 객체
	//constructor
	public MsgJoinVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MsgJoinVO(int mjNo, String mjSendMembers, String mjSendTitle,
			String mjSendMsg, String mjDate, TerraceVO mjSendTvo,
			TerraceVO mjRecTvo) {
		super();
		this.mjNo = mjNo;
		this.mjSendMembers = mjSendMembers;
		this.mjSendTitle = mjSendTitle;
		this.mjSendMsg = mjSendMsg;
		this.mjDate = mjDate;
		this.mjSendTvo = mjSendTvo;
		this.mjRecTvo = mjRecTvo;
	}

	public int getMjNo() {
		return mjNo;
	}

	public void setMjNo(int mjNo) {
		this.mjNo = mjNo;
	}

	public String getMjSendMembers() {
		return mjSendMembers;
	}

	public void setMjSendMembers(String mjSendMembers) {
		this.mjSendMembers = mjSendMembers;
	}

	public String getMjSendTitle() {
		return mjSendTitle;
	}

	public void setMjSendTitle(String mjSendTitle) {
		this.mjSendTitle = mjSendTitle;
	}

	public String getMjSendMsg() {
		return mjSendMsg;
	}

	public void setMjSendMsg(String mjSendMsg) {
		this.mjSendMsg = mjSendMsg;
	}

	public String getMjDate() {
		return mjDate;
	}

	public void setMjDate(String mjDate) {
		this.mjDate = mjDate;
	}

	public TerraceVO getMjSendTvo() {
		return mjSendTvo;
	}

	public void setMjSendTvo(TerraceVO mjSendTer) {
		this.mjSendTvo = mjSendTvo;
	}

	public TerraceVO getMjRecTvo() {
		return mjRecTvo;
	}

	public void setMjRecTvo(TerraceVO mjRecTvo) {
		this.mjRecTvo = mjRecTvo;
	}

	@Override
	public String toString() {
		return "MsgJoinVO [mjNo=" + mjNo + ", mjSendMembers=" + mjSendMembers
				+ ", mjSendTitle=" + mjSendTitle + ", mjSendMsg=" + mjSendMsg
				+ ", mjDate=" + mjDate + ", mjSendTvo=" + mjSendTvo
				+ ", mjRecTvo=" + mjRecTvo + "]";
	}



}
