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

public class dichVu_dao {

	public dichVu_dao() {

	}

	public ArrayList<DichVu> loadDLVaoPnDV() {
		ArrayList<DichVu> dscthd = new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maDV,tenDV,tienDV from ChiTietHD";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDV = rs.getString("maDV");
				String tenDV = rs.getString("tenDV");
				float tienDV = rs.getFloat("tienDV");

				DichVu ct = new DichVu(maDV,tenDV, tienDV);
				dscthd.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dscthd;
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

//	public boolean create(CT_HD cthd)
//	{
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		int n = 0;
//		try {
//			stmt = con.prepareStatement("insert into chiTietHD values(?,?,?,?,?)");
//			stmt.setString(1, hd.getMaHopDong());
//			stmt.setString(2, hd.getMaSV().getMaSV());
//			stmt.setString(3, hd.getMaPhong().getMaPhong());
//			stmt.setDouble(4, hd.getGiaPhong());
//			stmt.setDate(5, hd.getNgayLap());
//			stmt.setDate(6, hd.getNgayHetHD());
//			n = stmt.executeUpdate();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n > 0;
//	}
	
}
