package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import enity.NhaTro;

public class NhaTro_Dao {
	private List<NhaTro> dsNhaTro;

	public NhaTro_Dao() {
		
	}
	
	/**
	 * Load Danh Sách Nhà Trọ Lên Database
	 */
	public List<NhaTro> loadNhaTroFromDatabase() {
		dsNhaTro = new ArrayList<NhaTro>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaTro";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maTro = rs.getString(1);
				String diaChi = rs.getString(2);
				String chuNha = rs.getString(3);
				String soDT = rs.getString(4);

				NhaTro pt = new NhaTro(maTro, diaChi, chuNha, soDT);
				dsNhaTro.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhaTro;
	}
	
	/**
	 * Load mã trọ và địa chỉ trọ
	 */
	public List<NhaTro> loadDiaChiFormDatabase() {
		dsNhaTro = new ArrayList<NhaTro>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select maTro,diaChi from NhaTro";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maTro");
				String diaChi = rs.getString("diaChi");
				
				NhaTro pt = new NhaTro(ma,diaChi);
				dsNhaTro.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhaTro;
	}
	
	
	public List<NhaTro> getDsNhaTro() {
		return dsNhaTro;
	}
	
	/**
	 * Thêm 1 nhà trọ
	 * @param maTro, diaChi, chuNha, soDT
	 */
	public boolean them(String maTro , String diaChi, String chuNha, String soDT) {
		int n = 0;
		NhaTro nhaTro = new NhaTro( maTro, diaChi, chuNha, soDT);
		if (!dsNhaTro.contains(nhaTro)) {
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement st = null;
			try {
				st = con.prepareStatement("insert into NhaTro values(?, ?, ?, ?)");
				st.setString(1, maTro);
				st.setString(2, diaChi);
				st.setString(3, chuNha);
				st.setString(4, soDT);
				n = st.executeUpdate();
				
				dsNhaTro.add(nhaTro);
			} catch (SQLException e) {
				e.printStackTrace();				
			}
		}
		return n > 0;
	}
	
	/**
	 * Tạo 1 nhà trọ
	 * @param nt
	 */
	public boolean create(NhaTro nt) {

		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into NhaTro values(?,?,?,?)");
			stmt.setString(1, nt.getMaTro());
			stmt.setString(2, nt.getDiaChi());
			stmt.setString(3, nt.getChuTro());
			stmt.setString(4, nt.getSoDT());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	
	/**
	 * Xóa 1 nhà trọ
	 * @param maTro
	 * @throws SQLException 
	 */
	public boolean delete(String maTro) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "delete from NhaTro where maTro = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, maTro);
			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		con.close();
		return false;
	}
	
	/**
	 * Update 1 nhà trọ
	 * @return
	 */
	public boolean update(NhaTro nt, String maTro) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhaTro set diaChi=?,chuTro=?,soDT=? where maTro=? ");
			stmt.setString(1, nt.getDiaChi());
			stmt.setString(2, nt.getChuTro());
			stmt.setString(3, nt.getSoDT());
			stmt.setString(4, maTro);
			n = stmt.executeUpdate();
		} catch (SQLException e){
			// TODO: handle exception
			e.printStackTrace();
		}

		return n > 0;
	}
	
	
	public List<NhaTro> getNhaTroTheoMaTro(String mTro){
		dsNhaTro = new ArrayList<NhaTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaTro where maTro = '"+mTro+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maTro");
				String diaChi = rs.getString("diaChi");
				String chuTro = rs.getString("chuTro");
				String soDT = rs.getString("soDT");
				
				NhaTro pt = new NhaTro(ma,diaChi,chuTro,soDT);
				dsNhaTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhaTro;
	}
	
	public List<NhaTro> getNhaTroTheoDiaChi(String dChi){
		dsNhaTro = new ArrayList<NhaTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaTro where diaChi = '"+dChi+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maTro");
				String diaChi = rs.getString("diaChi");
				String chuTro = rs.getString("chuTro");
				String soDT = rs.getString("soDT");
		
				NhaTro pt = new NhaTro(ma,diaChi,chuTro,soDT);
				dsNhaTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhaTro;
	}
	
	public List<NhaTro> getNhaTroTheoChuTro(String cTro){
		dsNhaTro = new ArrayList<NhaTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaTro where chuTro = '"+cTro+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maTro");
				String diaChi = rs.getString("diaChi");
				String chuTro = rs.getString("chuTro");
				String soDT = rs.getString("soDT");
		
				NhaTro pt = new NhaTro(ma,diaChi,chuTro,soDT);
				dsNhaTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhaTro;
	}
	
	public List<NhaTro> getNhaTroTheoSoDT(String sDT){
		dsNhaTro = new ArrayList<NhaTro>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "Select * from NhaTro where soDT = '"+sDT+"'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String ma = rs.getString("maTro");
				String diaChi = rs.getString("diaChi");
				String chuTro = rs.getString("chuTro");
				String soDT = rs.getString("soDT");
		
				NhaTro pt = new NhaTro(ma,diaChi,chuTro,soDT);
				dsNhaTro.add(pt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNhaTro;
	}
}
