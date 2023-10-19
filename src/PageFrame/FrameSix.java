package PageFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Event.FrameBtnAction;
import GUI.CreateUI;
import GUI.FontManager;

public class FrameSix extends JPanel implements CreateUI{

	JButton[] jB;
	JButton previous_button;
	ImageIcon[] img;
	ImageIcon prev_icon;
	String[] str;
	Color[] col;
	JLabel bottomLabel;
	int margin;
	Image background_image;

	public FrameSix() {
		
		final int favor_of_drinks = 6;
		setSize(1200, 900);
		setLayout(null);
		setBackground(null);

		Dimension btnDim = new Dimension(260,250);
		int btnX = 0;
		int btnY = 0;

		margin = 50;
		str = new String[] { "dry", "fruit", "hot", "refresing", "smoothie", "sweet" };
		col = new Color[] { Color.decode("#ADFF2F"), Color.cyan, Color.decode("#B22222"), Color.decode("#32CD32"),Color.black, Color.decode("#DB7093")};
		jB = new JButton[favor_of_drinks];
		img = new ImageIcon[favor_of_drinks];
		
		for (int i = 0; i < favor_of_drinks; i++) {
			img[i] = new ImageIcon("Resources\\" + str[i] + ".png");
			Image temp = img[i].getImage();
			img[i] = new ImageIcon(temp.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
			jB[i] = new JButton(str[i], img[i]);
			jB[i].setBackground(Color.GREEN);
			jB[i].setBounds(200 + btnX, 300 + btnY, btnDim.width, btnDim.height);
			jB[i].setVerticalTextPosition(JButton.BOTTOM);
			jB[i].setHorizontalTextPosition(JButton.CENTER);
			jB[i].setFont(FontManager.btnFont);
			jB[i].setForeground(col[i]);
			jB[i].setBorderPainted(false);
			jB[i].setOpaque(false);
			jB[i].addActionListener(new FrameBtnAction());
			add(jB[i]);
			btnX += btnDim.width;
			
			if(i == 2) {
				btnX = 0;
				btnY += btnDim.height;
			}
		}
		
		bottomLabel = createTextLabel("★좋아하는 맛을 골라주세요★", FontManager.labelFont, getWidth()/2-180, 100, 500, 200);
		//previous_button = createTextButton("이전", FontManager.btnFont, 0, getHeight()-130, 100, 100);
		
		prev_icon = new ImageIcon("Resources\\UI_Image\\previous.png");
		
		previous_button = createImageButton(prev_icon,FontManager.btnFont,0,getHeight()-155,120,120,"이전");
		previous_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMain());
			}
		});
	}
	
	@Override
	public JButton createTextButton(String btn_name, Font font,int x, int y,int width,int height) {
	    JButton button = new JButton(btn_name);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setBackground(Color.LIGHT_GRAY);
	    button.setBorder(null);
	    add(button);
	    return button;
	}
	@Override
	public JLabel createTextLabel(String label_name, Font font, int x, int y, int width, int height) {
		JLabel label = new JLabel(label_name);
		label.setFont(font);
	    label.setBounds(x, y, width, height);
	    label.setForeground(Color.decode("#000000"));
	    add(label);
	    return label;
	}
	@Override
	public JButton createImageButton(ImageIcon icon, Font font, int x, int y, int width, int height,String setActCmd) {
		JButton button = new JButton(icon);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setActionCommand(setActCmd);
	    button.setBackground(Color.white);
	    button.setOpaque(false);
	    add(button);
	    return button;
	}
	@Override
	public JLabel createImageLabel(ImageIcon icon, Font font, int x, int y, int width, int height) {
		JLabel label = new JLabel(icon);
		label.setFont(font);
	    label.setBounds(x, y, width, height);
	    add(label);
	    return label;
	}
	
	public void paintComponent(Graphics g) {
		background_image = new ImageIcon("Resources\\cocktail_bar.png").getImage();
        g.drawImage(background_image, 0, 0, null);
    }
}