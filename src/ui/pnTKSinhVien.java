package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
import enity.LoaiPhong;
import enity.SinhVien;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.awt.Color;

public class pnTKSinhVien extends JPanel implements ActionListener {
	
	private JTable tableSinhVien;
	private ImageIcon icon_add = new ImageIcon(getClass().getResource("addhd.png"));
	private ImageIcon icon_delete = new ImageIcon(getClass().getResource("delete.png"));
	private ImageIcon icon_update = new ImageIcon(getClass().getResource("updatehd.png"));
	private ImageIcon icon_clear = new ImageIcon(getClass().getResource("clear.png"));
	private ImageIcon icon_find = new ImageIcon(getClass().getResource("find.png"));
	private DefaultTableModel modelSinhVien;
	private JTextField txtMaSV, txtLop, txtSDT;
	private JComboBox<String> cbKhoa;
	private JRadioButton rdbNam, rdbNu;
	private JLabel lblMaSV,lblLop,lblNganh,lblSDT,lblTim,lblGioiTinh,lblten;
	private JButton btnTim, btnLamMoi;
	private JPanel pnTitle;
	private JRadioButton rbtMa,rbtTen,rbtLop,rbtQueQuan,rbtNganh;
	private JTextField txtTmKimSinh;
	private sinhVien_Dao sv_dao;
	private JTextField txtTim;
	private JRadioButton ckbtimNganh,ckbTim; 
	public pnTKSinhVien() {
		setLayout(null);
		sv_dao = new sinhVien_Dao();
		JPanel pnSinhVienTK = new JPanel();
		pnSinhVienTK.setBounds(10, 11, 1093, 800);
		add(pnSinhVienTK);
		
		JPanel pnTim = new JPanel();
		pnTim.setBounds(125, 104, 847, 207);
		pnTim.setPreferredSize(new Dimension(200,300));
		pnTim.setLayout(new BoxLayout(pnTim, BoxLayout.Y_AXIS));
		Box b = Box.createVerticalBox();
		
		Box b2 = Box.createHorizontalBox();
		b.add(Box.createHorizontalStrut(20));
		b2.add(lblTim = new JLabel("Tìm kiếm:"));
		b2.add(txtTim = new JTextField());
		
		cbKhoa = new JComboBox<>();
		
		
		Box b3 = Box.createHorizontalBox();
		b3.add(Box.createHorizontalStrut(20));
		b3.add(lblNganh = new JLabel("Ngành:"));
		b3.add(cbKhoa);		
		b3.add(Box.createHorizontalStrut(20));
		
		Box b1 = Box.createVerticalBox();
		b1.add(Box.createHorizontalStrut(20));
		b1.add(lblten = new JLabel("Lựa chọn:"));
		b1.add(rbtMa = new JRadioButton("Tìm kiếm theo mã sinh viên",false));
		b1.add(rbtTen = new JRadioButton("Tìm kiếm theo tên sinh viên",false));
		b1.add(rbtLop = new JRadioButton("Tìm kiếm theo lớp",false));
		b1.add(Box.createHorizontalStrut(20));
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbtMa);
		group.add(rbtTen);
		group.add(rbtLop);
		group.add(rbtQueQuan);

		
		pnTim.setBorder(new TitledBorder(null, "Tìm Kiếm", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
		pnTim.add(b);
		
		
		
		
		String[] colHeader = {"Mã Sinh Viên", "Họ Tên", "Giới Tính", "Lớp", "Ngành", "Quê Quán", "Số Điện Thoại", "Email"};
		modelSinhVien = new DefaultTableModel(colHeader, 0);
		tableSinhVien = new JTable(modelSinhVien);
		tableSinhVien.setPreferredSize(new Dimension(1200, 325));
		tableSinhVien.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tableSinhVien.setFont(new Font("", 0, 15));
		tableSinhVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableSinhVien.getColumnModel().getColumn(2).setPreferredWidth(20);
		tableSinhVien.getColumnModel().getColumn(3).setPreferredWidth(35);
		tableSinhVien.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableSinhVien.getColumnModel().getColumn(5).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(7).setPreferredWidth(170);
		pnSinhVienTK.setLayout(null);
		
		pnSinhVienTK.add(pnTim);
		JScrollPane scrollPane = new JScrollPane(tableSinhVien);
		scrollPane.setBounds(74, 352, 979, 352);
		pnSinhVienTK.add(scrollPane);
		
		pnTitle = new JPanel();
		pnTitle.setBounds(115, 23, 872, 70);
		pnSinhVienTK.add(pnTitle);
		pnTitle.setLayout(null);
		
		txtTmKimSinh = new JTextField();
		txtTmKimSinh.setForeground(new Color(255, 0, 0));
		txtTmKimSinh.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTmKimSinh.setText("Tìm Kiếm Sinh Viên");
		txtTmKimSinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtTmKimSinh.setBounds(10, 0, 852, 70);
		pnTitle.add(txtTmKimSinh);
		txtTmKimSinh.setColumns(10);
		
		JPanel pnButton = new JPanel();
		pnButton.setBounds(135, 307, 835, 43);
		pnSinhVienTK.add(pnButton);
		pnButton.setLayout(null);
		
		ckbTim = new JRadioButton("Tìm theo dữ liệu nhập");
		ckbTim.setBounds(27, 11, 159, 21);
		pnButton.add(ckbTim);
		
		btnTim = new JButton("Tìm", icon_find);
		btnTim.setBounds(365, 5, 99, 33);
		pnButton.add(btnTim);
		
		btnLamMoi = new JButton("Làm Mới", icon_clear);
		btnLamMoi.setBounds(493, 5, 114, 33);
		pnButton.add(btnLamMoi);
		
		ckbtimNganh = new JRadioButton("Tìm theo ngành");
		ckbtimNganh.setBounds(202, 11, 135, 21);
		pnButton.add(ckbtimNganh);
		
		ButtonGroup group1 = new ButtonGroup();
		group1.add(ckbTim);
		group1.add(ckbtimNganh);
	
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		DocLoaiPhongVaoComboboxTimKiem();
		DocDuLieuDatabaseVaoTable();
		ckbTim.addActionListener(this);
		ckbtimNganh.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			if (o.equals(btnLamMoi)) {
				txtTim.setText("");
				txtTim.requestFocus();
				rbtMa.setSelected(false);
				rbtTen.setSelected(false);
				rbtLop.setSelected(false);
				DocDuLieuDatabaseVaoTable(); //Thêm đọc lại bảng khi tìm xong muốn quay lại bảng đầy đủ
			}
		}
		if (o.equals(btnTim)) {
			if(ckbTim.isSelected()) {
				if(rbtMa.isSelected()) {
					if(txtTim.getText().equals("") && !(rbtMa.isSelected()) ) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm và chọn mục dữ liệu cần tìm!");
					}
					else {
						DocDuLieuFindMSvVaoTable();
					}
				}
				else if (rbtTen.isSelected()) {
					if(txtTim.getText().equals("") && !(rbtTen.isSelected()) ) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm và chọn mục dữ liệu cần tìm!");
					}
					else
						DocDuLieuFindtenSVVaoTable();
				}
				else if(rbtLop.isSelected()) {
					if(txtTim.getText().equals("") && !(rbtLop.isSelected()) ) {
						JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm và chọn mục dữ liệu cần tìm!");
					}
					else 
						DocDuLieuFindlopSVVaoTable();
				}
			}
			else if(ckbtimNganh.isSelected()) {
				LietKeNganh();
			}
			else 
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tiêu chí cần tìm!");
			
		}
	}
	public void DocDuLieuDatabaseVaoTable() {
		List<SinhVien> list = sv_dao.getAllSinhVien();
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	public void DocDuLieuFindMSvVaoTable() {
		String ma = txtTim.getText();
		ArrayList<SinhVien> list = sv_dao.getSinhVienTheoMaSV(ma);
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	public void DocDuLieuFindtenSVVaoTable() {
		String ten = txtTim.getText();
		ArrayList<SinhVien> list = sv_dao.getSinhVienTheoTenSV(ten);
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	public void DocDuLieuFindlopSVVaoTable() {
		String lop = txtTim.getText();
		ArrayList<SinhVien> list = sv_dao.getSinhVienTheolopSV(lop);
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	public void LietKeNganh() {
		String nganh = cbKhoa.getSelectedItem().toString();
		List<SinhVien> list = sv_dao.getLietKe(nganh);
		modelSinhVien.setRowCount(0);
		for (SinhVien sv : list) {
			modelSinhVien.addRow(new Object[] {sv.getMaSV(),sv.getTenSV(),sv.getGT()?"Nam":"Nữ",sv.getLop(),sv.getNganh(),sv.getQuequan(),sv.getSdt(),sv.getEmail()});
		}
	}
	
	public void DocLoaiPhongVaoComboboxTimKiem() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select nganh from SinhVien group by nganh";
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()) {
				String nganh = rs.getString(1);
				SinhVien sv = new SinhVien();
				sv.setNganh(nganh);
				cbKhoa.addItem(nganh);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
