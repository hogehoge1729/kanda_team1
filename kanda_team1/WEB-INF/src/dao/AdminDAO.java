package dao;
import java.sql.*;
import java.util.ArrayList;

import bean.AdminDTO;
import bean.MemberDTO;

public class AdminDAO {

	//接続用情報
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/kandadb";
	private static final String USER = "root";
	private static final String PASSWD = "root123";

	//DB接続
	public static Connection getConnection(){
		try{
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	public AdminDTO selectByAdmin(String mail, String pass) {
		Connection con = null;
		Statement smt = null;
		AdminDTO admin = new AdminDTO();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM administrator WHERE mail='" + mail
					+ "' AND password='" + pass + "'";

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				admin.setMail(rs.getString("mail"));
				admin.setPass(rs.getString("password"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		return admin;
	}



	//DBから会員情報の全てを検索
	public ArrayList<MemberDTO> selectAll()	{
		//return用オブジェクト生成
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		//SQL文
		String sql = "SELECT * FROM member_Info";

		Connection con = null;
		Statement  smt = null;
		try{
			con = AdminDAO.getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()){
				MemberDTO member = new MemberDTO();
				member.setMemberId(rs.getInt("member_id"));
				member.setMamberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setKanjiFamilyName(rs.getString("kanji_family_name"));
				member.setKanjiFirstName(rs.getString("kanji_first_name"));
				member.setKanaFamilyName(rs.getString("kana_family_name"));
				member.setKanaFirstName(rs.getString("kana_first_name"));
				member.setResidence(rs.getString("residence"));
				member.setMail(rs.getString("mail"));
				member.setTelephoneNumber(rs.getString("telephone_number"));
				member.setAccountStatus(rs.getInt("account_status"));
				list.add(member);
			}

		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally{
			if(smt != null){
				try{smt.close();}catch(SQLException ignore){}
			}
			if(con != null){
				try{con.close();}catch(SQLException ignore){}
			}
		}
		return list;
	}

	//通報された人絞り込み検索
	public ArrayList<MemberDTO> search(String mamberName, String kanjiFamilyName, String kanjiFirstName, String mail, String residence, String accountStatus){
		Connection con = null;
		Statement smt = null;

		//return用オブジェクト生成
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		//SQL文
		String sql = "SELECT * FROM member_Info "
				+"WHERE member_name LIKE '%" + mamberName
				+ "%' AND kanji_family_name LIKE '%" + kanjiFamilyName
				+ "%' AND kanji_first_name LIKE '%" + kanjiFirstName
				+ "%' AND mail LIKE '%" + mail
				+ "%' AND residence LIKE '%" + residence
				+ "%' AND account_status = 1";

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setMemberId(rs.getInt("member_id"));
				member.setMamberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setKanjiFamilyName(rs.getString("kanji_family_name"));
				member.setKanjiFirstName(rs.getString("kanji_first_name"));
				member.setKanaFamilyName(rs.getString("kana_family_name"));
				member.setKanaFirstName(rs.getString("kana_first_name"));
				member.setResidence(rs.getString("residence"));
				member.setMail(rs.getString("mail"));
				member.setTelephoneNumber(rs.getString("telephone_number"));
				member.setAccountStatus(rs.getInt("account_status"));
				list.add(member);
			}

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			//リソースの解放
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return list;
	}

	//会員絞り込み検索
	public ArrayList<MemberDTO> search(String mamberName, String kanjiFamilyName, String kanjiFirstName, String mail, String residence, int accountStatus){
		Connection con = null;
		Statement smt = null;

		//return用オブジェクト生成
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		//SQL文
		String sql = "SELECT * FROM member_Info "
				+"WHERE member_name LIKE '%" + mamberName
				+ "%' AND kanji_family_name LIKE '%" + kanjiFamilyName
				+ "%' AND kanji_first_name LIKE '%" + kanjiFirstName
				+ "%' AND mail LIKE '%" + mail
				+ "%' AND residence LIKE '%" + residence
				+ "%' AND account_status = " + accountStatus;

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setMemberId(rs.getInt("member_id"));
				member.setMamberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setKanjiFamilyName(rs.getString("kanji_family_name"));
				member.setKanjiFirstName(rs.getString("kanji_first_name"));
				member.setKanaFamilyName(rs.getString("kana_family_name"));
				member.setKanaFirstName(rs.getString("kana_first_name"));
				member.setResidence(rs.getString("residence"));
				member.setMail(rs.getString("mail"));
				member.setTelephoneNumber(rs.getString("telephone_number"));
				member.setAccountStatus(rs.getInt("account_status"));
				list.add(member);
			}

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			//リソースの解放
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return list;
	}

	//出品した人絞り込み検索
	public ArrayList<MemberDTO> searchShopper(String mamberName, String kanjiFamilyName, String kanjiFirstName, String mail, String residence, int accountStatus){
		Connection con = null;
		Statement smt = null;

		//return用オブジェクト生成
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		//SQL文
		String sql = "SELECT DISTINCT sell.seller_member_id, member_info. * FROM sell "
				+ "INNER JOIN member_info ON sell.seller_member_id = member_info.member_id "
				+"WHERE member_name LIKE '%" + mamberName
				+ "%' AND kanji_family_name LIKE '%" + kanjiFamilyName
				+ "%' AND kanji_first_name LIKE '%" + kanjiFirstName
				+ "%' AND mail LIKE '%" + mail
				+ "%' AND residence LIKE '%" + residence
				+ "%' AND account_status = " + accountStatus;

		try {
			con = getConnection();
			smt = con.createStatement();

			//SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			//検索結果を配列に格納
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setMemberId(rs.getInt("member_id"));
				member.setMamberName(rs.getString("member_name"));
				member.setPassword(rs.getString("password"));
				member.setKanjiFamilyName(rs.getString("kanji_family_name"));
				member.setKanjiFirstName(rs.getString("kanji_first_name"));
				member.setKanaFamilyName(rs.getString("kana_family_name"));
				member.setKanaFirstName(rs.getString("kana_first_name"));
				member.setResidence(rs.getString("residence"));
				member.setMail(rs.getString("mail"));
				member.setTelephoneNumber(rs.getString("telephone_number"));
				member.setAccountStatus(rs.getInt("account_status"));
				list.add(member);
			}

		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			//リソースの解放
			if(smt != null) {
				try {smt.close();}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();}catch(SQLException ignore) {}
			}
		}
		return list;
	}
}


