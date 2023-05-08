package ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.HopDong_Dao;
import dao.dichVu_dao;
import dao.hoaDon_Dao;
import enity.DichVu;
import enity.HopDong;
import enity.PhongTro;
import enity.SinhVien;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTable;

public class pnHoaDon extends JPanel implements MouseListener{

	private JPanel pnInput;
	private JLabel lblMaHoaDon,lblMaHopDong,lblMaPhong,lblTenSV,lblNgayTao,lblTienPhong,lblTongTien,lblDien,lblNuoc,lblInternet,lblTienDV,lblGia;
	private JTextField txtMaHD,txtMaHopDong,txtmaPhong,txtTenSV,txtNgayTao,txtTienPhong,txtDien,txtNuoc,txtInterNet,txtTongTien,txtGia,txtDV;
	private JDateChooser ngaytao;
	private JPanel pnTitle;
	private JTextField txtTitle;
	private JPanel pnCN;
	private JPanel pnTK;
	private JButton btnAdd;
	private JButton btnupdate;
	private JButton btnXoa;
	private JButton btnreload;
	private JLabel lblTim;
	private JTextField txtTim;
	private JButton btntim;
	private JPanel pnDS;
	private JTable table,tableDV;
	private DefaultTableModel model,modelDV;
	private ImageIcon icon_add = new ImageIcon(getClass().getResource("addhd.png"));
	private ImageIcon icon_delete = new ImageIcon(getClass().getResource("delete.png"));
	private ImageIcon icon_update = new ImageIcon(getClass().getResource("updatehd.png"));
	private ImageIcon icon_clear = new ImageIcon(getClass().getResource("clear.png"));
	private ImageIcon icon_find = new ImageIcon(getClass().getResource("find.png"));
	private dichVu_dao dv_dao;
	private JComboBox<String> cbHD, cbMaSV,cbMaPhong;
	private hoaDon_Dao hd_dao;
	public pnHoaDon() {
		setLayout(null);
		dv_dao = new dichVu_dao();
		pnInput = new JPanel();
		pnInput.setBounds(10, 64, 324, 686);
		pnInput.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		add(pnInput);
		
		Box b = Box.createVerticalBox();
		b.setBounds(10, 21, 304, 397);

		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMaHoaDon = new JLabel("Mã Hóa đơn:"));
		b1.add(txtMaHD = new JTextField());
		b1.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(30));
		b.add(b1);
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblMaHopDong = new JLabel("Mã hợp đồng:"));
		b2.add(cbHD = new JComboBox<>());
		b2.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
//		Box b6 = Box.createHorizontalBox();
//		b6.add(Box.createHorizontalStrut(10));
//		b6.add(lblTenSV = new JLabel("Tên Sinh viên:"));
//		b6.add(cbMaSV = new JComboBox<>());
//		b6.add(Box.createHorizontalStrut(5));
//		b.add(Box.createVerticalStrut(5));
//		b.add(b6);

//		Box b3 = Box.createHorizontalBox();
//		b3.add(Box.createHorizontalStrut(10));
//		b3.add(lblMaPhong = new JLabel("Mã Phòng:"));
//		b3.add(cbMaPhong = new JComboBox<>());
//		b3.add(Box.createHorizontalStrut(5));
//		b.add(Box.createVerticalStrut(5));
//		b.add(b3);
		Box b4 = Box.createHorizontalBox();
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblNgayTao = new JLabel("Ngày lập:"));
		b4.add(ngaytao = new JDateChooser());
		ngaytao.setDateFormatString("dd-MM-yyyy");
		pnInput.setLayout(null);
		b4.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b4);

//		Box b5 = Box.createHorizontalBox();
//		b5.add(Box.createHorizontalStrut(10));
//		b5.add(lblTienPhong = new JLabel("Tiền phòng:"));
//		b5.add(txtTienPhong = new JTextField());
//		b5.add(Box.createHorizontalStrut(5));
//		b.add(Box.createVerticalStrut(5));
//		b.add(b5);
//		b.add(Box.createVerticalStrut(5));
//		
		Box b7 = Box.createHorizontalBox();
		b7.add(Box.createHorizontalStrut(10));
		b7.add(lblDien = new JLabel("Điện:"));
		b7.add(txtDien = new JTextField());
		
		b7.add(Box.createHorizontalStrut(5));
		b.add(b7);
		b.add(Box.createVerticalStrut(5));
		
		Box b8 = Box.createHorizontalBox();
		b8.add(Box.createHorizontalStrut(10));
		b8.add(lblNuoc = new JLabel("Nước:"));
		b8.add(txtNuoc = new JTextField());
		b8.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b8);
		b.add(Box.createVerticalStrut(5));
		
		Box b9 = Box.createHorizontalBox();
		b9.add(Box.createHorizontalStrut(10));
		b9.add(lblInternet = new JLabel("Internet:"));
		b9.add(txtInterNet = new JTextField());
		b9.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b9);
		b.add(Box.createVerticalStrut(5));
		
		Box b11 = Box.createHorizontalBox();
		b11.add(Box.createHorizontalStrut(10));
		b11.add(lblTienDV = new JLabel("Tiền dịch vụ:"));
		b11.add(txtDV = new JTextField());
		b11.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b11);
		b.add(Box.createVerticalStrut(5));
		
		Box b10 = Box.createHorizontalBox();
		b10.add(Box.createHorizontalStrut(10));
		b10.add(lblTongTien = new JLabel("Tổng tiền:"));
		b10.add(Box.createHorizontalStrut(5));
		b10.add(txtTongTien = new JTextField());
		b10.add(Box.createHorizontalStrut(5));
		b.add(Box.createVerticalStrut(5));
		b.add(b10);
		b.add(Box.createVerticalStrut(150));
//		lblMaHoaDon.setPreferredSize(lblTenSV.getPreferredSize());
//		lblMaHopDong.setPreferredSize(lblTenSV.getPreferredSize());
////		lblMaPhong.setPreferredSize(lblTenSV.getPreferredSize());
//		lblTienPhong.setPreferredSize(lblTenSV.getPreferredSize());
////		lblDien.setPreferredSize(lblTenSV.getPreferredSize());
////		lblNuoc.setPreferredSize(lblTenSV.getPreferredSize());
////		lblInternet.setPreferredSize(lblTenSV.getPreferredSize());
////		lblTienDV.setPreferredSize(lblTenSV.getPreferredSize());
//		lblTongTien.setPreferredSize(lblTenSV.getPreferredSize());

		pnInput.add(b);
		
		pnCN = new JPanel();
		pnCN.setBounds(10, 474, 304, 128);
		pnInput.add(pnCN);
		pnCN.setLayout(null);
		
		btnAdd = new JButton("Tạo ",icon_add);
		btnAdd.setBounds(25, 0, 110, 40);
		pnCN.add(btnAdd);
		
		btnupdate = new JButton("Cập nhập",icon_update);
		btnupdate.setBounds(173, 0, 121, 40);
		pnCN.add(btnupdate);
		
		btnXoa = new JButton("Xóa",icon_delete);
		btnXoa.setBounds(25, 63, 110, 40);
		pnCN.add(btnXoa);
		
		btnreload = new JButton("Làm mới",icon_clear);
		btnreload.setBounds(173, 63, 121, 40);
		pnCN.add(btnreload);
		
		pnTitle = new JPanel();
		pnTitle.setBounds(10, 11, 333, 42);
		add(pnTitle);
		pnTitle.setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setForeground(new Color(255, 0, 0));
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setText("Hóa Đơn");
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setBounds(0, 0, 323, 42);
		pnTitle.add(txtTitle);
		txtTitle.setColumns(10);
		
		pnTK = new JPanel();
		pnTK.setBounds(608, 8, 368, 45);
		add(pnTK);
		pnTK.setLayout(null);
		
		lblTim = new JLabel("Tìm Hóa Đơn:");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTim.setBounds(10, 0, 104, 45);
		pnTK.add(lblTim);
		
		txtTim = new JTextField();
		txtTim.setBounds(111, 7, 154, 27);
		pnTK.add(txtTim);
		txtTim.setColumns(10);
		
		btntim = new JButton("Tìm",icon_find);
		btntim.setBounds(275, 7, 89, 29);
		pnTK.add(btntim);
		
		pnDS = new JPanel();
		pnDS.setBorder(new TitledBorder(new TitledBorder(null, "Danh Sách", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE)));
		pnDS.setBounds(335, 63, 751, 518);
		add(pnDS);
		pnDS.setLayout(null);
		
		String[] headers = "Mã hóa đơn;Mã hợp đồng;Tên sinh viên;Mã phòng;Ngày lập;Tiền phòng;Điện;Nước;Internet;Dịch Vụ;Tổng tiền".split(";");
		model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		table.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		table.setFont(new Font("", 0, 15));
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(10, 25, 720, 482);
		pnDS.add(scroll);
		
		JPanel pnDichVu = new JPanel();
		pnDichVu.setBounds(374, 581, 615, 169);
		add(pnDichVu);
		pnDichVu.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));
		pnDichVu.setLayout(null);
		

		String[] cl = "Tên dịch vụ;Tiền".split(";");
		modelDV = new DefaultTableModel(cl, 0);
		tableDV= new JTable(modelDV);
		tableDV.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tableDV.setFont(new Font("", 0, 15));
		JScrollPane scroll2 = new JScrollPane(tableDV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBounds(10, 27, 598, 131);
		pnDichVu.add(scroll2);
		
		tableDV.addMouseListener(this);
		docDLDV();
//		DocMaSVVaoCombobox();
		DocMHDaoCombobox();
//		DocPhongvaoCombobox();
		cbHD.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            loadGiaPhong();
		        }
		    }
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableDV.getSelectedRow();
		if (row == 0) {
			txtDien.setText(modelDV.getValueAt(row, 1).toString());
		}
		else if( row ==1) {
			txtNuoc.setText(modelDV.getValueAt(row, 1).toString());
		}
		else if( row ==2) {
			txtInterNet.setText(modelDV.getValueAt(row, 1).toString());
		}
		else if( row ==3) {
			txtDV.setText(modelDV.getValueAt(row, 1).toString());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void docDLDV()
	{
			ArrayList<DichVu> list = dv_dao.getVaoTBDV();
			modelDV.setRowCount(0);
			for (DichVu dv : list) {
				modelDV.addRow(new Object[] {dv.getTenDV(),dv.getGiaDV()});
			}
			cbHD.getSelectedIndex();
	}
	
	public void DocMHDaoCombobox() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM HopDong WHERE maHD NOT IN (SELECT maHD FROM HoaDon)";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				this.cbHD.addItem(rs.getString("maHD"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void loadGiaPhong() {
	    // Lấy mã hóa đơn từ combobox
	    String maHD =  cbHD.getSelectedItem().toString();
	    // Nếu mã hóa đơn không được chọn, không làm gì cả
	    if (maHD == null || maHD.isEmpty()) {
	        return;
	    }
	    try {
	        // Tạo kết nối đến cơ sở dữ liệu
	    	Connection con=ConnectDB.getInstance().getConnection();
	        
	       
	        String sql = "select HopDong.giaThue from HopDong\r\n"
	        		+ "inner join PhongTro on HopDong.maPhong =PhongTro.maPhong  \r\n"
	        		+ "where HopDong.maHD = ?\r\n"
	        		+ "group by HopDong.giaThue;";

	        PreparedStatement stmt = con.prepareStatement(sql);

	        stmt.setString(1, maHD);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            // Nếu có kết quả, lấy giá phòng và hiển thị trên txtGiaPhong
	            Double giaPhong = rs.getDouble("giaThue");
	            HopDong ht = new HopDong();
	            txtTienPhong.setText(String.valueOf(giaPhong));
	        } else {
	            // Nếu không có kết quả, đặt giá trị trống cho txtGiaPhong
	            txtGia.setText("");
	        }
	        
	        // Đóng kết nối và các đối tượng liên quan
	        rs.close();
	        stmt.close();
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
