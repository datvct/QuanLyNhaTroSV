package ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.chuyenDoiMenu;
import danhMuc.DanhMuc;
import menu.MenuItem;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame  implements ActionListener{

	private JPanel PanelALL;
	private Image img_logo = new ImageIcon(Gui.class.getResource("logo.png")).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
	private Image img_logout = new ImageIcon(Gui.class.getResource("exit.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	
	private JPanel menus, pnMenu,pnBody;
	private JScrollPane scrollPane;
	private JLabel pnLogo;
	private MenuItem menuTC,menuTro1,menuTro2, menuTro, menuHoaDon,menuHoaDon1,menuHoaDon2,menuHopDong,menuSV1,menuSV2,menuSV,menuHopDong1,menuHopDong2;
	private JButton btnSignOut;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// 	EventQueue.invokeLater(new Runnable() {
	// 		public void run() {
	// 			try {
	// 				Gui frame = new Gui();
	// 				frame.setVisible(true);
	// 			} catch (Exception e) {
	// 				e.printStackTrace();
	// 			}
	// 		}
	// 	});
	// }

	
	public Gui() {
		gui();
		execute();
		chuyenDoiMenu controller = new chuyenDoiMenu(pnBody);
		controller.setView(menuTC);
		List<DanhMuc> listItem = new ArrayList<>();
		listItem.add(new DanhMuc("TrangChu", menuTC));
		listItem.add(new DanhMuc("sinhVien", menuSV1));
		listItem.add(new DanhMuc("phongTro", menuTro1));
		listItem.add(new DanhMuc("timKiemSV", menuSV2));
		listItem.add(new DanhMuc("nhaTro", menuTro2));
		listItem.add(new DanhMuc("qlHD", menuHopDong1));
		listItem.add(new DanhMuc("chiTietHD", menuHopDong2));
//		listItem.add(new DanhMuc("hoaDon", menuHoaDon1));

		controller.setEvent(listItem);
    	setSize(1400,800);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public void gui() {
		setBounds(100, 100, 1400, 800);
		PanelALL = new JPanel();
		PanelALL.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelALL);
		PanelALL.setLayout(null);
		
		pnMenu = new JPanel();
		pnMenu.setBackground(new Color(128, 128, 128));
		pnMenu.setBounds(0, 0, 260, 763);
		PanelALL.add(pnMenu);
		pnMenu.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 121, 260, 572);
		scrollPane.setBorder(null);
		pnMenu.add(scrollPane);
		
		menus = new JPanel();
		menus.setBackground(new Color(192, 192, 192));

		scrollPane.setViewportView(menus);
		menus.setLayout(new BoxLayout(menus, BoxLayout.Y_AXIS));
		
		pnLogo = new JLabel(" ");
		pnLogo.setBounds(32, 11, 201, 100);
		pnLogo.setIcon(new ImageIcon(img_logo));
		pnMenu.add(pnLogo);
		
		
		btnSignOut = new JButton("Sign Out", new ImageIcon(img_logout));
    	btnSignOut.setFont(new Font("Arial", Font.BOLD, 18));		
    	btnSignOut.setBackground(Color.white);
    	btnSignOut.setForeground(Color.BLACK);
    	btnSignOut.setBounds(10, 722, 240, 31);
    	btnSignOut.setHorizontalAlignment(SwingConstants.CENTER);
 
		pnMenu.add(btnSignOut);
		
		pnBody = new JPanel();
		pnBody.setBounds(259, 0, 1115, 763);
		
		
		
		btnSignOut.addActionListener(this);
		PanelALL.add(pnBody);
		
		
	}
	
	private void execute()
	{
		ImageIcon iconsv = new ImageIcon(getClass().getResource("students.png"));
		ImageIcon icontro = new ImageIcon(getClass().getResource("house.png"));
		ImageIcon iconhopDong= new ImageIcon(getClass().getResource("hopdong.png"));
		ImageIcon iconhoaDon = new ImageIcon(getClass().getResource("hoadon.png"));
		ImageIcon subMenu = new ImageIcon(getClass().getResource("next.png"));
		ImageIcon imgHome = new ImageIcon(getClass().getResource("home.png"));
		menuTC = new MenuItem(imgHome, "Trang Chủ");
		
		menuSV1 = new MenuItem(subMenu, "Quản lí sinh viên");
		menuSV2 = new MenuItem(subMenu, "Tìm kiếm Sinh Viên");
		menuSV = new MenuItem(iconsv, "Sinh Viên",menuSV1,menuSV2	);
		
		
		menuTro1 = new MenuItem(subMenu, "Quản lí phòng trọ");
		menuTro2 = new MenuItem(subMenu, "Quản lí nhà trọ");
		menuTro = new MenuItem(icontro, "Phòng Trọ", menuTro1,menuTro2);
		menuHopDong1 = new MenuItem(subMenu, "Quản lí HĐ");
		menuHopDong2 = new MenuItem(subMenu, "Chi tiết HĐ");
		menuHopDong = new MenuItem(iconhopDong, "Hợp đồng",menuHopDong1,menuHopDong2);
		menuHoaDon1 = new MenuItem(subMenu, "Hóa đơn");
		menuHoaDon2 = new MenuItem(subMenu, "Dịch vụ");
		menuHoaDon = new MenuItem(iconhoaDon, "Hóa đơn", menuHoaDon1, menuHoaDon2);
		addMenu(menuTC,menuSV,menuTro,menuHopDong);
	}
	private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
        	menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnSignOut)) {
			System.exit(0);
		}
	}
}
