package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhaTro_Dao;
import dao.PhongTro_Dao;
import enity.LoaiPhong;
import enity.NhaTro;
import enity.PhongTro;
import giaoDien.Button;
import giaoDien.PanelTim;
import giaoDien.SetFont;

public class pnPhongTro extends JPanel implements ActionListener, MouseListener{
	private JPanel pnCenter;
	private JLabel lblTitle;
	private JTextField txtTim;
	private JTable tblInfo;
	private JLabel lblMaPhong, lblTenPhong, lblGiaThue, lblDienTich, lblLoaiPhong, lblTinhTrang;
	private static JTextField txtMaPhong, txtTenPhong, txtGiaThue, txtDienTich;
	private static JButton btnThem, btnXoa, btnSua, btnLuu, btnXoaRong, btnNext, btnPrevious, btnEndNext, btnEndPrevious, btnLietKe, btnTim, btnLamMoi;
	private DefaultTableModel dfTable;
	private ListSelectionModel modelSelect;
	private JRadioButton radMaPhong, radTenPhong;
	public JLabel lblChiSo;	
	public JList<String> jLstTro;
	public DefaultListModel dfList;
	private JComboBox<String> cbLoaiPhong, cbLoaiPhong1;
	private JComboBox<String> cbTinhTrang;
	private JLabel lblLoaiPhong1;
	private PhongTro_Dao pt_dao;
	private DefaultTableModel modelDC;
	private JTable tableDC;
	private NhaTro_Dao nt_dao;
	private JLabel lblMaTro;
	private JComboBox<String> cbMaTro;
	


	/**
	 * Create the panel.
	 */
	public pnPhongTro() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		pt_dao = new PhongTro_Dao();
		nt_dao = new NhaTro_Dao();
		pnCenter = new JPanel();

		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		
		
		JPanel pnTop = new JPanel(new BorderLayout());
		pnTop.setOpaque(false);
		//title
		JPanel pnTitle = new JPanel();
		pnTitle.setBounds(440, 40, 800, 70);
		pnTitle.setLayout(null);
		pnTitle.setBackground(Color.WHITE);
		pnTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		pnTitle.setOpaque(false);
		lblTitle = new JLabel("Phòng Trọ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblTitle.setForeground(Color.RED);
    	lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
//    	lblTitle.setOpaque(true);
    	lblTitle.setPreferredSize(new Dimension(800,80));
    	pnTitle.add(lblTitle);
		pnTop.add(pnTitle, BorderLayout.NORTH);
		
		pnCenter.add(pnTop);
		JPanel pnWrapTop = new JPanel(); //panel chứa panel nhập liệu và panel chức năng tim kiem
//		pnWrapTop.setOpaque(true);
		
//Vị trí Center của pnWrapTop
		
		JPanel pnInput = new JPanel(); //panel chứa các label và textfield nhập liệu
//		pnInput.setBackground(Color.decode(""));
		pnInput.setBorder(new TitledBorder(null, "Nhập Thông Tin Phòng Trọ", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
//		pnInput.setOpaque(false);
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		
		JPanel pnMaPhong = new JPanel(new FlowLayout(0));
//		pnDiaChi.setOpaque(true);
		pnMaPhong.add(lblMaPhong = new JLabel("Mã phòng:"));
		lblMaPhong.setForeground(Color.BLACK);
		pnMaPhong.add(txtMaPhong = new JTextField());
		
		
		JPanel pnTenPhong = new JPanel(new FlowLayout(0));
		pnTenPhong.setOpaque(false);
		pnTenPhong.add(lblTenPhong = new JLabel("Tên phòng:"));
		pnTenPhong.add(txtTenPhong = new JTextField());
		
		JPanel pnLoaiPhong = new JPanel(new FlowLayout(0));
		pnLoaiPhong.setOpaque(false);
		pnLoaiPhong.add(lblLoaiPhong = new JLabel("Loại phòng:"));
		pnLoaiPhong.add(cbLoaiPhong = new JComboBox<String>());
		cbLoaiPhong.setPreferredSize(new Dimension(170, 30));
		
		JPanel pnGiaThue = new JPanel();
		pnGiaThue.setOpaque(false);
		pnGiaThue.add(lblGiaThue = new JLabel("Giá thuê:"));
		pnGiaThue.add(txtGiaThue = new JTextField());
		
		JPanel pnDienTich = new JPanel();
		pnDienTich.setOpaque(false);
		pnDienTich.add(lblDienTich = new JLabel("Diện tích:"));
		pnDienTich.add(txtDienTich = new JTextField());
		
		JPanel pnTinhTrang = new JPanel(new FlowLayout(0));
		pnTinhTrang.setOpaque(false);
		pnTinhTrang.add(lblTinhTrang = new JLabel("Tình trạng:"));
		pnTinhTrang.add(cbTinhTrang = new JComboBox<String>());
		cbTinhTrang.addItem("Phòng Trống");
		cbTinhTrang.addItem("Phòng Có Người");
		cbTinhTrang.setPreferredSize(new Dimension(170, 30));
		
		JPanel pnMaTro = new JPanel(new FlowLayout(0));
		pnMaTro.setOpaque(false);
		pnMaTro.add(lblMaTro = new JLabel("Mã trọ:"));
		pnMaTro.add(cbMaTro = new JComboBox<String>());
		cbMaTro.setPreferredSize(new Dimension(170, 30));
		
		
		pnInput.add(pnMaPhong);
		pnInput.add(pnTenPhong);
		pnInput.add(pnLoaiPhong);
		pnInput.add(pnGiaThue);
		pnInput.add(pnDienTich);
		pnInput.add(pnTinhTrang);
		pnInput.add(pnMaTro);
		
		pnWrapTop.add(pnInput);
		//Vị trí East của pnWrapTop
		JPanel pnLoaiTimKiem = new JPanel();	
		pnLoaiTimKiem.setBackground(Color.WHITE);
		pnLoaiTimKiem.setPreferredSize(new Dimension(400, 173));				
		pnLoaiTimKiem.setBorder(new TitledBorder(null, "Tìm Kiếm", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
				

		pnLoaiTimKiem.setLayout(new BoxLayout(pnLoaiTimKiem, BoxLayout.Y_AXIS));
		pnLoaiTimKiem.setOpaque(false);
		//Panel Search
		JTabbedPane tbbChucNang = new JTabbedPane();
		tbbChucNang.setPreferredSize(new Dimension(400, 200));
		tbbChucNang.setFont(new Font("", Font.BOLD, 15));
		JPanel pnWrapSearch = new JPanel();
		txtTim = new JTextField();
		txtTim.setPreferredSize(new Dimension(200, 26));
		btnTim = new JButton("Tìm");
		pnWrapSearch.setPreferredSize(new Dimension(0, 30));
		pnWrapSearch.setOpaque(false);
		pnWrapSearch.add(Box.createHorizontalStrut(5));
		pnWrapSearch.add(txtTim);
		pnWrapSearch.add(btnTim);
		pnLoaiTimKiem.add(pnWrapSearch);	
		pnLoaiTimKiem.add(radMaPhong = new JRadioButton("Tìm Kiếm Theo Mã Phòng"));
		radMaPhong.setSelected(true);
		pnLoaiTimKiem.add(radTenPhong = new JRadioButton("Tìm Kiếm Tên Phòng"));						
		pnLoaiTimKiem.setOpaque(true);
		ButtonGroup grpRadTimKiem = new ButtonGroup();
		grpRadTimKiem.add(radMaPhong);
		grpRadTimKiem.add(radTenPhong);
		
		
				
		//Panel liệt kê cho tabbedpane
		JPanel pnLietKe = new JPanel(new BorderLayout());										

		//	pnNganh
		JPanel pnLoaiPhong1 = new JPanel();// chứa label "LoaiPhong" và combobox các loại Phòng
				
		pnLoaiPhong1.add(lblLoaiPhong1 = new JLabel("Loại phòng:"));
		lblLoaiPhong1.setFont(new Font("", 0, 17));
				
		pnLoaiPhong1.add(cbLoaiPhong1 = new JComboBox<>());

		cbLoaiPhong1.setFont(new Font("", 0, 17));
		cbLoaiPhong1.setMaximumRowCount(4);
		cbLoaiPhong1.setPreferredSize(new Dimension(250, 30));
		cbLoaiPhong1.setEditable(true);
				
		//add LoaiPhong vào panel pnLietKe của tabbedPane
		pnLietKe.add(pnLoaiPhong1, BorderLayout.CENTER);
				
		pnLietKe.add(btnLietKe = Button.myButtonUI(null,JButton.CENTER, "Thực hiện", 20, "#039BE5", "#29B6F6", ""), BorderLayout.SOUTH);
				
		//Add panel Tìm kiếm và LietKe vào tabbedPane
		tbbChucNang.add("Loại tìm kiếm", pnLoaiTimKiem);
		tbbChucNang.add("Liệt kê theo loại phòng", pnLietKe);
				
		pnWrapTop.add(tbbChucNang);
		
		
		
				
		//set font-size, color cho label, và size cho textfield

		Component[] compInput = pnInput.getComponents();
		for (Component component : compInput) {
			SetFont.set(component, new Font("", 0, 20), SetFont.LABEL);
			SetFont.set(component, new Dimension(300, 25), SetFont.TEXT_FIELD);
			SetFont.set(component, new Font("", 0, 14), SetFont.TEXT_FIELD);
			SetFont.set(component, Color.BLACK, SetFont.LABEL);
		}
					
		for (Component component : compInput)
			SetFont.set(component, lblLoaiPhong.getPreferredSize(), SetFont.LABEL);
								
		Component[] radComponent = pnLoaiTimKiem.getComponents();
		for (Component rad: radComponent) {
				rad.setFont(new Font("", Font.PLAIN, 18));
				rad.setForeground(Color.BLACK);
		}
				
		//Hoàn tất, thêm wrapTop vào pnCenter
		pnCenter.add(pnWrapTop);
		//end-top
		
		//task
		JPanel pnTask = new JPanel(new FlowLayout(1, 0, 0));
		pnTask.setBackground(Color.decode("#C0C0C0"));
		

		
		
		
		pnTask.add(btnThem = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Thêm", 18, "#C0C0C0", "#29B6F6", "asset\\plus.png"));
		pnTask.add(btnXoa = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Xoá", 18, "#C0C0C0", "#29B6F6", "asset\\minus.png"));
		pnTask.add(btnSua = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Sửa", 18, "#C0C0C0", "#29B6F6", "asset\\edit.png"));
		pnTask.add(btnLuu = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Lưu", 18, "#C0C0C0", "#29B6F6", "asset\\database.png"));
		pnTask.add(btnXoaRong = Button.myButtonUI(new Dimension(150, 55),JButton.CENTER, "Xoá rỗng", 18, "#C0C0C0", "#29B6F6", "asset\\eraser.png"));
		pnTask.add(btnLamMoi = Button.myButtonUI(new Dimension(150, 55),JButton.CENTER, "Làm mới", 18, "#C0C0C0", "#29B6F6", "asset\\refresh.png"));
		pnTask.setPreferredSize(new Dimension(1455, 50));
		
		pnCenter.add(pnTask); //add to pnCenter
		
	
		//Panel table trọ
		JPanel pnListTbl = new JPanel(new BorderLayout());
		pnListTbl.setOpaque(false);

		JPanel pnWestListTbl = new JPanel(); //panel chứa panelList và panel tác vụ: Chontatca
		pnWestListTbl.setOpaque(false);
		pnWestListTbl.setLayout(new BoxLayout(pnWestListTbl, BoxLayout.X_AXIS));
			
		//Panel table
		String col[]= {
						"Mã phòng","Tên phòng","Loại phòng", "Giá thuê", "Diện tích", "Tình trạng" , "Mã trọ"
		};

		dfTable = new DefaultTableModel(col, 0);
		tblInfo = new JTable(dfTable){
			@Override
			public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
		tblInfo.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tblInfo.setFont(new Font("", 0, 15));
				
		modelSelect = tblInfo.getSelectionModel();
		modelSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				

		//set pre-size = 0 -> kích thước chỉ vừa đủ cho 1 cột
				
		tblInfo.getColumnModel().getColumn(0).setMinWidth(100);
		tblInfo.getColumnModel().getColumn(0).setMaxWidth(100);
		tblInfo.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblInfo.getColumnModel().getColumn(2).setPreferredWidth(50);
		tblInfo.getColumnModel().getColumn(3).setPreferredWidth(50);
		tblInfo.getColumnModel().getColumn(4).setPreferredWidth(50);
		tblInfo.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblInfo.getColumnModel().getColumn(6).setPreferredWidth(50);

		JPanel pnTable = new JPanel();     
		JScrollPane sc1 = new JScrollPane(tblInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnTable.setBorder(new TitledBorder(null, "Thông tin phòng", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
		sc1.setPreferredSize(new Dimension(700, 400));
		
		String[] colHeader = {"Mã Trọ","Địa chỉ"};
		modelDC = new DefaultTableModel(colHeader, 0);
		tableDC = new JTable(modelDC);
		tableDC.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tableDC.setFont(new Font("", 0, 15));
		tableDC.getColumnModel().getColumn(0).setMinWidth(100);
		tableDC.getColumnModel().getColumn(0).setMaxWidth(100);
		tableDC.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		JScrollPane sc2 = new JScrollPane(tableDC, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc2.setPreferredSize(new Dimension(300, 400));
		pnTable.add(sc2);
		pnTable.add(sc1);
		pnListTbl.add(pnTable, BorderLayout.CENTER);

		//Hoàn tất add vào pnCenter
		pnCenter.add(pnListTbl); //add to pnCenter

		
		
		
		pnCenter.setPreferredSize(new Dimension(1030, 777));
		
		
		
	
		add(pnCenter, BorderLayout.CENTER);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLietKe.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTim.addActionListener(this);
		DocDuLieuDatabaseVaoTable();
		upDC();
		DocLoaiPhongVaoCombobox();
		DocMaTroVaoCombobox();
		DocLoaiPhongVaoComboboxTimKiem();
		tblInfo.addMouseListener(this);
		
	
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblInfo.getSelectedRow();
		txtMaPhong.setText(dfTable.getValueAt(row, 0).toString());
		txtTenPhong.setText(dfTable.getValueAt(row, 1).toString());
		cbLoaiPhong.setSelectedItem(dfTable.getValueAt(row, 2).toString());
		txtGiaThue.setText(dfTable.getValueAt(row, 3).toString());
		txtDienTich.setText(dfTable.getValueAt(row, 4).toString());
		cbTinhTrang.setSelectedItem(dfTable.getValueAt(row, 5).toString());
		cbMaTro.setSelectedItem(dfTable.getValueAt(row, 6).toString());
		
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
		
		
		if(o.equals(btnThem)) {
			if(txtMaPhong.getText().equals("") || txtTenPhong.getText().equals("") || txtGiaThue.getText().equals("") || txtDienTich.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Error! : Yêu cầu nhập đầy đủ thông tin");
			}
			else {
				if(validData()) {
					String maPhong = txtMaPhong.getText();
					String tenPhong = txtTenPhong.getText();
					LoaiPhong loaiPhong = new LoaiPhong(cbLoaiPhong.getSelectedItem().toString());
					Double giaThue = Double.parseDouble(txtGiaThue.getText());
					String dienTich = txtDienTich.getText();
					String tinhTrang = cbTinhTrang.getSelectedItem().toString();
					NhaTro nt = new NhaTro(cbMaTro.getSelectedItem().toString());
					PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, nt);
					try {
						if(pt_dao.create(pt)) {
							dfTable.addRow(new Object[] {pt.getMaPhong(), pt.getTenPhong(), pt.getLoaiPhong().getLoaiPhong(), pt.getGiaThue()+"", pt.getDienTich(), pt.getTinhTrang(), pt.getMTro().getMaTro()});
							txtMaPhong.setText("");
							xoaRong();
							
						}
						else {
							JOptionPane.showMessageDialog(this, "Trùng mã phòng!");
							txtMaPhong.requestFocus();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Error!");
						txtMaPhong.requestFocus();
					}
				}
			}
		}
		
		else if (o.equals(btnXoaRong)) {
			txtMaPhong.setText("");
			txtTenPhong.setText("");
			txtGiaThue.setText("");
			txtDienTich.setText("");
			txtMaPhong.requestFocus();;
		}
		
		else if (o.equals(btnXoa)) {
			int r = tblInfo.getSelectedRow();
//			String maTro = dfTable.getValueAt(r, 0).toString();
			if(r != -1) {
				String maPhong = (String)tblInfo.getModel().getValueAt(r, 0);
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
				if(hoi == JOptionPane.YES_OPTION) {
					try {
						pt_dao.delete(maPhong);
						dfTable.removeRow(r);
						txtMaPhong.setText("");
						xoaRong();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
			}
		}
		
		else if (o.equals(btnSua)) {
			int row = tblInfo.getSelectedRow();
			if(row != -1) {
				if(btnSua.getText().equalsIgnoreCase("Sửa")) {
					txtMaPhong.setEditable(false);
					txtTenPhong.requestFocus();
					btnSua.setText("Hủy");
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					
				}
				else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
					btnSua.setText("Sửa");
					txtMaPhong.setEditable(true);
					txtMaPhong.requestFocus();
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
				}
			}
		}
		
		else if (o.equals(btnLuu)) {
			if(txtMaPhong.getText().equals("") || txtTenPhong.getText().equals("") || txtGiaThue.getText().equals("") || txtDienTich.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Error! : Yêu cầu nhập đầy đủ thông tin");
			}
			else {
				if(validData()) {
					update();
				}
			}
			
		}
		
		else if (o.equals(btnTim)) {
			if(radMaPhong.isSelected()) {
				DocDuLieuTimMaPhong();
			}
			
			else if (radTenPhong.isSelected()) {
				DocDuLieuTimTenPhogn();
			}
		}
		
		else if (o.equals(btnLietKe)) {
			LietKe();
		}
		
		else if (o.equals(btnLamMoi)) {
			DocDuLieuDatabaseVaoTable();
			xoaRong();
		}
	}
	
	public void DocDuLieuDatabaseVaoTable() {
		List<PhongTro> list = pt_dao.loadPhongTroFromDatabase();
		dfTable.setRowCount(0);
		for (PhongTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaPhong(),nt.getTenPhong(),nt.getLoaiPhong().getLoaiPhong(),nt.getGiaThue(), nt.getDienTich(), nt.getTinhTrang(), nt.getMTro().getMaTro()});
		}
	}
	
	public void upDC() {
		List<NhaTro> list = nt_dao.loadDiaChiFormDatabase();
		modelDC.setRowCount(0);
		for (NhaTro nt : list) {
			modelDC.addRow(new Object[] {nt.getMaTro(),nt.getDiaChi()});
		}
	}
	
	public void DocMaTroVaoCombobox() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from NhaTro ";
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()) {
//				this.cbMaTro.addItem(rs.getString("maTro"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void DocLoaiPhongVaoCombobox() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()) {
				String lp = rs.getString(1);
				LoaiPhong pt = new LoaiPhong(lp);
				cbLoaiPhong.addItem(lp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	public void DocLoaiPhongVaoComboboxTimKiem() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "select * from LoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()) {
				String lp = rs.getString(1);
				LoaiPhong pt = new LoaiPhong(lp);
				cbLoaiPhong1.addItem(lp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void doiDong(int row) {
		if (row >= 0) {
			txtMaPhong.setText((String) tblInfo.getValueAt(row, 0));
			txtTenPhong.setText((String) tblInfo.getValueAt(row, 1));
			cbLoaiPhong.setSelectedItem(tblInfo.getValueAt(row, 2).toString());
			txtGiaThue.setText(tblInfo.getValueAt(row, 3).toString());
			txtDienTich.setText((String) tblInfo.getValueAt(row, 4));
			cbTinhTrang.setSelectedItem(tblInfo.getValueAt(row, 5).toString());
			cbMaTro.setSelectedItem(tblInfo.getValueAt(row, 6).toString());
		}
	}
	
	public void xoaRong() {
		txtMaPhong.setText("");
		txtTenPhong.setText("");
		txtGiaThue.setText("");
		txtDienTich.setText("");
		txtMaPhong.requestFocus();
		cbLoaiPhong.setSelectedIndex(0);
		cbTinhTrang.setSelectedIndex(0);
		cbMaTro.setSelectedIndex(0);
	}
	
	
	public void update() {
		int row = tblInfo.getSelectedRow();
		String maPhong = dfTable.getValueAt(row, 0).toString();
		String tenPhong = txtTenPhong.getText();
		LoaiPhong loaiPhong = new LoaiPhong(cbLoaiPhong.getSelectedItem().toString());
		Double giaThue = Double.parseDouble(txtGiaThue.getText());
		String dienTich = txtDienTich.getText();
		String tinhTrang = cbTinhTrang.getSelectedItem().toString();
		NhaTro nt = new NhaTro(cbMaTro.getSelectedItem().toString());
		PhongTro pt = new PhongTro(maPhong, tenPhong, loaiPhong, giaThue, dienTich, tinhTrang, nt);
		try {
			pt_dao.update(pt, maPhong);
			DocDuLieuDatabaseVaoTable();
			JOptionPane.showMessageDialog(this, "Thông tin nhà trọ đã được sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void DocDuLieuTimMaPhong() {
		String ma = txtTim.getText();
		List<PhongTro> list = pt_dao.getTheoMaPhong(ma);
		dfTable.setRowCount(0);
		for(PhongTro pt : list) {
			dfTable.addRow(new Object[] {pt.getMaPhong(), pt.getTenPhong(), pt.getLoaiPhong().getLoaiPhong(), pt.getGiaThue(), pt.getDienTich(), pt.getTinhTrang(), pt.getMTro().getMaTro()});
		}
	}
	
	public void DocDuLieuTimTenPhogn() {
		String ma = txtTim.getText();
		List<PhongTro> list = pt_dao.getTheoTenPhong(ma);
		dfTable.setRowCount(0);
		for(PhongTro pt : list) {
			dfTable.addRow(new Object[] {pt.getMaPhong(), pt.getTenPhong(), pt.getLoaiPhong().getLoaiPhong(), pt.getGiaThue(), pt.getDienTich(), pt.getTinhTrang(), pt.getMTro().getMaTro()});
		}
	}
	
	public void LietKe() {
		String phong = cbLoaiPhong1.getSelectedItem().toString();
		List<PhongTro> list = pt_dao.getLietKe(phong);
		dfTable.setRowCount(0);
		for(PhongTro pt : list) {
			dfTable.addRow(new Object[] {pt.getMaPhong(), pt.getTenPhong(), pt.getLoaiPhong().getLoaiPhong(), pt.getGiaThue(), pt.getDienTich(), pt.getTinhTrang(), pt.getMTro().getMaTro()});
		}
	}
	
	public boolean validData() {
		String maPhong = txtMaPhong.getText().trim();
		String tenPhong = txtTenPhong.getText().trim();
		String giaThue = txtGiaThue.getText().trim();
		String dienTich = txtDienTich.getText().trim();
		if(!(maPhong.length() > 0 && maPhong.matches("(MP)\\d{2}"))) {
			JOptionPane.showMessageDialog(this, "Error! : Mã phòng phải theo mẫu MP + 2 số!");
			txtMaPhong.requestFocus();
			return false;
		}
		
		else if (!(tenPhong.length() > 0 && tenPhong.matches("(Phong)[\\s][a-zA-Z]\\d{2}"))) {
			JOptionPane.showMessageDialog(this, "Error! : Tên phòng phải theo yêu cầu [Phong] [Kí Tự] + 2 số theo mã phòng ");
			txtTenPhong.requestFocus();
			return false;
		}
		
		else if(giaThue.length() > 0) {
			try {
				Double x = Double.parseDouble(giaThue);
				if(x <= 0) {
					JOptionPane.showMessageDialog(this, "Error! : Giá thuê phải lớn hơn 0");
					txtGiaThue.requestFocus();
					return false;
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
		
		else if (!(dienTich.length() > 0 && dienTich.matches("\\d{3}(m2)$"))) {
			JOptionPane.showMessageDialog(this, "Error! : Diện tích phải theo yêu cầu [Diện tích]m2");
			txtDienTich.requestFocus();
			return false;
		}
		
		return true;
	}
	
}
	
	
	