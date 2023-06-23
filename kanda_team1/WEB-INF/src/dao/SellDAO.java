package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.MemberDTO;
import bean.SellDTO;

public class SellDAO {

	// 接続用情報
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/kandadb";
	private static final String USER = "root";
	private static final String PASSWD = "root123";

	// DB接続
	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	// DBから商品画像と商品名と値段を検索
	public ArrayList<SellDTO> selectAll() {
		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();
		// SQL文
		String sql = "SELECT * FROM sell WHERE sell_status = '出品中'";

		Connection con = null;
		Statement smt = null;
		try {
			con = SellDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				SellDTO sellDto = new SellDTO();
				sellDto.setSellId(rs.getInt("sell_id"));
				sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
				sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
				sellDto.setProductName(rs.getString("product_name"));
				sellDto.setProductType(rs.getString("product_type"));
				sellDto.setPrice(rs.getInt("price"));
				sellDto.setPrefectures(rs.getString("prefectures"));
				sellDto.setRemarks(rs.getString("remarks"));
				sellDto.setDeliveryDays(rs.getInt("delivery_days"));
				sellDto.setProductCondition(rs.getString("product_condition"));
				sellDto.setImagePath(rs.getString("image_path"));
				sellDto.setSellStatus(rs.getString("sell_status"));
				sellDto.setSellDate(rs.getString("sell_date"));
				sellDto.setPurchaseDate(rs.getString("purchase_date"));
				sellDto.setTransferDate(rs.getString("transfer_date"));
				sellDto.setShipmentDate(rs.getString("shipment_date"));
				sellDto.setCompletionDate(rs.getString("completion_date"));
				list.add(sellDto);
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
		return list;
	}

	// 絞り込み検索
	public ArrayList<SellDTO> search(String productType, String strPrice1, String strPrice2, String prefectures,
			String productCondition) {
		Connection con = null;
		Statement smt = null;

		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();

		if (strPrice1 != null) {
			int price1 = Integer.parseInt(strPrice1);
			int price2 = Integer.parseInt(strPrice2);

			if (price1 == 1) {
				price1 = 10000;
			} else if (price1 == 2) {
				price1 = 8000;
			} else {
				price1 = 5000;
			}

			if (price2 == 1) {
				price2 = 500;
			} else if (price2 == 2) {
				price2 = 1000;
			} else {
				price2 = 3000;
			}

			// SQL文
			String sql = "SELECT * FROM sell " + "WHERE product_type = '" + productType + "' AND price BETWEEN "
					+ price2 + " AND " + price1 + " AND prefectures = '" + prefectures + "' AND product_condition = '"
					+ productCondition + "' AND sell_status = '出品中'";

			try {
				con = getConnection();
				smt = con.createStatement();

				// SQL文発行
				ResultSet rs = smt.executeQuery(sql);

				// 検索結果を配列に格納
				while (rs.next()) {
					SellDTO sellDto = new SellDTO();
					sellDto.setSellId(rs.getInt("sell_id"));
					sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
					sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
					sellDto.setProductName(rs.getString("product_name"));
					sellDto.setProductType(rs.getString("product_type"));
					sellDto.setPrice(rs.getInt("price"));
					sellDto.setPrefectures(rs.getString("prefectures"));
					sellDto.setRemarks(rs.getString("remarks"));
					sellDto.setDeliveryDays(rs.getInt("delivery_days"));
					sellDto.setProductCondition(rs.getString("product_condition"));
					sellDto.setImagePath(rs.getString("image_path"));
					sellDto.setSellStatus(rs.getString("sell_status"));
					sellDto.setSellDate(rs.getString("sell_date"));
					sellDto.setPurchaseDate(rs.getString("purchase_date"));
					sellDto.setTransferDate(rs.getString("transfer_date"));
					sellDto.setShipmentDate(rs.getString("shipment_date"));
					sellDto.setCompletionDate(rs.getString("completion_date"));
					list.add(sellDto);
				}

			} catch (Exception e) {
				throw new IllegalStateException(e);
			} finally {
				// リソースの解放
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
		return list;
	}

	// 安い順並び替え
	public ArrayList<SellDTO> sortCheap() {
		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();
		// SQL文
		String sql = "SELECT * FROM sell WHERE sell_status = '出品中' ORDER BY price";

		Connection con = null;
		Statement smt = null;
		try {
			con = SellDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				SellDTO sellDto = new SellDTO();
				sellDto.setSellId(rs.getInt("sell_id"));
				sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
				sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
				sellDto.setProductName(rs.getString("product_name"));
				sellDto.setProductType(rs.getString("product_type"));
				sellDto.setPrice(rs.getInt("price"));
				sellDto.setPrefectures(rs.getString("prefectures"));
				sellDto.setRemarks(rs.getString("remarks"));
				sellDto.setDeliveryDays(rs.getInt("delivery_days"));
				sellDto.setProductCondition(rs.getString("product_condition"));
				sellDto.setImagePath(rs.getString("image_path"));
				sellDto.setSellStatus(rs.getString("sell_status"));
				sellDto.setSellDate(rs.getString("sell_date"));
				sellDto.setPurchaseDate(rs.getString("purchase_date"));
				sellDto.setTransferDate(rs.getString("transfer_date"));
				sellDto.setShipmentDate(rs.getString("shipment_date"));
				sellDto.setCompletionDate(rs.getString("completion_date"));
				list.add(sellDto);
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
		return list;
	}

	// 高い順並び替え
	public ArrayList<SellDTO> sortExpensive() {
		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();
		// SQL文
		String sql = "SELECT * FROM sell WHERE sell_status = '出品中' ORDER BY price DESC";

		Connection con = null;
		Statement smt = null;
		try {
			con = SellDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				SellDTO sellDto = new SellDTO();
				sellDto.setSellId(rs.getInt("sell_id"));
				sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
				sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
				sellDto.setProductName(rs.getString("product_name"));
				sellDto.setProductType(rs.getString("product_type"));
				sellDto.setPrice(rs.getInt("price"));
				sellDto.setPrefectures(rs.getString("prefectures"));
				sellDto.setRemarks(rs.getString("remarks"));
				sellDto.setDeliveryDays(rs.getInt("delivery_days"));
				sellDto.setProductCondition(rs.getString("product_condition"));
				sellDto.setImagePath(rs.getString("image_path"));
				sellDto.setSellStatus(rs.getString("sell_status"));
				sellDto.setSellDate(rs.getString("sell_date"));
				sellDto.setPurchaseDate(rs.getString("purchase_date"));
				sellDto.setTransferDate(rs.getString("transfer_date"));
				sellDto.setShipmentDate(rs.getString("shipment_date"));
				sellDto.setCompletionDate(rs.getString("completion_date"));
				list.add(sellDto);
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
		return list;
	}

	// 更新日新しい順並び替え
	public ArrayList<SellDTO> sortNew() {
		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();
		// SQL文
		String sql = "SELECT * FROM sell WHERE sell_status = '出品中' ORDER BY sell_date";

		Connection con = null;
		Statement smt = null;
		try {
			con = SellDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				SellDTO sellDto = new SellDTO();
				sellDto.setSellId(rs.getInt("sell_id"));
				sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
				sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
				sellDto.setProductName(rs.getString("product_name"));
				sellDto.setProductType(rs.getString("product_type"));
				sellDto.setPrice(rs.getInt("price"));
				sellDto.setPrefectures(rs.getString("prefectures"));
				sellDto.setRemarks(rs.getString("remarks"));
				sellDto.setDeliveryDays(rs.getInt("delivery_days"));
				sellDto.setProductCondition(rs.getString("product_condition"));
				sellDto.setImagePath(rs.getString("image_path"));
				sellDto.setSellStatus(rs.getString("sell_status"));
				sellDto.setSellDate(rs.getString("sell_date"));
				sellDto.setPurchaseDate(rs.getString("purchase_date"));
				sellDto.setTransferDate(rs.getString("transfer_date"));
				sellDto.setShipmentDate(rs.getString("shipment_date"));
				sellDto.setCompletionDate(rs.getString("completion_date"));
				list.add(sellDto);
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
		return list;
	}

	// DBから商品画像と商品名と値段を検索
	public ArrayList<SellDTO> selectBySeller(int sellerId) {
		// return用オブジェクト生成
		ArrayList<SellDTO> list = new ArrayList<SellDTO>();
		// SQL文
		String sql = "SELECT * FROM sell WHERE seller_member_id = " + sellerId;
		System.out.println(sql);

		Connection con = null;
		Statement smt = null;
		try {
			con = SellDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 検索結果を配列に格納
			while (rs.next()) {
				SellDTO sellDto = new SellDTO();
				sellDto.setSellId(rs.getInt("sell_id"));
				sellDto.setSellerMemberId(rs.getInt("seller_member_id"));
				sellDto.setPurchaserMemberId(rs.getInt("purchaser_member_id"));
				sellDto.setProductName(rs.getString("product_name"));
				sellDto.setProductType(rs.getString("product_type"));
				sellDto.setPrice(rs.getInt("price"));
				sellDto.setPrefectures(rs.getString("prefectures"));
				sellDto.setRemarks(rs.getString("remarks"));
				sellDto.setDeliveryDays(rs.getInt("delivery_days"));
				sellDto.setProductCondition(rs.getString("product_condition"));
				sellDto.setImagePath(rs.getString("image_path"));
				sellDto.setSellStatus(rs.getString("sell_status"));
				sellDto.setSellDate(rs.getString("sell_date"));
				sellDto.setPurchaseDate(rs.getString("purchase_date"));
				sellDto.setTransferDate(rs.getString("transfer_date"));
				sellDto.setShipmentDate(rs.getString("shipment_date"));
				sellDto.setCompletionDate(rs.getString("completion_date"));
				list.add(sellDto);
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
		return list;
	}


	//購入
	public void buy(String sellId,MemberDTO member) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			int memberId=member.getMemberId();

			// SQL文
			String sql = "UPDATE sell SET sell_status = '振込まち',purchaser_member_id = "+memberId+" WHERE sell_id = "+sellId ;

			System.out.println(sql);
			//UPDATE `sell` SET `purchaser_member_id` = '2', `sell_status` = '振込まち' WHERE `sell`.`sell_id` = 2;
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

	//状況更新
	public void statusUpdate(String sellId,String state) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文
			String sql = "UPDATE sell  SET sell_status = '"+state+"' WHERE sell_id = "+sellId ;

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

	public void  delete(String sellId) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文
			String sql = "DELETE FROM sell WHERE sell_id ="+sellId ;

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
