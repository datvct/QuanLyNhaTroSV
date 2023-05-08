package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import dao.sinhVien_Dao;
import enity.SinhVien;
import giaoDien.Button;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.Color;

public class pnSinhVien extends JPanel implements ActionListener,MouseListener {
	private JTable tableSinhVien;
	private DefaultTableModel modelSinhVien;
	private JTextField txtMaSV,txtTenSV,txtLop,txtNganh,txtQueQuan,txtSDT,txtEmail,txtTim, txtMess;
	private JButton btnThem,btnXoa,btnLamMoi,btnCapNhap,btnTim, btnLuu, btnSua;
	private JRadioButton rbtnam,rbtnu;
	private JRadioButton rdbTimMa,rdbTimTen,rdbTimQue,rdbLop;
	private JLabel lblMaSV,lblTen,lblLop,lblNganh,lblQueQuan,lblSDT,lblEmail,lblTim,lblGioiTinh;
	private JComboBox<String> cbKhoa;
	private JPanel panel;
	private JTextField txtQunLSinh;
	private ImageIcon icon_add = new ImageIcon(getClass().getResource("add.png"));
	private ImageIcon icon_delete = new ImageIcon(getClass().getResource("delete.png"));
	private ImageIcon icon_update = new ImageIcon(getClass().getResource("updatehd.png"));
//	private ImageIcon icon_clear = new ImageIcon(getClass().getResource("clear.png"));

	private sinhVien_Dao sv_dao;
	
	
	public pnSinhVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sv_dao = new sinhVien_Dao();
		
		setLayout(null);
		
		JPanel pnSinhVien = new JPanel();
		pnSinhVien.setBounds(0, 0, 1108, 767);
		add(pnSinhVien);
		
		Font ft = new Font("", Font.BOLD, 14);
		JPanel pnMain = new JPanel();
		pnMain.setBounds(156, 110, 850, 250);
		pnMain.setPreferredSize(new Dimension(850,250));
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		
		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblMaSV = new JLabel("Mã Sinh Viên:"));
		lblMaSV.setFont(ft);
		b1.add(txtMaSV = new JTextField());
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b1);
		
		Box b2 = Box.createHorizontalBox();
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblTen = new JLabel("Tên Sinh Viên:"));
		lblTen.setFont(ft);
		b2.add(txtTenSV = new JTextField());
		b2.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		
		
		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblSDT = new JLabel("Số điện thoại:"));
		lblSDT.setFont(ft);
		b3.add(txtSDT = new JTextField());
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblQueQuan = new JLabel("Quê quán:"));
		lblQueQuan.setFont(ft);
		b3.add(txtQueQuan = new JTextField());		
		b3.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		
		lblGioiTinh = new JLabel("Giới tính:");

		rbtnam = new JRadioButton("Nam", false);
		rbtnam.setEnabled(true);
		rbtnu= new JRadioButton("Nữ", false);
		ButtonGroup group = new ButtonGroup();
		group.add(rbtnam);
		group.add(rbtnu);
		
		Box b4 = Box.createHorizontalBox();
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblEmail = new JLabel("Email:"));
		lblEmail.setFont(ft);
		b4.add(txtEmail = new JTextField());
		b4.add(Box.createHorizontalStrut(20));
		b4.add(lblGioiTinh);
		lblGioiTinh.setFont(ft);
		b4.add(rbtnam);
		b4.add(rbtnu);
		b4.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b4);
		
		Box b5 = Box.createHorizontalBox();
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblLop = new JLabel("Lớp:"));
		b5.add(txtLop = new JTextField());
		lblLop.setFont(ft);
		b5.add(Box.createHorizontalStrut(20));
		b5.add(lblNganh = new JLabel("Ngành:"));
		lblNganh.setFont(ft);
		b5.add(txtNganh =  new JTextField());		
		b5.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		lblSDT.setPreferredSize(new Dimension(120, 20));
		lblMaSV.setPreferredSize(lblSDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		lblLop.setPreferredSize(lblSDT.getPreferredSize());
		lblEmail.setPreferredSize(lblSDT.getPreferredSize());
		lblNganh.setPreferredSize(new Dimension(100, 20));
		lblTen.setPreferredSize(lblSDT.getPreferredSize());
		lblQueQuan.setPreferredSize(new Dimension(100, 20));
		pnMain.setBorder(new TitledBorder(null, "Thông Tin Nhân Viên", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
		pnMain.add(b);
		
		JPanel pButton = new JPanel();
		pButton.setBounds(81, 371, 980, 55);
		pButton.setBackground(Color.decode("#C0C0C0"));
		
		
	
		pButton.add(btnThem = Button.myButtonUI(new Dimension(120, 55), JButton.CENTER, "Thêm", 18, "#C0C0C0", "#29B6F6", "asset\\add.png"));
		pButton.add(Box.createHorizontalStrut(20));
		pButton.add(btnXoa = Button.myButtonUI(new Dimension(120, 55), JButton.CENTER, "Xóa", 18, "#C0C0C0", "#29B6F6", "asset\\delete.png"));
		pButton.add(Box.createHorizontalStrut(20));
		pButton.add(btnCapNhap = Button.myButtonUI(new Dimension(170, 55), JButton.CENTER, "Cập Nhập", 18, "#C0C0C0", "#29B6F6", "asset\\updatehd.png"));
		pButton.add(Box.createHorizontalStrut(20));
		pButton.add(btnLamMoi = Button.myButtonUI(new Dimension(170, 55), JButton.CENTER, "Làm mới", 18, "#C0C0C0", "#29B6F6", "asset\\clear.png"));


		JPanel pTable = new JPanel();
		String[] colHeader = {"Mã Sinh Viên", "Họ Tên", "Giới Tính", "Lớp", "Ngành", "Quê Quán", "Số Điện Thoại", "Email"};
		modelSinhVien = new DefaultTableModel(colHeader, 0);
		tableSinhVien = new JTable(modelSinhVien);
		tableSinhVien.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tableSinhVien.setFont(new Font("", 0, 15));
		tableSinhVien.setPreferredSize(new Dimension(1200,300));
		tableSinhVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableSinhVien.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableSinhVien.getColumnModel().getColumn(3).setPreferredWidth(55);
		tableSinhVien.getColumnModel().getColumn(4).setPreferredWidth(80);
		tableSinhVien.getColumnModel().getColumn(5).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(7).setPreferredWidth(170);
		pTable.add(tableSinhVien);
		pnSinhVien.setLayout(null);
		
		pnSinhVien.add(pButton);
		pnSinhVien.add(pnMain);
		JScrollPane scrollPane = new JScrollPane(tableSinhVien);
		scrollPane.setBounds(82, 427, 980, 329);
		pnSinhVien.add(scrollPane);
		
		panel = new JPanel();
		panel.setBounds(99, 24, 980, 60);
		pnSinhVien.add(panel);
		panel.setLayout(null);
		DocDuLieuDatabaseVaoTable();
		
		txtQunLSinh = new JTextField();
		txtQunLSinh.setForeground(new Color(255, 0, 0));
		txtQunLSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtQunLSinh.setText("Quản  Lí Sinh Viên");
		txtQunLSinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtQunLSinh.setBounds(64, 0, 850, 60);
		panel.add(txtQunLSinh);
		txtQunLSinh.setColumns(10);
		
		

		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhap.addActionListener(this);

		tableSinhVien.addMouseListener(this);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			
			if(txtMaSV.getText().equals("") || txtTenSV.getText().equals("") || txtLop.getText().equals("") || txtNganh.getText().equals("") || txtQueQuan.getText().equals("") || txtEmail.getText().equals("")|| txtSDT.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu!");
			}
			else {
				if(validData()) {	
					String ma = txtMaSV.getText();
					String ten = txtTenSV.getText();
					boolean phai = rbtnam.isSelected();
					String lop = txtLop.getText();
					String nganh = txtNganh.getText();
					String quequan = txtQueQuan.getText();
					String sdt = txtSDT.getText();
					String email = txtEmail.getText();
			
					SinhVien sv = new SinhVien(ma, ten, phai, lop, nganh, quequan, sdt, email);
			
					try {
						sv_dao.create(sv);
						JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
						txtMaSV.setText("");
						txtTenSV.setText("");
						rbtnam.setSelected(false);
						rbtnu.setSelected(false);
						txtQueQuan.setText("");
						txtLop.setText("");
						txtSDT.setText("");
						txtEmail.setText("");
						txtMaSV.requestFocus();
						DocDuLieuDatabaseVaoTable();
						txtMaSV.selectAll();
						txtMaSV.requestFocus();
					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Trùng mã");
						txtMaSV.selectAll();
						txtMaSV.requestFocus();
					}
			}
			
			}
		}
		if (o.equals(btnXoa)) {
			int r = tableSinhVien.getSelectedRow();
			if(r != -1) {
				String maSV = modelSinhVien.getValueAt(r, 0).toString();
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
				if(hoi == JOptionPane.YES_OPTION) {
					try {
						sv_dao.xoaSinhVien(maSV);
						modelSinhVien.removeRow(r);
						txtMaSV.setText("");
						txtTenSV.setText("");
						rbtnam.setSelected(false);
						rbtnu.setSelected(false);
						txtQueQuan.setText("");
						txtLop.setText("");
						txtSDT.setText("");
						txtEmail.setText("");
						txtMaSV.requestFocus();
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
		if (o.equals(btnLamMoi)) {
			txtMaSV.setText("");
			txtTenSV.setText("");
			rbtnam.setSelected(false);
			rbtnu.setSelected(false);
			txtQueQuan.setText("");
			txtLop.setText("");
			txtSDT.setText("");
			txtEmail.setText("");
			txtMaSV.requestFocus();
			DocDuLieuDatabaseVaoTable();
		}
		if (o.equals(btnTim)) {

		}
		if (o.equals(btnCapNhap)) {
			if(txtMaSV.getText().equals("") || txtTenSV.getText().equals("") || txtLop.getText().equals("") || txtNganh.getText().equals("") || txtQueQuan.getText().equals("") || txtEmail.getText().equals("")|| txtSDT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu!");
			}
			else {
				if(validData()) {
					int row = tableSinhVien.getSelectedRow();
					String ma = modelSinhVien.getValueAt(row, 0).toString();
					String ten = txtTenSV.getText();
					boolean phai = false;
					if(rbtnam.isSelected()) {
						phai= true;
					}
					else 
						phai =false;
					String lop = txtLop.getText();
					String nganh = txtLop.getText();
					String quequan = txtQueQuan.getText();
					String sdt = txtSDT.getText();
					String email = txtEmail.getText();
			
					SinhVien sv = new SinhVien(ma, ten, phai, lop, nganh, quequan, sdt, email);
					try {
						sv_dao.update(sv,ma);
						DocDuLieuDatabaseVaoTable();
						JOptionPane.showMessageDialog(this, "Thông tin nhân viên đã được sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
					
	}
	
	public void DocDuLieuDatabaseVaoTable() {
		List<SinhVien> list = sv_dao.getAllSinhVien();
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	public void updateDuLieuDatabaseVaoTable() {
		List<SinhVien> list = sv_dao.getSVUpdate();
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row = tableSinhVien.getSelectedRow();
		txtMaSV.setText(modelSinhVien.getValueAt(row, 0).toString());
		txtTenSV.setText(modelSinhVien.getValueAt(row, 1).toString());
		rbtnu.setSelected(modelSinhVien.getValueAt(row, 2).toString() == "Nữ" ? true : false);
		rbtnam.setSelected(modelSinhVien.getValueAt(row, 2).toString() == "Nam" ? true : false);

		txtLop.setText(modelSinhVien.getValueAt(row, 3).toString());
		txtNganh.setText(modelSinhVien.getValueAt(row, 4).toString());
		txtQueQuan.setText(modelSinhVien.getValueAt(row, 5).toString());
		txtSDT.setText(modelSinhVien.getValueAt(row, 6).toString());
		txtEmail.setText(modelSinhVien.getValueAt(row, 7).toString());
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
	
	private boolean validData() {
		String maSV = txtMaSV.getText().trim();
		String tenSV = txtTenSV.getText();
		String SDT = txtSDT.getText().trim();
		String Que = txtQueQuan.getText().trim();
		String lop = txtLop.getText().trim();
		String Email = txtEmail.getText().trim();
		String nganh = txtNganh.getText().trim();
		
		if(!(maSV.length()>0&&maSV.matches("(SV)\\d{2}"))) {
			JOptionPane.showMessageDialog(this, "Error: Mã sinh viên phải theo mẫu SV + 2 số!");
			txtMaSV.selectAll();
			txtMaSV.requestFocus();
			return false;
		}
		if(!(tenSV.length()>0&& tenSV.matches("[a-zA-Z0-9' ]+"))) {
			JOptionPane.showMessageDialog(this, "Error: Tên sinh viên không được có kí tự đặc biệt!");
			txtTenSV.selectAll();
			txtTenSV.requestFocus();
			return false;
		}
		if(!(SDT.length()>0&& SDT.matches("(0)\\d{9}"))) {
			JOptionPane.showMessageDialog(this, "Error: Số điện thoại phải bắt đầu bằng 0 và có 10 số!");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		if(!(Que.length()>0&& Que.matches("[a-zA-Z0-9' ]+"))) {
			JOptionPane.showMessageDialog(this, "Error: Quê quán không được có kí tự đặc biệt!");
			txtQueQuan.selectAll();
			txtQueQuan.requestFocus();
			return false;
		}
		if(!(lop.length()>0&& lop.matches("[a-zA-Z0-9' ]+"))) {
			JOptionPane.showMessageDialog(this, "Error: Lớp không được có kí tự đặc biệt!");
			txtLop.selectAll();
			txtLop.requestFocus();
			return false;
		}
		if(!(Email.length()>0&& Email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))) {
			JOptionPane.showMessageDialog(this, "Error: Email phải có dang tenemail@diaChiEmail!");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}

	
}

