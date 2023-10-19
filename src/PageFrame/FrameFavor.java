package PageFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Cocktail;
import Database.CocktailDAO;
import Event.ButtonEventManager_Info;
import GUI.CreateUI;
import GUI.FontManager;
import GUI.ImageSelector;
import PageFrame.FrameBase;
import PageFrame.FrameMain;
import PageFrame.FrameSix;

public class FrameFavor extends JPanel implements CreateUI{
	
	Image background_image;
	ArrayList<Cocktail> cocktail;
	JButton[] favor_btn;
	JLabel[] des_label;
	ImageIcon prev_icon, main_icon;
	JButton previous_button, main_page_button;
	
	public FrameFavor(String str) {
		
		setSize(1200,900);
		setLayout(null);
		setBackground(Color.red);
		
		prev_icon = new ImageIcon("Resources\\UI_Image\\previous.png");
		main_icon = new ImageIcon("Resources\\UI_Image\\Home100.png");
		cocktail = new ArrayList<Cocktail>();
		
		Iterator<Cocktail> it = CocktailDAO.getTreeMap().keySet().iterator();
		
		while(it.hasNext()) {
			Cocktail ct = it.next();
			
			if(ct.getFavor().equals(str)) {
				cocktail.add(ct);
			}
		}
		
		favor_btn = new JButton[cocktail.size()];
		des_label = new JLabel[cocktail.size()];
		
		int x  = 30,y = 0;
		for(int i = 0;i < cocktail.size();i++) {
			favor_btn[i] = createImageButton(new ImageSelector().imageSelctor(cocktail.get(i).getcName()),
					FontManager.btnFont, getWidth()/2-400, getHeight()-800+y, 256, 256, cocktail.get(i).getcName());
			
			des_label[i] = createTextLabel(cocktail.get(i).toString(), FontManager.labelFont, favor_btn[i].getX()+favor_btn[i].getWidth()+x
					, favor_btn[i].getY(), 400, 256);
			des_label[i].setForeground(Color.black);
			favor_btn[i].addActionListener(new ButtonEventManager_Info());
			y+=400;
		}
		
		previous_button = createImageButton(prev_icon, FontManager.btnFont, 0, getHeight() - 155, 120, 120,"이전");
		previous_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameSix());
			}
		});
		
		main_page_button = createImageButton(main_icon, FontManager.btnFont, 1065, getHeight() - 150, 120, 120,"처음으로");
		main_page_button.addActionListener(new ActionListener() {

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
	    button.setBackground(Color.black);
	    button.setBorder(null);
	    add(button);
	    return button;
	}
	@Override
	public JLabel createTextLabel(String label_name, Font font, int x, int y, int width, int height) {
		JLabel label = new JLabel(label_name);
		label.setFont(font);
	    label.setBounds(x, y, width, height);
	    label.setForeground(Color.white);
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
	    label.setForeground(Color.white);
	    add(label);
	    return label;
	}
	public void paintComponent(Graphics g) {
		background_image = new ImageIcon("Resources\\cocktail_bar.png").getImage();
        g.drawImage(background_image, 0, 0, null);
    }
}
