package PageFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import GUI.CreateUI;
import GUI.FontManager;
import GUI.ImageSelector;


public class FrameMain extends JPanel implements CreateUI{
	
	JLabel today_text; 
	ImageIcon day_img, my_icon, search_icon;
	Image background_image;
	
	String action;
	JButton btn1, btn2,today_cocktail;
	
	public FrameMain() {
		if(day_img == null) {
			initDayImage();					
		}
		
		my_icon = new ImageIcon("Resources\\UI_Image\\mypage.png");
		search_icon = new ImageIcon("Resources\\Cocktailbar.png");
		search_icon = new ImageSelector().imageSetSize(search_icon, 100,100);
		
		setLayout(null);
		setSize(1200, 900);	
		setBackground(Color.red);
		today_cocktail = createImageButton(day_img, FontManager.labelFont, getWidth()/2-128, 250, 256, 256,action);
		today_cocktail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameCocktailInfo(action));
			}
		});
		
		today_text = createTextLabel("☆오늘의 추천 칵테일!☆", FontManager.labelFont, 
				getWidth()/2-140, 400, 320, 256);
		
		btn1 = createImageButton(my_icon, FontManager.btnFont, 0, getHeight()-150, 600, 120,"마이페이지");
		btn2 = createImageButton(search_icon, FontManager.btnFont, getWidth()/2, getHeight()-150, 600, 120,"검 색");
		

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMyInfo());
			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameSix());
			}
		});
	}
	
	private void initDayImage() {
		
		Date currentDate = new Date();
		SimpleDateFormat date = new SimpleDateFormat("E");
		String day = date.format(currentDate);
		
		switch(day) {
		case "월":
			day_img = new ImageSelector().imageSelctor("베르무트");
			action = "베르무트";
			break;	
		case "화":
			day_img = new ImageSelector().imageSelctor("마티니");
			action = "마티니";
			break;
		case "수":
			day_img = new ImageSelector().imageSelctor("블랙러시안");
			action = "블랙러시안";
			break;
		case "목":
			day_img = new ImageSelector().imageSelctor("위스키콕");
			action = "위스키콕";
			break;
		case "금":
			day_img = new ImageSelector().imageSelctor("깔루아밀크");
			action = "깔루아밀크";
			break;
		case "토":
			day_img = new ImageSelector().imageSelctor("피나콜라다");
			action = "피나콜라다";
			break;
		case "일":
			day_img = new ImageSelector().imageSelctor("시브리즈");
			action = "시브리즈";
			break;
		}
		
	}
	
	@Override
	public JButton createTextButton(String btnName, Font font, int x, int y, int width, int height) {
		JButton button = new JButton(btnName);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setBackground(Color.LIGHT_GRAY);
	    Border border = new LineBorder(Color.black, 1);
	    button.setBorder(border);
	    add(button);
	    return button;
	}
	
	@Override
	public JLabel createTextLabel(String label_name, Font font, int x, int y, int width, int height) {
		JLabel label = new JLabel(label_name);
		label.setFont(font);
	    label.setBounds(x, y, width, height);
	    label.setForeground(Color.black);
	    add(label);
	    return label;
	}
	
	@Override
	public JButton createImageButton(ImageIcon icon, Font font, int x, int y, int width, int height,String setActCmd) {
		JButton button = new JButton(icon);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setActionCommand(setActCmd);
	    button.setBackground(null);
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
//	public static void main(String[] args) {
//		FrameMain m = new FrameMain();
//		m.initDayImage();
//	}
	
}
















