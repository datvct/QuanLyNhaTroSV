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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhaTro_Dao;
import enity.NhaTro;
import giaoDien.Button;
import giaoDien.PanelTim;
import giaoDien.SetFont;

public class pnNhaTro extends JPanel implements ActionListener, MouseListener {
	private JPanel pnCenter;
	private JLabel lblTitle;
	private JLabel lblTim;
	private JTextField txtTim;
	private JButton btnTim, btnQuayLai;
	private JTable tblInfo;
	private JLabel lblMaTro, lblDiachi, lblChuNha, lblSoDT;
	private static JTextField txtMaTro, txtDiaChi, txtChuNha, txtSoDT;
	private static JButton btnThem, btnXoa, btnSua, btnLuu, btnXoaRong, btnMoiNhaTro, btnXemSinhVien, btnLamMoi;
	private DefaultTableModel dfTable;
	private ListSelectionModel modelSelect;
	private static boolean  kiemTra = true;
	public JLabel lblChiSo;				
	
	private JRadioButton radDiaChi, radChuNha, radSdt, radMaTro;
	private NhaTro_Dao nt_dao;
	public pnNhaTro() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		nt_dao = new NhaTro_Dao();
		pnCenter = new JPanel();
		pnCenter.setBounds(51, 5, 1030, 800);

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
		lblTitle = new JLabel("Nhà Trọ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    	lblTitle.setForeground(Color.RED);
    	lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
//    	lblTitle.setOpaque(true);
    	lblTitle.setPreferredSize(new Dimension(800,80));
    	pnTitle.add(lblTitle);
		pnTop.add(pnTitle, BorderLayout.NORTH);
//		pnSearch = new PanelTim(new Dimension(330, 33), "ui\\find.png");
		//end - search panel
		
		pnCenter.add(pnTop);
		JPanel pnWrapTop = new JPanel(); //panel chứa panel nhập liệu và panel chức năng tim kiem
//		pnWrapTop.setOpaque(true);
		
		//Vị trí Center của pnWrapTop
		
		JPanel pnInput = new JPanel(); //panel chứa các label và textfield nhập liệu
//		pnInput.setBackground(Color.decode(""));
		pnInput.setBorder(new TitledBorder(null, "Nhập Thông Tin Nhà Trọ", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
//		pnInput.setOpaque(false);
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		
		
		JPanel pnMaTro = new JPanel(new FlowLayout(0));
		pnMaTro.add(lblMaTro = new JLabel("Mã trọ:"));
		lblMaTro.setForeground(Color.BLACK);
		pnMaTro.add(txtMaTro = new JTextField());
		JPanel pnDiaChi = new JPanel(new FlowLayout(0));
//		pnDiaChi.setOpaque(true);
		pnDiaChi.add(lblDiachi = new JLabel("Địa chỉ:"));
		lblDiachi.setForeground(Color.BLACK);
		pnDiaChi.add(txtDiaChi = new JTextField());
		
		
		JPanel pnChuNha = new JPanel(new FlowLayout(0));
		pnChuNha.setOpaque(false);
		pnChuNha.add(lblChuNha = new JLabel("Chủ trọ:"));
		pnChuNha.add(txtChuNha = new JTextField());
		
		JPanel pnSoDT = new JPanel(new FlowLayout(0));
		pnSoDT.setOpaque(false);
		pnSoDT.add(lblSoDT = new JLabel("Số điện thoại:"));
		pnSoDT.add(txtSoDT = new JTextField());
		
		
		pnInput.add(pnMaTro);
		pnInput.add(pnDiaChi);
		pnInput.add(pnChuNha);
		pnInput.add(pnSoDT);
		
		
		//Vị trí East của pnWrapTop
		JPanel pnLoaiTimKiem = new JPanel();	
		pnLoaiTimKiem.setBackground(Color.WHITE);
		pnLoaiTimKiem.setOpaque(true);
		pnLoaiTimKiem.setPreferredSize(new Dimension(400, 200));
		
		pnLoaiTimKiem.setBorder(new TitledBorder(null, "Tìm Kiếm", 0, 0, new Font("", Font.BOLD, 20), Color.BLUE));
		

		pnLoaiTimKiem.setLayout(new BoxLayout(pnLoaiTimKiem, BoxLayout.Y_AXIS));
		
		//Panel Search
		JPanel pnWrapSearch = new JPanel();
		txtTim = new JTextField();
		txtTim.setPreferredSize(new Dimension(200, 26));
		btnTim = new JButton("Tìm");
		btnQuayLai = Button.myButtonUI(new Dimension(55, 55),JButton.CENTER, "", 12, "#C0C0C0", "#29B6F6", "asset\\lamlai.png");
		pnWrapSearch.setPreferredSize(new Dimension(0, 31));
		pnWrapSearch.setOpaque(false);
		pnWrapSearch.add(Box.createHorizontalStrut(5));
		pnWrapSearch.add(txtTim);
		pnWrapSearch.add(btnTim);
		pnLoaiTimKiem.add(pnWrapSearch);	
		//end
		pnLoaiTimKiem.add(radMaTro = new JRadioButton("Tìm Kiếm Theo Mã Trọ"));
		radMaTro.setSelected(true);
		pnLoaiTimKiem.add(radDiaChi = new JRadioButton("Tìm Kiếm Theo Địa Chỉ"));
		
		pnLoaiTimKiem.add(radChuNha = new JRadioButton("Tìm Kiếm Chủ Trọ"));
		pnLoaiTimKiem.add(radSdt = new JRadioButton("Tìm Kiếm Số Điện Thoại"));
		
		pnLoaiTimKiem.setOpaque(false);
		ButtonGroup grpRadTimKiem = new ButtonGroup();
		grpRadTimKiem.add(radMaTro);
		grpRadTimKiem.add(radDiaChi);
		grpRadTimKiem.add(radChuNha);
		grpRadTimKiem.add(radSdt);
		
		
		pnWrapTop.add(pnInput);
		pnWrapTop.add(pnLoaiTimKiem);
		
		//set font-size, color cho label, và size cho textfield

		Component[] compInput = pnInput.getComponents();
		for (Component component : compInput) {
			SetFont.set(component, new Font("", 0, 25), SetFont.LABEL);
			SetFont.set(component, new Dimension(300, 30), SetFont.TEXT_FIELD);
			SetFont.set(component, new Font("", 0, 14), SetFont.TEXT_FIELD);
			SetFont.set(component, Color.BLACK, SetFont.LABEL);
		}
			
		for (Component component : compInput)
			SetFont.set(component, lblSoDT.getPreferredSize(), SetFont.LABEL);
						
		Component[] radComponent = pnLoaiTimKiem.getComponents();
		for (Component rad: radComponent) {
			rad.setFont(new Font("", Font.PLAIN, 18));
			rad.setForeground(Color.BLACK);
		}
		
		//Hoàn tất, thêm wrapTop vào pnCenter
		pnCenter.add(pnWrapTop);
		
	//END-TOP
		
	//task
		JPanel pnTask = new JPanel(new FlowLayout(1, 0, 0));
		pnTask.setBackground(Color.decode("#C0C0C0"));
		
		
		pnTask.add(Box.createHorizontalStrut(10));
		pnTask.add(lblChiSo = new JLabel());

		
		pnTask.add(Box.createHorizontalStrut(50)); //khoảng cách
		
		pnTask.add(btnThem = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Thêm", 18, "#C0C0C0", "#29B6F6", "asset\\plus.png"));
		pnTask.add(btnXoa = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Xoá", 18, "#C0C0C0", "#29B6F6", "asset\\minus.png"));
		pnTask.add(btnSua = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Sửa", 18, "#C0C0C0", "#29B6F6", "asset\\edit.png"));
		pnTask.add(btnLuu = Button.myButtonUI(new Dimension(120, 55),JButton.CENTER, "Lưu", 18, "#C0C0C0", "#29B6F6", "asset\\database.png"));
		pnTask.add(btnXoaRong = Button.myButtonUI(new Dimension(150, 55),JButton.CENTER, "Xoá rỗng", 18, "#C0C0C0", "#29B6F6", "asset\\eraser.png"));
		pnTask.add(btnLamMoi = Button.myButtonUI(new Dimension(150, 55),JButton.CENTER, "Làm mới", 18, "#C0C0C0", "#29B6F6", "asset\\refresh.png"));
		pnTask.setPreferredSize(new Dimension(1355, 50));
		
		pnCenter.add(pnTask); //add to pnCenter


	//end-task
	//table
		String col[]= { "Mã trọ", "Địa chỉ", "Chủ trọ", "Số điện thoại"};
		dfTable = new DefaultTableModel(col, 0);
		
		tblInfo = new JTable(dfTable) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblInfo.getTableHeader().setFont(new Font("", Font.BOLD, 15));
		tblInfo.setFont(new Font("", 0, 15));

		modelSelect = tblInfo.getSelectionModel();
	    modelSelect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(null);
	    
		JScrollPane pnTable = new JScrollPane(tblInfo);
		pnTable.setPreferredSize(new Dimension(1155, 400));
		
		pnCenter.add(pnTable); //add to pnCenter

		
	//end-table
		pnCenter.setPreferredSize(new Dimension(1130, 900));
		add(pnCenter);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
	
		
		tblInfo.addMouseListener(this);
		
		DocDuLieuDatabaseVaoTable();
	}
	
	

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblInfo.getSelectedRow();
		txtMaTro.setText(dfTable.getValueAt(row, 0).toString());
		txtDiaChi.setText(dfTable.getValueAt(row, 1).toString());
		txtChuNha.setText(dfTable.getValueAt(row, 2).toString());
		txtSoDT.setText(dfTable.getValueAt(row, 3).toString());
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
			if(txtMaTro.getText().equals("") || txtDiaChi.getText().equals("") || txtChuNha.getText().equals("") || txtSoDT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu!");
				txtMaTro.requestFocus();
			}
			else {
				if(validData()) {
					String maTro = txtMaTro.getText();
					String diaChi = txtDiaChi.getText();
					String chuTro = txtChuNha.getText();
					String soDT = txtSoDT.getText();
					NhaTro nt = new NhaTro(maTro, diaChi, chuTro, soDT);
					try {
						if(nt_dao.them(maTro, diaChi, chuTro, soDT)) {
							dfTable.addRow(new Object[] {nt.getMaTro(), nt.getDiaChi(), nt.getChuTro(), nt.getSoDT()});
							txtMaTro.setText("");
							xoaRong();
						}
						else {
							JOptionPane.showMessageDialog(this, "Trùng mã trọ !");
							txtMaTro.requestFocus();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Error!");
						txtMaTro.requestFocus();
					}
				}
			}
		}
		
		
		else if (o.equals(btnXoaRong)) {
			xoaRong();
		}
		
		else if(o.equals(btnXoa)) {
			int r = tblInfo.getSelectedRow();
//			String maTro = dfTable.getValueAt(r, 0).toString();
			if(r != -1) {
				String maTro = (String)tblInfo.getModel().getValueAt(r, 0);
				int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Chú ý!", JOptionPane.YES_NO_OPTION);
				if(hoi == JOptionPane.YES_OPTION) {
					try {
						nt_dao.delete(maTro);
						dfTable.removeRow(r);
						txtMaTro.setText("");
						txtDiaChi.setText("");
						txtChuNha.setText("");
						txtSoDT.setText("");
						txtMaTro.requestFocus();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
			}
		}
		
		else if(o.equals(btnSua)) {
			int row = tblInfo.getSelectedRow();
			if(row != -1) {
				if(btnSua.getText().equalsIgnoreCase("Sửa")) {
					txtMaTro.setEditable(false);
					txtDiaChi.requestFocus();
					btnSua.setText("Hủy");
					btnThem.setEnabled(false);
					btnXoa.setEnabled(false);
					btnLamMoi.setEnabled(false);
				}
				else if (btnSua.getText().equalsIgnoreCase("Hủy")) {
					btnSua.setText("Sửa");
					txtMaTro.setEnabled(true);
					btnThem.setEnabled(true);
					btnXoa.setEnabled(true);
					btnLamMoi.setEnabled(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
			}
		}
		else if (o.equals(btnLuu)) {
			if(txtMaTro.getText().equals("") || txtDiaChi.getText().equals("") || txtChuNha.getText().equals("") || txtSoDT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ dữ liệu!");
				txtMaTro.requestFocus();
			}
			else {
				if(validData()) {
					update();
				}
			}
		}
		
		else if (o.equals(btnTim)) {
			if(radMaTro.isSelected()) {
				DocDuLieuTimMaTro();
			}
			
			else if (radDiaChi.isSelected()) {
				DocDuLieuTimDiaChi();
			}
			
			else if (radChuNha.isSelected()) {
				DocDuLieuTimChuTro();
			}
			
			else if (radSdt.isSelected()) {
				DocDuLieuTimSoDT();
			}
		}
		
		else if (o.equals(btnLamMoi)) {
			DocDuLieuDatabaseVaoTable();
		}
		
		
	}

	
	
	public void DocDuLieuDatabaseVaoTable() {
		List<NhaTro> list = nt_dao.loadNhaTroFromDatabase();
		dfTable.setRowCount(0);
		for (NhaTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaTro(),nt.getDiaChi(),nt.getChuTro(),nt.getSoDT()});
		}
	}
	
	public void xoaRong() {
//		txtMaTro.setText("");
		txtDiaChi.setText("");
		txtChuNha.setText("");
		txtSoDT.setText("");
		txtMaTro.requestFocus();
		txtMaTro.setText("");
	}
	
	public void doiDong(int row) {
		if (row >= 0) {
			txtMaTro.setText((String) tblInfo.getValueAt(row, 0));
			txtDiaChi.setText((String) tblInfo.getValueAt(row, 1));
			txtChuNha.setText((String) tblInfo.getValueAt(row, 2));
			txtSoDT.setText((String) tblInfo.getValueAt(row, 2));
		}
	}
	
	public void update() {
		int row = tblInfo.getSelectedRow();
		String maTro = dfTable.getValueAt(row, 0).toString();
		String diaChi = txtDiaChi.getText();
		String chuTro = txtChuNha.getText();
		String soDT = txtSoDT.getText();
		NhaTro nt = new NhaTro(maTro, diaChi, chuTro, soDT);
		try {
			nt_dao.update(nt, maTro);
			DocDuLieuDatabaseVaoTable();
			JOptionPane.showMessageDialog(this, "Thông tin nhà trọ đã được sửa!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void DocDuLieuTimMaTro() {
		String ma = txtTim.getText();
		List<NhaTro> list = nt_dao.getNhaTroTheoMaTro(ma);
		dfTable.setRowCount(0);
		for(NhaTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaTro(), nt.getDiaChi(), nt.getChuTro(), nt.getSoDT()});
		}
	}
	
	
	public void DocDuLieuTimDiaChi() {
		String diaChi = txtTim.getText();
		List<NhaTro> list = nt_dao.getNhaTroTheoDiaChi(diaChi);
		dfTable.setRowCount(0);
		for(NhaTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaTro(), nt.getDiaChi(), nt.getChuTro(), nt.getSoDT()});
		}
	}
	
	public void DocDuLieuTimChuTro() {
		String chuTro = txtTim.getText();
		List<NhaTro> list = nt_dao.getNhaTroTheoChuTro(chuTro);
		dfTable.setRowCount(0);
		for(NhaTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaTro(), nt.getDiaChi(), nt.getChuTro(), nt.getSoDT()});
		}
	}
	
	public void DocDuLieuTimSoDT() {
		String soDT = txtTim.getText();
		List<NhaTro> list = nt_dao.getNhaTroTheoSoDT(soDT);
		dfTable.setRowCount(0);
		for(NhaTro nt : list) {
			dfTable.addRow(new Object[] {nt.getMaTro(), nt.getDiaChi(), nt.getChuTro(), nt.getSoDT()});
		}
	}
	
	public boolean validData() {
		String maTro = txtMaTro.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String chuTro = txtChuNha.getText().trim();
		String soDT = txtSoDT.getText().trim();
		
		if(!(maTro.length() > 0 && maTro.matches("(MT)\\d{2}"))) {
			JOptionPane.showMessageDialog(this, "Error! : Mã trọ phải theo mẫu MT + 2 số!");
			txtMaTro.requestFocus();
			return false;
		}
		
		else if (!(diaChi.length() > 0 && diaChi.matches("^[0-9]*([\\s-][A-Z][a-z]+)*,\\sQ.([\\s][0-9a-zA-Z]+)*$"))) {
			JOptionPane.showMessageDialog(this, "Error! : Địa chỉ phải theo mẫu [Số nhà] [Tên đường], Q. [Tên Quận]!");
			txtDiaChi.requestFocus();
			return false;
		}
		
		else if (!(chuTro.length() > 0 && chuTro.matches("[a-zA-Z' ]+"))) {
			JOptionPane.showMessageDialog(this, "Error! : Tên Chủ trọ không được có kí tự đặc biệt!");
			txtChuNha.requestFocus();
			return false;
		}
		
		
		else if (!(soDT.length() > 0 && soDT.matches("(0)\\d{9}"))) {
			JOptionPane.showMessageDialog(this, "Error! : Số điện thoại phải bắt đầu bằng 0 và có 10 số!");
			txtSoDT.requestFocus();
			return false;
		}
		
		return true;
	}
	
	
}
