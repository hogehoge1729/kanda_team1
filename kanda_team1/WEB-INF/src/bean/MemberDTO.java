package bean;

public class MemberDTO {
	private int memberId;
	private String password;
	private String kanjiFamilyName;
	private String kanjiFirstName;
	private String kanaFamilyName;
	private String kanaFirstName;
	private String residence;
	private String mail;
	private String telephoneNumber;
	private int accountStatus;

	private String mamberName;

	public String getMamberName(){
		return this.mamberName;
	}
	public void setMamberName(String memberName){
		this.mamberName=memberName;
	}


	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKanjiFamilyName() {
		return kanjiFamilyName;
	}
	public void setKanjiFamilyName(String kanjiFamilyName) {
		this.kanjiFamilyName = kanjiFamilyName;
	}
	public String getKanjiFirstName() {
		return kanjiFirstName;
	}
	public void setKanjiFirstName(String kanjiFirstName) {
		this.kanjiFirstName = kanjiFirstName;
	}
	public String getKanaFamilyName() {
		return kanaFamilyName;
	}
	public void setKanaFamilyName(String kanaFamilyName) {
		this.kanaFamilyName = kanaFamilyName;
	}
	public String getKanaFirstName() {
		return kanaFirstName;
	}
	public void setKanaFirstName(String kanaFirstName) {
		this.kanaFirstName = kanaFirstName;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

}