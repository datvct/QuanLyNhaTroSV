package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import enity.SinhVien;


public class sinhVien_Dao {

	public sinhVien_Dao() {

	}
	private ArrayList<SinhVien> list;
	
	public  ArrayList<SinhVien> getAllSinhVien(){
	ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
	try
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "Select * from SinhVien";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String maSV = rs.getString(1);
			String tenNV = rs.getString(2);
			boolean gioiTinh = rs.getBoolean(3);
			String lop = rs.getString(4);
			String nganh = rs.getString(5);
			String quequan = rs.getString(6);
			String sdt = rs.getString(7);
			String email = rs.getString(8);

			SinhVien sv = new SinhVien(maSV, tenNV, gioiTinh, lop, nganh, quequan, sdt, email);
			dssv.add(sv);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return dssv;
	}
	
	public  ArrayList<SinhVien> getSVUpdate(){
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SinhVien";
			statement = con.prepareStatement(sql);
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				String maSV = rs.getString(1);
				String tensv = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String lop = rs.getString(4);
				String nganh = rs.getString(5);
				String quequan = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
							
				SinhVien sv = new SinhVien(maSV, tensv, gioiTinh, lop, nganh, quequan, sdt, email);
				dssv.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dssv;
	}
	
	
	public boolean create(SinhVien sv)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into SinhVien values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, sv.getMaSV());
			stmt.setString(2, sv.getTenSV());
			stmt.setBoolean(3, sv.getGT()? true:false);
			stmt.setString(4, sv.getLop());
			stmt.setString(5, sv.getNganh());
			stmt.setString(6, sv.getQuequan());
			stmt.setString(7, sv.getSdt());
			stmt.setString(8, sv.getEmail());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean update(SinhVien sv,String ma)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update SinhVien  set tenSV= ?, gioiTinh=?, lop=?, nganh=?, quequan=?, sdt=?, email=? where maSV=?");
			stmt.setString(1, sv.getTenSV());
			stmt.setBoolean(2, sv.getGT()? true:false);
			stmt.setString(3, sv.getLop());
			stmt.setString(4, sv.getNganh());
			stmt.setString(5, sv.getQuequan());
			stmt.setString(6, sv.getSdt());
			stmt.setString(7, sv.getEmail());
			stmt.setString(8, ma);
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n>0;
	}
	
	public boolean xoaSinhVien(String ma)
	{
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from SinhVien where maSV = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n  > 0;
	}
	
	
	public ArrayList<SinhVien> getSinhVienTheoMaSV(String mSV) {
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SinhVien where maSV = ? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, mSV);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString(1);
				String tenSV = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String lop = rs.getString(4);
				String nganh = rs.getString(5);
				String quequan = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				
				SinhVien s = new SinhVien(maSV, tenSV, gioiTinh, lop, nganh, quequan, sdt, email);
				dssv.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dssv;
	}
	
	
	public ArrayList<SinhVien> getSinhVienTheoTenSV(String tSV) {
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SinhVien where tenSV = ? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, tSV);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString(1);
				String tenSV = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String lop = rs.getString(4);
				String nganh = rs.getString(5);
				String quequan = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				
				SinhVien s = new SinhVien(maSV, tenSV, gioiTinh, lop, nganh, quequan, sdt, email);
				dssv.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dssv;
	}
	public ArrayList<SinhVien> getSinhVienTheolopSV(String SV) {
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SinhVien where lop = ? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, SV);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString(1);
				String tenSV = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String lop = rs.getString(4);
				String nganh = rs.getString(5);
				String quequan = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				
				SinhVien s = new SinhVien(maSV, tenSV, gioiTinh, lop, nganh, quequan, sdt, email);
				dssv.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dssv;
	}
	
	
	public ArrayList<SinhVien> getLietKe(String SV) {
		ArrayList<SinhVien> dssv = new ArrayList<SinhVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from SinhVien where nganh = ? ";
			statement = con.prepareStatement(sql);
			statement.setString(1, SV);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString(1);
				String tenSV = rs.getString(2);
				boolean gioiTinh = rs.getBoolean(3);
				String lop = rs.getString(4);
				String nganh = rs.getString(5);
				String quequan = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				
				SinhVien s = new SinhVien(maSV, tenSV, gioiTinh, lop, nganh, quequan, sdt, email);
				dssv.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dssv;
	}
}
	
