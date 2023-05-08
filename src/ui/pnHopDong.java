package ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.HopDong_Dao;
import dao.PhongTro_Dao;
import enity.HopDong;
import enity.PhongTro;
import enity.SinhVien;
import enity.hoaDon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class pnHopDong extends JPanel implements ActionListener, MouseListener {

	private JPanel pnWest;
	private JLabel lblMaHD, lblMaSv, lblMaPhong, lblNgayLapHD, lblNgayKetThucHD, lblGiaPhong;
	private JTextField txtMaHD, txtMaSV, txtMaPhong, txtGiaPhong;
	private JDateChooser ngayTao, ngayHet;
	private JPanel pnPhongtro;
	private JTable table, table2;
	private DefaultTableModel model, model2;
	private JPanel pnLocDs;
	private JCheckBox chckLoc;
	private JButton btnLoc;
	private JPanel pndsHopDong;
	private JPanel pnButton;
	private JButton btnadd;
	private JButton btnCapnhap;
	private JButton btnXoa,btnTim;
	private JButton btnreset;
	private ImageIcon icon_add = new ImageIcon(getClass().getResource("addhd.png"));
	private ImageIcon icon_delete = new ImageIcon(getClass().getResource("delete.png"));
	private ImageIcon icon_update = new ImageIcon(getClass().getResource("updatehd.png"));
	private ImageIcon icon_clear = new ImageIcon(getClass().getResource("clear.png"));
	private ImageIcon icon_find = new ImageIcon(getClass().getResource("find.png"));
	private ImageIcon icon_loc = new ImageIcon(getClass().getResource("filter.png"));
	private JPanel panel;
	private JLabel lblTim;
	private JTextField txtTim;
	private PhongTro_Dao pt_dao;
	private HopDong_Dao hd_dao;
	private JComboBox<String> cbMaSV;
	private SimpleDateFormat dfNgay;
	private DecimalFormat dfGiaPhong;

	public pnHopDong() {
		setLayout(null);
		dfNgay = new SimpleDateFormat("dd/MM/yyyy");
		dfGiaPhong = new DecimalFormat("###,##0.00");
		pt_dao = new PhongTro_Dao();
		hd_dao = new HopDong_Dao();
		pnWest = new JPanel();
		pnWest.setBackground(new Color(227, 230, 230));
		pnWest.setBounds(24, 0, 519, 320);
		pnWest.setBorder(new TitledBorder(null, "Thông Tin Hợp Đồng", 0, 0, new Font("", Font.BOLD, 15), Color.BLUE));
		add(pnWest);

		Box b = Box.createVerticalBox();
		b.setBounds(30, 22, 453, 249);

		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaHD = new JLabel("Mã Hợp đồng:"));
		b1.add(txtMaHD = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b1);
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblMaSv = new JLabel("Mã Sinh Viên:"));
		b2.add(cbMaSV = new JComboBox<String>());

		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		Box b6 = Box.createHorizontalBox();
		b6.add(Box.createHorizontalStrut(20));
		b6.add(lblMaPhong = new JLabel("Mã Phòng:"));
		b6.add(txtMaPhong = new JTextField());
		b6.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b6);

		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblGiaPhong = new JLabel("Giá Phòng:"));
		b3.add(txtGiaPhong = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		Box b4 = Box.createHorizontalBox();
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblNgayLapHD = new JLabel("Ngày lập hóa đơn:"));
		b4.add(ngayTao = new JDateChooser());
		ngayTao.setDateFormatString("dd-MM-yyyy");
		b4.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		lblMaSv.setPreferredSize(lblMaHD.getPreferredSize());
		lblGiaPhong.setPreferredSize(lblMaHD.getPreferredSize());
		lblMaPhong.setPreferredSize(lblMaHD.getPreferredSize());

		Box b5 = Box.createHorizontalBox();
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblNgayKetThucHD = new JLabel("Ngày hết hợp đồng:"));
		b5.add(ngayHet = new JDateChooser());
		ngayHet.setDateFormatString("dd-MM-yyyy");
		b5.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(5));

		pnWest.setLayout(null);

		pnWest.add(b);

		pnButton = new JPanel();
		pnButton.setBounds(10, 269, 499, 40);
		pnWest.add(pnButton);
		pnButton.setLayout(null);

		btnadd = new JButton("Tạo HĐ", icon_add);
		btnadd.setBounds(0, 0, 105, 34);
		pnButton.add(btnadd);

		btnCapnhap = new JButton("Cập Nhập", icon_update);
		btnCapnhap.setBounds(124, 0, 120, 34);
		pnButton.add(btnCapnhap);

		btnXoa = new JButton("Xóa", icon_delete);
		btnXoa.setBounds(254, 0, 105, 34);
		pnButton.add(btnXoa);

		btnreset = new JButton("Làm mới", icon_clear);
		btnreset.setBounds(369, 0, 120, 34);
		pnButton.add(btnreset);

		pnPhongtro = new JPanel();
		pnPhongtro.setBounds(565, 0, 545, 320);
		add(pnPhongtro);
		pnPhongtro.setBorder(new TitledBorder(null, "Danh Sách Phòng", 0, 0, new Font("", Font.BOLD, 15), Color.BLUE));
		pnPhongtro.setLayout(null);

		String[] headers = "Mã Phòng;Tên Phòng;Giá Phòng;Trạng thái".split(";");
		model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		table.setFont(new Font("", 0, 15));
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(4, 23, 531, 250);
		pnPhongtro.add(scroll);

		pnLocDs = new JPanel();
		pnLocDs.setBounds(33, 284, 437, 25);
		pnPhongtro.add(pnLocDs);
		pnLocDs.setLayout(null);

		chckLoc = new JCheckBox("Lọc phòng trống");
		chckLoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckLoc.setBounds(6, 0, 188, 25);
		pnLocDs.add(chckLoc);

		btnLoc = new JButton("Lọc", icon_loc);
		btnLoc.setBounds(207, 2, 89, 23);
		pnLocDs.add(btnLoc);

		pndsHopDong = new JPanel();
		pndsHopDong.setBounds(10, 363, 1100, 389);
		pndsHopDong.setBorder(new TitledBorder(null, "Danh Sách Hợp Đồng", 0, 0, new Font("", Font.BOLD, 15), Color.BLUE));
		String[] colum = "Mã hợp đồng;Mã Sinh Viên;Mã phòng;Giá phòng;Ngày lập HĐ;Ngày Hết HĐ".split(";");
		model2 = new DefaultTableModel(colum, 0);
		pndsHopDong.setLayout(null);

		table2 = new JTable(model2);
		table2.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		table2.setFont(new Font("", 0, 15));
		JScrollPane sc = new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc.setBounds(10, 21, 1080, 357);
		pndsHopDong.add(sc);

		add(pndsHopDong);

		panel = new JPanel();
		panel.setBounds(10, 319, 527, 41);
		add(panel);
		panel.setLayout(null);

		lblTim = new JLabel("Tìm hợp đồng:");
		lblTim.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTim.setBounds(38, 0, 110, 41);
		panel.add(lblTim);

		txtTim = new JTextField();
		txtTim.setBounds(148, 12, 174, 20);
		panel.add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("Tìm", icon_find);
		btnTim.setBounds(332, 11, 89, 23);
		panel.add(btnTim);
		docDLvaoDsTro();

		btnadd.addActionListener(this);
		btnXoa.addActionListener(this);
		btnreset.addActionListener(this);
		btnCapnhap.addActionListener(this);
		table.addMouseListener(this);
		btnLoc.addActionListener(this);
		btnTim.addActionListener(this);
		table2.addMouseListener(this);
		DocDuLieuDatabaseVaoTable();
		DocMaSVVaoCombobox();
	}

	public void docDLvaoDsTro() {
		List<PhongTro> list = pt_dao.loadQuaHD();
		model.setRowCount(0);
		for (PhongTro pt : list) {
			model.addRow(new Object[] { pt.getMaPhong(), pt.getTenPhong(), pt.getGiaThue(), pt.getTinhTrang() });
		}
	}

	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<HopDong> list = hd_dao.getAllHD();
		model2.setRowCount(0);
		for (HopDong hd : list) {
			model2.addRow(new Object[] { hd.getMaHopDong(), hd.getMaSV().getMaSV(), hd.getMaPhong().getMaPhong(),
					hd.getGiaPhong(), dfNgay.format(hd.getNgayLap()), dfNgay.format(hd.getNgayHetHD()) });
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtMaPhong.setText(model.getValueAt(row, 0).toString());
			txtGiaPhong.setText(model.getValueAt(row, 2).toString());
			String tinhTrang = model.getValueAt(row, 3).toString();
		}
		int r = table2.getSelectedRow();

		if (r >= 0) {
			txtMaHD.setEditable(false);
			String maHD = (String) model2.getValueAt(r, 0);
			ArrayList<HopDong> list = hd_dao.getAllHD();
			for (HopDong hd : list) {
				if (maHD.equals(hd.getMaHopDong())) {
					txtMaHD.setText(maHD);
					txtMaPhong.setText(model2.getValueAt(r, 2).toString());
					txtGiaPhong.setText(model2.getValueAt(r, 3).toString());
					ngayTao.setDate(hd.getNgayLap());
					ngayHet.setDate(hd.getNgayHetHD());
				}

			}
			txtGiaPhong.setEditable(false);
			cbMaSV.setSelectedItem(model2.getValueAt(r, 1).toString());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnadd)) {
			if (txtMaHD.getText().equals("") || txtGiaPhong.getText().equals("") || txtMaPhong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			} else {
				if(validData()) {
					String ma = txtMaHD.getText();
					String maSV = cbMaSV.getSelectedItem().toString();
					PhongTro maPhong = new PhongTro(txtMaPhong.getText());
					Double giaPhong = Double.parseDouble(txtGiaPhong.getText());
					java.util.Date ngayLapHD = ngayTao.getDate();
					Date ngayLap = new Date(ngayLapHD.getYear(), ngayLapHD.getMonth(), ngayLapHD.getDate());
	
					java.util.Date ngayHetHD = ngayHet.getDate();
					Date ngayHet = new Date(ngayHetHD.getYear(), ngayHetHD.getMonth(), ngayHetHD.getDate());
	
					SinhVien masv = new SinhVien(maSV);
					HopDong hd = new HopDong(ma, masv, maPhong, giaPhong, ngayLap, ngayHet);
					
					try {
						int row = table.getSelectedRow();
						if (row >= 0) {
							String tinhTrang = model.getValueAt(row, 3).toString();
							if (tinhTrang.equals("Phòng Có Người")) {
								JOptionPane.showMessageDialog(this, "Phòng đã có người ở, Vui lòng chọn phòng khác!");
							} else {
								try {
									hd_dao.create(hd);
									model2.addRow(new Object[] { hd.getMaHopDong(), hd.getMaSV().getMaSV(),
											hd.getMaPhong().getMaPhong(), hd.getGiaPhong(), dfNgay.format(ngayLap),
											dfNgay.format(ngayHet) });
									pt_dao.capNhatTrangThaiPhong(txtMaPhong.getText());
									docDLvaoDsTro();
									chckLoc.setSelected(false);
									JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công!");
								}
								catch (Exception e2) {
									JOptionPane.showMessageDialog(this, "Trùng mã hợp đồng vui lòng nhập lại!");
									txtMaHD.selectAll();
									txtMaHD.requestFocus();
								}
								
						}
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Trùng mã");
					}
				}
			}

		}
		if (o.equals(btnXoa)) {
			
			int r = table2.getSelectedRow();
			if(r != -1) {
				String maHD = model2.getValueAt(r, 0).toString();
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
				if(hoi == JOptionPane.YES_OPTION) {
					try {
						hd_dao.delete(maHD);
						model2.removeRow(r);
						cbMaSV.setSelectedIndex(0);
						txtMaHD.setText("");
						txtMaHD.requestFocus();
						txtMaPhong.setText("");
						txtGiaPhong.setText("");
						ngayHet.setDate(null);
						ngayTao.setDate(null);
						DocDuLieuDatabaseVaoTable();
						docDLvaoDsTro();
						JOptionPane.showMessageDialog(this, "Xóa thành công!");
					}catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
			}
		}
		if (o.equals(btnreset)) {
			cbMaSV.setSelectedIndex(0);
			txtMaHD.setText("");
			txtMaHD.requestFocus();
			txtMaPhong.setText("");
			txtGiaPhong.setText("");
			ngayHet.setDate(null);
			ngayTao.setDate(null);
			DocDuLieuDatabaseVaoTable();
			docDLvaoDsTro();
			DocMaSVVaoCombobox();
		}

		if (o.equals(btnCapnhap)) {
			
			if (txtMaHD.getText().equals("") || txtGiaPhong.getText().equals("") || txtMaPhong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
			
			}	
			
			else {
				if(validData()) {
					int r = table2.getSelectedRow();

					if (r >= 0) {
						txtMaHD.setEditable(false);
						String maHD = txtMaHD.getText();
						String maPhong = txtMaPhong.getText();
						String masv = cbMaSV.getSelectedItem().toString();
						Double gia = Double.parseDouble(txtGiaPhong.getText());
						java.util.Date ngayLapHD = ngayTao.getDate();
						Date ngayLap = new Date(ngayLapHD.getYear(), ngayLapHD.getMonth(), ngayLapHD.getDate());

						java.util.Date ngayHetHD = ngayHet.getDate();
						Date ngayHet = new Date(ngayHetHD.getYear(), ngayHetHD.getMonth(), ngayHetHD.getDate());

						SinhVien sv = new SinhVien(masv);
						PhongTro pt = new PhongTro(maPhong);

						HopDong hd = new HopDong();
						hd.setNgayHetHD(ngayHet);
						hd.setNgayLap(ngayLap);
						hd.setMaSV(sv);
						hd.setGiaPhong(gia);
						hd.setMaPhong(pt);
						try {
							hd_dao.update(hd, maHD);
							DocDuLieuDatabaseVaoTable();
							JOptionPane.showMessageDialog(this, "Thông tin hợp đồng đã được sửa!", "Thông báo",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e2) {
							e2.printStackTrace();
							JOptionPane.showMessageDialog(this, "Cập nhập thông tin hợp đồng không thành công");
						}
					}
				}
			}
		}
		if (o.equals(btnLoc)) {
			if (chckLoc.isSelected()) {
				LocDLVaoTable();
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng click chọn vào Lọc phòng trống!");
			}
		}
		if (o.equals(btnTim)) {
			if(txtTim.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm kiếm!");
				txtTim.requestFocus();
			}
			
			else {
				timKiemMaHDvaoTable();
				JOptionPane.showMessageDialog(this, "Tìm mã hóa đơn thành công!");
			}
		}
	}

	
	private boolean validData() {
		String ma = txtMaHD.getText().trim();
		if(!(ma.length()>0 && ma.matches("(HD)\\d{2,3}"))) {
			JOptionPane.showMessageDialog(this, "Error: Mã phải theo mẫu HD + 2 số");
			txtMaHD.selectAll();
			txtMaHD.requestFocus();
			return false;
		}
		return true;
	}
	
	public void DocMaSVVaoCombobox() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM SinhVien WHERE maSV NOT IN (SELECT maSV FROM HopDong)";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				this.cbMaSV.addItem(rs.getString("maSV"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void LocDLVaoTable() {
		List<PhongTro> list = pt_dao.locQaHD();
		model.setRowCount(0);
		for (PhongTro pt : list) {
			model.addRow(new Object[] { pt.getMaPhong(), pt.getTenPhong(), pt.getGiaThue(), pt.getTinhTrang() });
		}
	}
	
	public void timKiemMaHDvaoTable() {
		String ma = txtTim.getText();
		ArrayList<HopDong> list = hd_dao.TimKiemMaHD(ma);
		model2.setRowCount(0);
		for (HopDong hd : list) {
			model2.addRow(new Object[] { hd.getMaHopDong(), hd.getMaSV().getMaSV(),
					hd.getMaPhong().getMaPhong(), hd.getGiaPhong(), dfNgay.format(hd.getNgayLap()),
					dfNgay.format(hd.getNgayHetHD()) });
		}
	}
}
