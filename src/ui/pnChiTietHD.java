package ui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.HopDong_Dao;
import enity.DichVu;
import enity.HopDong;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Font;

public class pnChiTietHD extends JPanel {
	private JTable table;
	private JPanel pnDSCT;
	private DefaultTableModel model;
	private HopDong_Dao hd_dao;
	private SimpleDateFormat dfNgay;
	private DecimalFormat dfGiaPhong;	
	private JTextField txtChiTitHp;
	/**
	 * Create the panel.
	 */
	public pnChiTietHD() {
		dfNgay=new SimpleDateFormat("dd/MM/yyyy");
		dfGiaPhong=new DecimalFormat("###,##0.00");
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		hd_dao = new HopDong_Dao();
		pnDSCT = new JPanel();
		pnDSCT.setBounds(0, 82, 1113, 659);
		add(pnDSCT);
		pnDSCT.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 22, 969, 596);
		String[] headers = "Mã HĐ;Mã Sinh Viên;Tên Sinh Viên;Lớp;Ngành;Mã phòng;Tên phòng;Loại Phòng;Giá Phòng;Ngày Lập;Ngày Hết HĐ".split(";");
		model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);
		table.getColumnModel().getColumn(10).setPreferredWidth(50);
		
		table.setFont(new Font("", 0, 15));
		
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 24, 1093, 679);
		pnDSCT.add(scroll);
		pnDSCT.setBorder(new TitledBorder(new TitledBorder(null, "Danh Sách", 0, 0, new Font("", Font.BOLD, 15), Color.BLUE)));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1103, 57);
		add(panel);
		panel.setLayout(null);
		
		txtChiTitHp = new JTextField();
		txtChiTitHp.setForeground(new Color(255, 0, 0));
		txtChiTitHp.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtChiTitHp.setText("Chi Tiết Hợp Đồng");
		txtChiTitHp.setHorizontalAlignment(SwingConstants.CENTER);
		txtChiTitHp.setBounds(185, 0, 700, 57);
		panel.add(txtChiTitHp);
		txtChiTitHp.setColumns(10);
		docDL();
	}

	
	public void docDL()
	{
			ArrayList<HopDong> list =hd_dao.getCTDHHD();
			model.setRowCount(0);
			for (HopDong hd : list) {
				model.addRow(new Object[] {hd.getMaHopDong(),hd.getMaSV().getMaSV(),hd.getTenSV().getTenSV(),hd.getLop().getLop(),hd.getNganh().getNganh(),hd.getMaPhong().getMaPhong(),
						hd.getTenPhong().getTenPhong(),hd.getLoaiPhong().getLoaiPhong().getLoaiPhong(),hd.getGiaPhong(),dfNgay.format( hd.getNgayLap()),dfNgay.format( hd.getNgayHetHD())});
			}
		}
}
