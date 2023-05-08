package giaoDien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Button {
	public static JButton myButtonUI (Dimension dim, int horialign, String name, int font, String hexColor, String hexColorHover, String iconPath) {

		JButton btn = new JButton(name);
		btn.setOpaque(true);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		

		btn.setHorizontalAlignment(horialign);
		btn.setVerticalAlignment(JLabel.CENTER);
		
		btn.setFont(new Font("Roboto", Font.BOLD, font));
		if (dim != null)
		btn.setPreferredSize(dim);

		btn.setBackground(Color.decode(hexColor));
		btn.setForeground(Color.WHITE);
		if (!iconPath.equals(""))
			btn.setIcon(new ImageIcon(iconPath));
		
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(Color.decode(hexColorHover));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(Color.decode(hexColor));
			}
		});
		return btn;
	}
}
