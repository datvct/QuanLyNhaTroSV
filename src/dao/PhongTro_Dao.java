package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import enity.LoaiPhong;
import enity.NhaTro;
import enity.PhongTro;


public class PhongTro_Dao {
	private List<PhongTro> dsPhongTro;
	
	public PhongTro_Dao() {
	
	}
	
	public List<PhongTro> loadPhongTroFromDatabase() {
		dsPhongTro = new ArrayList<PhongTro>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhongTro";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString(1);
				String tenPhong = rs.getString(2);
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(3));
				Double giaThue = rs.getDouble(4);
				String dienTich = rs.getString(5);
				String tinhTrang = rs.getString(6);
				NhaTro maTro = new NhaTro(rs.getString(7));
				PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, maTro);
				dsPhongTro.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	public List<PhongTro> loadQuaHD() {		
		dsPhongTro = new ArrayList<PhongTro>();
	
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maPhong,tenPhong,giaThue,tinhTrang from PhongTro";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				double tienPhong = rs.getDouble("giaThue");
				String tinhTrang = rs.getString("tinhTrang");
				PhongTro pt = new PhongTro(maPhong, tenPhong, tienPhong, tinhTrang);
				dsPhongTro.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	public List<PhongTro> locQaHD() {		
		dsPhongTro = new ArrayList<PhongTro>();
	
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from PhongTro where tinhTrang = N'Phòng Trống'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				double tienPhong = rs.getDouble("giaThue");
				String tinhTrang = rs.getString("tinhTrang");
				PhongTro pt = new PhongTro(maPhong, tenPhong, tienPhong, tinhTrang);
				dsPhongTro.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	
	public List<PhongTro> getDSPhongTro() {
		return dsPhongTro;
	}
	
	public boolean them(PhongTro p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into Phong values (?,?,?,?,?,?,?)");
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getTenPhong());
			stmt.setString(3, p.getLoaiPhong().getLoaiPhong());
			stmt.setDouble(4, p.getGiaThue());
			stmt.setString(5, p.getDienTich());
			stmt.setString(6, p.getTinhTrang());
			stmt.setString(7, p.getMTro().getMaTro());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n>0;
	}
	
	public boolean create(PhongTro p) {

		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into PhongTro values(?,?,?,?,?,?,?)");
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getTenPhong());
			stmt.setString(3, p.getLoaiPhong().getLoaiPhong());
			stmt.setDouble(4, p.getGiaThue());
			stmt.setString(5, p.getDienTich());
			stmt.setString(6, p.getTinhTrang());
			stmt.setString(7, p.getMTro().getMaTro());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
	
	public boolean delete(String maPhong) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "delete from PhongTro where maPhong = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maPhong);
			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		con.close();
		return false;
	}
	
	public boolean capNhatTrangThaiPhong(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "update PhongTro set tinhTrang = N'Phòng Có Người' where maPhong = '"+ma+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(PhongTro pt, String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update PhongTro set tenPhong=?,loaiPhong=?,giaThue=?,dienTich=?,tinhTrang=?,maTro=? where maPhong=? ");
			stmt.setString(1, pt.getTenPhong());
			stmt.setString(2, pt.getLoaiPhong().getLoaiPhong());
			stmt.setDouble(3, pt.getGiaThue());
			stmt.setString(4, pt.getDienTich());
			stmt.setString(5, pt.getTinhTrang());
			stmt.setString(6, pt.getMTro().getMaTro());
			stmt.setString(7,  maPhong);
			n = stmt.executeUpdate();
		} catch (SQLException e){
			// TODO: handle exception
			e.printStackTrace();
		}

		return n > 0;
	}
	
	public List<PhongTro> getTheoMaPhong(String maP){
		dsPhongTro = new ArrayList<PhongTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from PhongTro where maPhong = '"+maP+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("loaiPhong"));
				Double giaThue = rs.getDouble("giaThue");
				String dienTich = rs.getString("dienTich");
				String tinhTrang = rs.getString("tinhTrang");
				NhaTro maTro = new NhaTro(rs.getString("maTro"));
				
				PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, maTro);
				dsPhongTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	
	public List<PhongTro> getTheoTenPhong(String tenP){
		dsPhongTro = new ArrayList<PhongTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from PhongTro where tenPhong = '"+tenP+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("loaiPhong"));
				Double giaThue = rs.getDouble("giaThue");
				String dienTich = rs.getString("dienTich");
				String tinhTrang = rs.getString("tinhTrang");
				NhaTro maTro = new NhaTro(rs.getString("maTro"));
				
				PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, maTro);
				dsPhongTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	
	public List<PhongTro> getLietKe(String maloaiPhong){
		dsPhongTro = new ArrayList<PhongTro>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select PhongTro.maPhong,PhongTro.tenPhong,PhongTro.loaiPhong,PhongTro.giaThue,PhongTro.dienTich,PhongTro.tinhTrang,PhongTro.maTro from PhongTro \r\n"
					+ "inner join LoaiPhong on LoaiPhong.loaiPhong = PhongTro.loaiPhong\r\n"
					+ "where PhongTro.loaiPhong =N'"+maloaiPhong + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("loaiPhong"));
				Double giaThue = rs.getDouble("giaThue");
				String dienTich = rs.getString("dienTich");
				String tinhTrang = rs.getString("tinhTrang");
				NhaTro maTro = new NhaTro(rs.getString("maTro"));
				
				PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, maTro);
				dsPhongTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsPhongTro;
	}
	
	
	
	
}
