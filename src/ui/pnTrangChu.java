package ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class pnTrangChu extends JPanel {
	private JTextField txtQunLNh;
	private JPanel panel,pnView;
	private JLabel lblBanner,lblTime;
	private Image img_banner = new ImageIcon(Gui.class.getResource("banner.jpg")).getImage().getScaledInstance(1000, 550, Image.SCALE_SMOOTH);

	/**
	 * Create the panel.
	 */
	public pnTrangChu() {
		setLayout(null);
		
		pnView = new JPanel();
		pnView.setBackground(new Color(240,240,240));
		pnView.setBounds(0, 0, 1095, 763);
		add(pnView);
		pnView.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(59, 35, 1002, 75);
		pnView.add(panel);
		panel.setLayout(null);
		
		txtQunLNh = new JTextField();
		txtQunLNh.setForeground(new Color(255, 0, 0));
		txtQunLNh.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtQunLNh.setText("Quản lí Nhà Trọ Sinh Viên");
		txtQunLNh.setHorizontalAlignment(SwingConstants.CENTER);
		txtQunLNh.setBounds(66, 0, 865, 75);
		panel.add(txtQunLNh);
		txtQunLNh.setColumns(10);
		time();
		lblTime = new JLabel(" ");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTime.setBounds(346, 120, 448, 54);
		pnView.add(lblTime);
		
		lblBanner = new JLabel(" ");
		lblBanner.setBounds(61, 202, 1000, 550);
		lblBanner.setIcon(new ImageIcon(img_banner));
		pnView.add(lblBanner);

	}
	 Timer t;
		SimpleDateFormat st;
	public void time() {
		
		t = new Timer(0,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	        
	        Date dt  =new Date();
	        st = new SimpleDateFormat("hh:mm:ss a");	
	        String tt = st.format(dt);
	        lblTime.setText(tt);
	        
	        }
	    });
	  
	    t.start();
	  		
	}
}
