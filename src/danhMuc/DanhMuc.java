package danhMuc;

import javax.swing.JLabel;
import javax.swing.JPanel;

import menu.MenuItem;

public class DanhMuc {

	private String kind;
	private MenuItem menu;
	public DanhMuc() {
		super();
	}
	public DanhMuc(String kind, MenuItem menu) {
		super();
		this.kind = kind;
		this.menu = menu;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public MenuItem getMenu() {
		return menu;
	}
	public void setMenu(MenuItem menu) {
		this.menu = menu;
	}


	
	
	
}
