package terrace.vo;

/**
 * 마이 테라스 Value Object
 */
public class TerraceMyVO {
	private MemberVO mvo;//회원 아이디(이메일)
	private TerraceVO tvo;//테라스 번호
	//constructor
	public TerraceMyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TerraceMyVO(MemberVO mvo, TerraceVO tvo) {
		super();
		this.mvo = mvo;
		this.tvo = tvo;
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
	@Override
	public String toString() {
		return "TerraceMyVO [mvo=" + mvo + ", tvo=" + tvo + "]";
	}
	
}