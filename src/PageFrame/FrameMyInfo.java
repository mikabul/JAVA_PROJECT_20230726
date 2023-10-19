package PageFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Cocktail;
import Database.MyCocktail;
import GUI.CreateUI;
import GUI.FontManager;
import GUI.ImageSelector;

public class FrameMyInfo extends JPanel implements CreateUI {

	JButton previous_button, cart_button, preBtn;
	JLabel profile, profileText, preLabel;
	MyCocktail mycocktail;
	Vector<Cocktail> cocktail;
	ImageIcon preImg;
	Image background_image;
	
	ImageIcon prev, basket;
	public FrameMyInfo() {

		
		
		prev = new ImageIcon("Resources\\UI_Image\\previous.png");
		basket = new ImageIcon("Resources\\UI_Image\\basket.png");
		
		setSize(1200, 900);
		setLayout(null);
		setBackground(Color.white);
		ImageSelector imgSet = new ImageSelector();

		cocktail = new PreferenceCocktail().Preference();

		ImageIcon profileImage = new ImageIcon("Resources\\defaultProfile.jpg");
		profileImage = imgSet.imageSetSize(profileImage, 200, 200);

		profile = createImageLabel(profileImage, FontManager.labelFont, getWidth() / 2 - 500, getHeight() - 850, 256,
				256);
		profileText = createTextLabel(new MyCocktail().toString(), FontManager.labelFont, getWidth() / 2 - 200,
				getHeight() - 900, 1000, 256);

		preBtn = new JButton();
		preBtn.setBounds(getWidth() / 2 - 200, 300, 400, 100);
		preBtn.setBackground(null);
		preBtn.setBorder(null);

		Thread Tbtn = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					for (int i = 0; i < cocktail.size(); i++) {

						preImg = new ImageSelector().imageSelctor(cocktail.get(i).getcName());
						preImg = new ImageSelector().imageSetSize(preImg, 100, 100);
						preBtn.setIcon(preImg);
						preBtn.setText(cocktail.get(i).getString());
						preBtn.setBackground(Color.black);
						preBtn.setForeground(Color.white);
						preBtn.setBorder(null);
						preBtn.setActionCommand(cocktail.get(i).getcName());

						try {
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		//추천 칵테인 버튼액션 추가
		preBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//액션커맨드를 이용하여 페이지 이동
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameCocktailInfo(e.getActionCommand()));
			}
		});
		//쓰레드 데몬설정, 작동
		Tbtn.setDaemon(true);
		Tbtn.start();

		add(preBtn);

		preLabel = createTextLabel("추천 칵테일", new Font("함초롱돋움 보통", Font.BOLD, 60), preBtn.getX(), preBtn.getY() - 70,
				500, 50);

		previous_button = createImageButton(prev, FontManager.btnFont, 0, getHeight() - 155, 120, 120,"이전");
		previous_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMain());
			}
		});

		cart_button = createImageButton(basket, FontManager.btnFont, getWidth() / 2 - 200, getHeight() / 2, 300, 100,"장바구니");

		cart_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameBasket());

			}
		});
	}

	@Override
	public JButton createTextButton(String btn_name, Font font, int x, int y, int width, int height) {
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
		add(label);
		return label;
	}

	@Override
	public JButton createImageButton(ImageIcon icon, Font font, int x, int y, int width, int height, String setActCmd) {
		JButton button = new JButton(icon);
		button.setFont(font);
		button.setBounds(x, y, width, height);
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

	public JButton createImageButton(ImageIcon icon, Font font, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintComponent(Graphics g) {
		background_image = new ImageIcon("Resources\\cocktail_bar.png").getImage();
		g.drawImage(background_image, 0, 0, null);
	}

}
