package ui;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import connectDB.ConnectDB;
import dao.dangNhap_dao;
import enity.DangNhap;


public class pnDangNhap extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private JTextField txtTaiKhoan;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private dangNhap_dao dn_dao;
	private JPasswordField txtMatKhau;
	private JLabel lblQuenMK;
	private JPopupMenu popUp;

	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnDangNhap frame = new pnDangNhap();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pnDangNhap() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Đăng nhập");
		setSize(560,521);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.GRAY);
		
		
		
//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//khai bao dao
		
		dn_dao = new dangNhap_dao();		
		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblTaiKhoan.setForeground(new Color(255, 255, 255));
		lblTaiKhoan.setBounds(61, 194, 112, 20);
		getContentPane().add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));

		txtTaiKhoan.setBounds(166, 188, 246, 33);
		getContentPane().add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setForeground(Color.WHITE);
		lblMatKhau.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblMatKhau.setBounds(61, 251, 112, 20);
		getContentPane().add(lblMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(166, 244, 246, 33);
		txtMatKhau.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtMatKhau.setBorder(BorderFactory.createLineBorder(new Color(217,132,219)));
		getContentPane().add(txtMatKhau);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(170, 116, 156, 39);
		getContentPane().add(lblNewLabel);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangNhap.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDangNhap.setBackground(new Color(164, 44,167));
		btnDangNhap.setBorder(new LineBorder(Color.WHITE, 2, true));
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBounds(166, 324, 176, 33);
		
		
		
		getContentPane().add(btnDangNhap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnThoat.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnThoat.setBackground(new Color(164, 44, 167));
		btnThoat.setBounds(166, 368, 176, 33);
		
		
		getContentPane().add(btnThoat);
		
//	
		
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 546, 493);
		getContentPane().add(lblBackground);
		Image imgBackground = Toolkit.getDefaultToolkit ().getImage(getClass().getResource("imgGradient.jpg"));
		Image resizeBackground = imgBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), 0);
		lblBackground.setIcon(new ImageIcon(resizeBackground));
		
		
		
		addMouseListener(new MouseAdapter() {
	         public void mouseReleased(MouseEvent me) {
	            showPopup(me); 
	         }
	    });
		
		
		txtTaiKhoan.setText("admin");
		txtMatKhau.setText("1234");
		
		
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		

		
		
		
	}
	
	 void showPopup(MouseEvent me) {
	      if(me.isPopupTrigger())
	         popUp.show(me.getComponent(), me.getX(), me.getY());
	   }

	
	//Kiểm tra đăng nhập
	@SuppressWarnings("deprecation")
	public void dangNhap() {
		
		String maTK = txtTaiKhoan.getText().toString().trim();
		String mk = txtMatKhau.getText().toString().trim();
		DangNhap tk = dn_dao.getTaiKhoanTheoMa(maTK);
		
		
		if(tk.getMaTK() == null) {
			JOptionPane.showMessageDialog(this, "Tài khoản không đúng!\nVui lòng kiểm tra lại.");
		}
		else if(!tk.getMatKhau().equalsIgnoreCase(mk)){
			JOptionPane.showMessageDialog(this, "Mật khẩu không đúng!\nVui lòng kiểm tra lại.");
		}
		else {
				this.setVisible(false);
				Gui gui = new Gui();
				gui.setVisible(true);
			}
		
		
		
		
	}
	
	//event
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			System.exit(0);
		}
		else if(o.equals(btnDangNhap)) {	
			
			dangNhap();
			
		}
		
		
		
		
	}
	
	
}
