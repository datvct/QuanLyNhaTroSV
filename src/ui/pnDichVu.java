package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import connectDB.ConnectDB;
import dao.dichVu_dao;
import enity.DichVu;
import enity.PhongTro;

import javax.swing.JButton;

public class pnDichVu extends JPanel implements ActionListener{
	private JTextField txtDchV;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtGiaTien;
	private DefaultTableModel modelDV;
	private JTable table;
	private ImageIcon icon_add = new ImageIcon(getClass().getResource("addhd.png"));
	private ImageIcon icon_delete = new ImageIcon(getClass().getResource("delete.png"));
	private ImageIcon icon_update = new ImageIcon(getClass().getResource("updatehd.png"));
	private ImageIcon icon_clear = new ImageIcon(getClass().getResource("clear.png"));
	private ImageIcon icon_find = new ImageIcon(getClass().getResource("find.png"));
	private dichVu_dao ctdh_dao;
	private JButton btnCapNhap,btnXoa,btnThem,btnlamMoi;
	/**
	 * Create the panel.
	 */
	public pnDichVu() {
		setLayout(null);
		ctdh_dao = new dichVu_dao();
		JPanel pnNorth = new JPanel();
		pnNorth.setBounds(10, 11, 1066, 59);
		add(pnNorth);
		pnNorth.setLayout(null);
		
		txtDchV = new JTextField();
		txtDchV.setForeground(new Color(255, 0, 0));
		txtDchV.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtDchV.setText("Dịch Vụ");
		txtDchV.setHorizontalAlignment(SwingConstants.CENTER);
		txtDchV.setBounds(273, 0, 500, 59);
		pnNorth.add(txtDchV);
		txtDchV.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 113, 1066, 171);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(40, 21, 916, 33);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDV = new JLabel("Mã Dịch Vụ:");
		lblDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblDV.setBounds(171, 0, 135, 33);
		panel_2.add(lblDV);
		
		txtMaDV = new JTextField();
		txtMaDV.setBounds(358, 0, 366, 33);
		panel_2.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(40, 65, 916, 33);
		panel_1.add(panel_2_1);
		
		JLabel lblTenDV = new JLabel("Tên Dịch Vụ:");
		lblTenDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenDV.setBounds(171, 0, 135, 33);
		panel_2_1.add(lblTenDV);
		
		txtTenDV = new JTextField();
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(358, 0, 366, 33);
		panel_2_1.add(txtTenDV);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(40, 109, 916, 33);
		panel_1.add(panel_2_1_1);
		
		JLabel lblGiaDV = new JLabel("Giá Tiền dịch vụ:");
		lblGiaDV.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiaDV.setBounds(171, 0, 135, 33);
		panel_2_1_1.add(lblGiaDV);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(358, 0, 366, 33);
		panel_2_1_1.add(txtGiaTien);
		
		JPanel pntable = new JPanel();
		pntable.setBounds(69, 339, 954, 384);
		pntable.setBorder(BorderFactory.createTitledBorder("Danh sách Dịch Vụ"));
		add(pntable);
	
		pntable.setLayout(null);
		
		
	
		
		String[] colHeader = {"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ"};
		modelDV = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDV);
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc.setBounds(10, 35, 934, 338);
		pntable.add(sc);
		
		JPanel pnCN = new JPanel();
		pnCN.setBounds(140, 290, 764, 33);
		add(pnCN);
		pnCN.setLayout(null);
		
		btnThem= new JButton("Thêm", icon_add);
		btnThem.setBounds(0, 0, 117, 33);
		pnCN.add(btnThem);
		
		btnXoa = new JButton("Xóa", icon_delete);
		btnXoa.setBounds(159, 0, 117, 33);
		pnCN.add(btnXoa);
		
		btnCapNhap = new JButton("Cập Nhập", icon_update);
		btnCapNhap.setBounds(343, 0, 117, 33);
		pnCN.add(btnCapNhap);
		
		btnlamMoi = new JButton("Làm mới", icon_clear);
		btnlamMoi.setBounds(508, 0, 117, 33);
		pnCN.add(btnlamMoi);
		
		docDLvaoDsTro();
		btnThem.addActionListener(this);
	}
	
	public void docDLvaoDsTro() {
		List<DichVu> list = ctdh_dao.loadDLVaoPnDV();
		modelDV.setRowCount(0);
		for (DichVu cthd : list) {
			modelDV.addRow(new Object[] {cthd.getMaDV(),cthd.getTenDV(),cthd.getGiaDV()});
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if (o.equals(btnThem)) {
//			String ma = txtMaDV.getText();
//			String ten = txtTenDV.getText();
//			Float gia = Float.parseFloat(txtGiaTien.getText());
//			
//			CT_HD cthd = new CT_HD(ma, ten, gia);
//			try {
//				ctdh_dao.create(null)
//				modelDV.addRow(new Object[] {cthd.getMaDV(),cthd.getTenDV(),cthd.getGiaDV()});
//				
//			} catch (Exception e2) {
//				JOptionPane.showMessageDialog(this, "Trùng mã");
//			}
//		}
//		
	}
	
}
