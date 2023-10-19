package PageFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Event.ButtonEventManager_Prefer;
import GUI.CreateUI;
import GUI.FontManager;

public class FramePreference extends JPanel implements CreateUI{
	
	boolean isHotChecked = false;
	boolean isSweetChecked = false;
	

	JLabel title, question1, question2;
	Image background_image;
	JButton sweet_like_button, sweet_dislike_button, hot_like_button, hot_dislike_button, nextButton;
	ImageIcon title_image,question1_image,question2_image,yes,no;
	
	
	
	public FramePreference() {
		
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		setSize(1200,900);
		
		title_image = new ImageIcon("Resources\\UI_Image\\title.png");
		question1_image = new ImageIcon("Resources\\UI_Image\\isSweet.png");
		question2_image = new ImageIcon("Resources\\UI_Image\\isHot.png");
		yes = new ImageIcon("Resources\\UI_Image\\Yes.png");
		no = new ImageIcon("Resources\\UI_Image\\No.png");
		title = createImageLabel(title_image, FontManager.titleFont, getWidth()/2-240, 80, 450, 100);
		question1 = createImageLabel(question1_image, FontManager.questionFont, getWidth()/2-150, 200, 300, 100);
		question2 = createImageLabel(question2_image, FontManager.questionFont, getWidth()/2-150, 450, 300, 100);
		
		sweet_like_button = createImageButton(yes, FontManager.preferFont, question1.getX()-220, 300, 300, 100,"단게좋아");
		sweet_like_button.addActionListener(new ButtonEventManager_Prefer());
		
		sweet_dislike_button = createImageButton(no, FontManager.preferFont, question1.getX()+220
				, sweet_like_button.getY(), 300, 100,"단게싫어");
		sweet_dislike_button.addActionListener(new ButtonEventManager_Prefer());
		
		hot_like_button = createImageButton(yes, FontManager.preferFont, question2.getX()-220, 
				question2.getY() + 100, 300, 100,"취할래요");
		hot_like_button.addActionListener(new ButtonEventManager_Prefer());
		
		hot_dislike_button = createImageButton(no, FontManager.preferFont, question2.getX()+220, hot_like_button.getY(),
				300, 100,"안취할래요");
		hot_dislike_button.addActionListener(new ButtonEventManager_Prefer());
		
		nextButton = createTextButton("완 료", FontManager.preferFont, 850, 700, 300, 100);		
		nextButton.addActionListener(new ButtonEventManager_Prefer());
	}
	
	@Override
	public JButton createTextButton(String btn_name, Font font,int x, int y,int width,int height) {
	    JButton button = new JButton(btn_name);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setBorder(null);
	    button.setBackground(Color.LIGHT_GRAY);
	    button.setOpaque(false);
	    add(button);
	    return button;
	}
	@Override
	public JLabel createTextLabel(String label_name, Font font, int x, int y, int width, int height) {
		JLabel label = new JLabel(label_name);
		label.setFont(font);
	    label.setBounds(x, y, width, height);
	    label.setForeground(Color.cyan);
	    
	    add(label);
	    return label;
	}
	@Override
	public JButton createImageButton(ImageIcon icon, Font font, int x, int y, int width, int height,String setActCmd) {
		JButton button = new JButton(icon);
	    button.setFont(font);
	    button.setBounds(x, y, width, height);
	    button.setActionCommand(setActCmd);
	    button.setBorder(null);
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
}
