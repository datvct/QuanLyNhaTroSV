package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import enity.DangNhap;


public class dangNhap_dao implements Serializable {
			
		private static final long serialVersionUID = 1L;
		//taoTK khi themNV
		public boolean createTK(DangNhap tk) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "insert into TaiKhoan values (?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, tk.getMaTK());
				ps.setString(2, tk.getMatKhau());
				
				return ps.executeUpdate() > 0;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			con.close();
			return false;
		}
		
		public boolean suaTK(DangNhap tk) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement stmt = null;
			int n=0;
			try {
				stmt = con.prepareStatement("update taiKhoan set matKhau = ? where tenTaiKhoan = ?");
				stmt.setString(2, tk.getMaTK());
				stmt.setString(1, tk.getMatKhau());
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
		
		//Load ds TK
		public ArrayList<DangNhap> getDanhSachTK(){
			ArrayList<DangNhap> lstTK=new ArrayList<DangNhap>();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement("select * from taiKhoan");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					DangNhap tk=new DangNhap();
					tk.setMaTK(rs.getString(1));
					tk.setMatKhau(rs.getString(2));
					lstTK.add(tk);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lstTK;
		}



		public DangNhap getTaiKhoanTheoMa(String maTK) { 
			DangNhap tk = new DangNhap();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from taiKhoan where tenTaiKhoan = '"+maTK+"'";
			
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					tk.setMaTK(rs.getString(1));
					tk.setMatKhau(rs.getString(2));
					
				}
			}
			catch (SQLException e) {
					e.printStackTrace();
				}
				
				return tk;
			
		}
		
		//Load ds matkhau
		public DangNhap getMatKhauTheoMaNV(String ma) {
			DangNhap tk=new DangNhap();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from taiKhoan where tenTaiKhoan = '"+ma+"'"; 
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					tk.setMaTK(rs.getString(1));
					tk.setMatKhau(rs.getString(2));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return tk;
		}
				
	}

