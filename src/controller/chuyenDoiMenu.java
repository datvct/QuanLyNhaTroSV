package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import danhMuc.DanhMuc;
import menu.MenuItem;
import ui.pnChiTietHD;
import ui.pnDichVu;
import ui.pnHoaDon;
import ui.pnHopDong;
import ui.pnNhaTro;
import ui.pnPhongTro;
import ui.pnSinhVien;
import ui.pnTKSinhVien;
import ui.pnTrangChu;


public class chuyenDoiMenu {
	private JPanel root;
	private String kinSelected ="";
	
	private List<DanhMuc> listItem=null;
	
	public chuyenDoiMenu(JPanel jpnRoot) {
		this.root=jpnRoot;
	}
	public void setView(MenuItem menu) {
		kinSelected = "trangChu";
		
		menu.setBackground(new Color(96,100,191));
		root.removeAll();
		root.setLayout(new BorderLayout());
		root.add(new pnTrangChu());
		root.validate();
		root.repaint();
		
	}
	public void setEvent(List<DanhMuc> listItem) {
		this.listItem=listItem;
		for (DanhMuc item : listItem) {
			item.getMenu().addMouseListener(new LabelEvent(item.getKind(),item.getMenu()));
		}
	}
	public class LabelEvent implements MouseListener{
		private JPanel node;
		private String kind;
		private JPanel jpnItem;
		private MenuItem menu;

		public LabelEvent(String kind, MenuItem menu) {
			this.kind = kind;
			this.menu = menu;
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			menu.setBackground(new Color(0, 128, 64));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(!kinSelected.equalsIgnoreCase(kind)) {
				menu.setBackground(new Color(192, 192, 192));
			}
		}
		private void setChangeBackground(String kind) {
			for (DanhMuc item : listItem) {
				if(item.getKind().equalsIgnoreCase(kind)) {
					item.getMenu().setBackground(new Color(11, 168, 181));	
				}
				else {
					item.getMenu().setBackground(new Color(192, 192, 192));
				}
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(kind) {
			case "TrangChu":
				node= new pnTrangChu();
				break;
			case "sinhVien":
				node= new pnSinhVien();
				break;
			case "phongTro":
				node= new pnPhongTro();
				break;
			case "hoaDon":
				node= new pnHoaDon();
				break;
			case "qlHD":
				node= new pnHopDong();
				break;
			case "timKiemSV":
				node= new pnTKSinhVien();
				break;
			case "nhaTro":
				node= new pnNhaTro();
				break;
			case "chiTietHD":
				node= new pnChiTietHD();
				break;
			case "dichVu":
				node= new pnDichVu();
				break;
			default:
				node = new pnTrangChu();
				break;
			}
			root.removeAll();
			root.setLayout(new BorderLayout());
			root.add(node);
			root.validate();
			root.repaint();
			setChangeBackground(kind);
		}
	}
}
