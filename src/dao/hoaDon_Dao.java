package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import enity.DichVu;
import enity.HopDong;
import enity.PhongTro;
import enity.SinhVien;
import enity.hoaDon;

public class hoaDon_Dao {

	public hoaDon_Dao() {
		
	}
	
	public ArrayList<DichVu> getVaoTBDV(){
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select tenDV,giaDV from DichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				Float tiendv = rs.getFloat(2);
				DichVu dv = new DichVu(maHD, tiendv);
				dsdv.add(dv);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	}
}
//	}
//	
//	public ArrayList<HopDong> TimKiemMaHD(String ma){
//		ArrayList<HopDong> dshd = new ArrayList<HopDong>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement statement = null;
//		try {
//			
//			String sql = "select HopDong.giaThue from HopDong\r\n"
//					+ "inner join PhongTro on HopDong.maPhong =PhongTro.maPhong  \r\n"
//					+ "where HopDong.maHD = '"+ma+"'\r\n"
//					+ "group by HopDong.giaThue";
//			statement = con.prepareStatement(sql);
//			statement.setString(1, ma);
//			ResultSet rs =statement.executeQuery();
//			while (rs.next()) {
//				Double gia = rs.getDouble("giaThue")
//				dshd.add(pt);
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dshd;
//	}
//	

