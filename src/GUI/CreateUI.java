package GUI;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public interface CreateUI {
	
	JButton createTextButton(String btn_name, Font font, int x, int y, int width, int height);
	
	JButton createImageButton(ImageIcon icon,Font font, int x, int y, int width, int height,String setActCmd);

	JLabel createTextLabel(String label_name,Font font, int x, int y, int width, int height);
	
	JLabel createImageLabel(ImageIcon icon,Font font, int x, int y, int width, int height);
	
	
}
