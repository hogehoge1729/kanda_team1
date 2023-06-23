package dao;

import java.sql.*;

import bean.MemberDTO;

public class MemberDAO {

	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/kandadb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * DBから指定ユーザーとパスワードの条件に合致する情報を取得するメソッド
	 *
	 * @param String mail,String password;
	 * @return MemberDTO memberDto
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
	public MemberDTO selectByMember(String mail, String password) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用のオブジェクトの生成
		MemberDTO memberDto = new MemberDTO();

		try {

			// SQL文
			String sql = "SELECT * FROM member_info WHERE mail ='" + mail + "' AND password='" + password + "'";

			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果をmemberDtoに格納
			if (rs.next()) {

				memberDto.setMemberId(rs.getInt("member_id"));
				memberDto.setMamberName(rs.getString("member_name"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setKanjiFamilyName(rs.getString("kanji_family_name"));
				memberDto.setKanjiFirstName(rs.getString("kanji_first_name"));
				memberDto.setKanaFamilyName(rs.getString("kana_family_name"));
				memberDto.setKanaFirstName(rs.getString("kana_first_name"));
				memberDto.setResidence(rs.getString("residence"));
				memberDto.setMail(rs.getString("mail"));
				memberDto.setTelephoneNumber(rs.getString("telephone_number"));
				memberDto.setAccountStatus(Integer.parseInt(rs.getString("account_status")));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);

		} finally {
			// リソースの開放
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
		return memberDto;
	}

	public int memberInsert(MemberDTO member) {

		Connection con = null;
		PreparedStatement psmt = null;
		int count = 0;

		try {
			// insert文の作成
			String sql = "insert into member_info(password, kanji_family_name, kanji_first_name, kana_family_name, kana_first_name, residence, mail, telephone_number, account_status, member_name)  values(?,?,?,?,?,?,?,?,?,?); ";
			con = MemberDAO.getConnection();
			psmt = con.prepareStatement(sql);
			// ?の値を決める
			psmt.setString(1, member.getPassword());
			psmt.setString(2, member.getKanjiFamilyName());
			psmt.setString(3, member.getKanjiFirstName());
			psmt.setString(4, member.getKanaFamilyName());
			psmt.setString(5, member.getKanaFirstName());
			psmt.setString(6, member.getResidence());
			psmt.setString(7, member.getMail());
			psmt.setString(8, member.getTelephoneNumber());
			psmt.setInt(9, 0);
			psmt.setString(10, member.getMamberName());

			// SQL文の結果
			count = psmt.executeUpdate();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (psmt != null) {
				try {
					psmt.close();
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
		return count;
	}


	//Idから全てを取得
	public MemberDTO selectByMember(int id) {
		// 変数宣言
		Connection con = null;
		Statement smt = null;

		// return用のオブジェクトの生成
		MemberDTO memberDto = new MemberDTO();

		try {

			// SQL文
			String sql = "SELECT * FROM member_info WHERE member_id = "+id;

			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果をmemberDtoに格納
			if (rs.next()) {

				memberDto.setMemberId(rs.getInt("member_id"));
				memberDto.setMamberName(rs.getString("member_name"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setKanjiFamilyName(rs.getString("kanji_family_name"));
				memberDto.setKanjiFirstName(rs.getString("kanji_first_name"));
				memberDto.setKanaFamilyName(rs.getString("kana_family_name"));
				memberDto.setKanaFirstName(rs.getString("kana_first_name"));
				memberDto.setResidence(rs.getString("residence"));
				memberDto.setMail(rs.getString("mail"));
				memberDto.setTelephoneNumber(rs.getString("telephone_number"));
				memberDto.setAccountStatus(Integer.parseInt(rs.getString("account_status")));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);

		} finally {
			// リソースの開放
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
		return memberDto;
	}


	//通報
		public void statusUpdate(String sellerId) {
			Connection con = null;
			Statement smt = null;
			try {
				con = getConnection();
				smt = con.createStatement();
				// SQL文
				String sql = "UPDATE member_info SET account_status = 1 WHERE member_id = " + sellerId;
				System.out.println(sql);

				// SQLをDBへ発行
				smt.executeUpdate(sql);

			} catch (Exception e) {
				throw new IllegalStateException(e);
			} finally {
				// リソースの開放
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
		}
}
