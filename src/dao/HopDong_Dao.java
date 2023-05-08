package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import enity.HopDong;
import enity.LoaiPhong;
import enity.PhongTro;
import enity.SinhVien;

public class HopDong_Dao {
	public HopDong_Dao() {
		
	}
	
	public ArrayList<HopDong> getAllHD(){
		ArrayList<HopDong> dshd = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HopDong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				SinhVien maSV = new SinhVien(rs.getString(2));
				PhongTro maPhong = new PhongTro(rs.getString(3));
				Double giaPhong = rs.getDouble("giaThue");
				Date ngayLapHD = rs.getDate("ngayLap");
				Date ngayHetHD = rs.getDate("ngayHetHD");		
				HopDong hd = new HopDong(maHD, maSV,maPhong, giaPhong, ngayLapHD, ngayHetHD);
				dshd.add(hd);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
	
	public ArrayList<HopDong> TimKiemMaHD(String ma){
		ArrayList<HopDong> dshd = new ArrayList<HopDong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			
			String sql = "Select * from HopDong where maHD =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs =statement.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString(1);
				SinhVien maSV = new SinhVien(rs.getString(2));
				PhongTro maPhong = new PhongTro(rs.getString(3));
				Double giaPhong = rs.getDouble("giaThue");
				Date ngayLapHD = rs.getDate("ngayLap");
				Date ngayHetHD = rs.getDate("ngayHetHD");		
				HopDong hd = new HopDong(maHD, maSV,maPhong, giaPhong, ngayLapHD, ngayHetHD);
				dshd.add(hd);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
	
	
	public ArrayList<HopDong> getCTDHHD(){
		ArrayList<HopDong> dshd = new ArrayList<HopDong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql ="select HopDong.maHD,SinhVien.maSV,SinhVien.tenSV,SinhVien.lop,SinhVien.nganh,PhongTro.maPhong,PhongTro.tenPhong,PhongTro.loaiPhong,PhongTro.giaThue, HopDong.ngayLap,HopDong.ngayHetHD\r\n"
					+ "from HopDong \r\n"
					+ "inner join SinhVien on HopDong.maSV = SinhVien.maSV \r\n"
					+ "inner join PhongTro on HopDong.maPhong = PhongTro.maPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maSV = rs.getString(2);
				String tenSV = rs.getString(3);
				String lopsv = rs.getString(4);
				String nganhsv = rs.getString(5);
				String maPhong = rs.getString(6);
				String tenPhong = rs.getString(7);
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString(8));
				Double giaPhong = rs.getDouble("giaThue");
				Date ngayLapHD = rs.getDate("ngayLap");
				Date ngayHetHD = rs.getDate("ngayHetHD");		
				
				SinhVien ma = new SinhVien();
				ma.setMaSV(maSV);
				SinhVien ten = new SinhVien();
				ten.setTenSV(tenSV);
				SinhVien lop = new SinhVien();
				lop.setLop(lopsv);
				SinhVien nganh = new SinhVien();
				nganh.setNganh(nganhsv);
				PhongTro pt1  = new PhongTro();
				pt1.setMaPhong(maPhong);
				PhongTro pt2  = new PhongTro();
				pt2.setTenPhong(tenPhong);
				PhongTro pt3  = new PhongTro();
				pt3.setLoaiPhong(loaiPhong);
				HopDong hd = new HopDong(maHD, ma, ten, lop, nganh, pt1, pt2,pt3, giaPhong, ngayLapHD, ngayHetHD);
				dshd.add(hd);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}
	
	
	public boolean create(HopDong hd)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HopDong values(?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHopDong());
			stmt.setString(2, hd.getMaSV().getMaSV());
			stmt.setString(3, hd.getMaPhong().getMaPhong());
			stmt.setDouble(4, hd.getGiaPhong());
			stmt.setDate(5, hd.getNgayLap());
			stmt.setDate(6, hd.getNgayHetHD());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean delete(String ma)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HopDong where maHD = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n  > 0;
	}
	
	public boolean update(HopDong hd,String ma)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update HopDong  set maSV= ?, maPhong=?, giaThue=?, ngayLap=?, ngayHetHD=? where maHD=?");
			stmt.setString(1, hd.getMaSV().getMaSV());
			stmt.setString(2, hd.getMaPhong().getMaPhong());
			stmt.setDouble(3, hd.getGiaPhong());
			stmt.setDate(4, hd.getNgayLap());
			stmt.setDate(5,	hd.getNgayHetHD());
			stmt.setString(6, ma);
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n>0;
	}
}