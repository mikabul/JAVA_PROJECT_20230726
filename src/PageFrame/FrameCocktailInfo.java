package PageFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Cocktail;
import Database.CocktailDAO;
import Database.Ingredients;

public class FrameCocktailInfo extends JPanel{
	
	
	ImageIcon buytab, retry, Home200;
	Image background_image;
	
	public FrameCocktailInfo(String str) {
		
		// 제이패널 구조
		setLayout(null);
		setSize(1200,900);
		
		buytab = new ImageIcon("Resources\\UI_Image\\buytab.png");
		retry = new ImageIcon("Resources\\UI_Image\\retry.png");
		Home200 = new ImageIcon("Resources\\UI_Image\\Home200.png");
		
		
		// 포스터 부분
		final int cocktailNum = 12;
		int cocktailflag = 0;
		String[] cocktailurl = {
				"Resources\\dry\\Martini.jpg",		"Resources\\dry\\Vermouth.jpg", 
				"Resources\\fruit\\MidoriSour.jpg",	"Resources\\fruit\\SeaBreeze.jpg",
				"Resources\\hot\\BlackRussian.jpg",	"Resources\\hot\\WhiskyCoke.jpg",
				"Resources\\refresing\\Cosmopolitan.jpg",	"Resources\\refresing\\Grasshopper.jpg",
				"Resources\\smoothie\\PinaColada.jpg",	"Resources\\smoothie\\Daiquiri.jpg",
				"Resources\\sweet\\Kahlua Milk.jpg",	"Resources\\sweet\\Margarita.jpg"};
		
		ImageIcon[] cocktailImg = new ImageIcon[cocktailNum];
		
		for(int i=0; i<cocktailNum; i++) {
			cocktailImg[i] = new ImageIcon(cocktailurl[i]);
			
			if(str.equals("마티니")) {
				cocktailflag = 0;
			}else if(str.equals("베르무트")) {
			cocktailflag = 1;
			}else if(str.equals("미도리샤워")) {
				cocktailflag = 2;
			}else if(str.equals("시브리즈")) {
			cocktailflag = 3;
			}else if(str.equals("블랙러시안")) {
				cocktailflag = 4;
			}else if(str.equals("위스키콕")) {
			cocktailflag = 5;
			}else if(str.equals("코스모폴리탄")) {
				cocktailflag = 6;
			}else if(str.equals("그래스호퍼")) {
			cocktailflag = 7;
			}else if(str.equals("피나콜라다")) {
				cocktailflag = 8;
			}else if(str.equals("다이키리")) {
			cocktailflag = 9;
			}else if(str.equals("깔루아밀크")) {
				cocktailflag = 10;
			}else if(str.equals("마가리타")) {
			cocktailflag = 11;
			}
		}//for문
		
		//이미지를 제이라벨에 붙여서 출력
		JLabel img = new JLabel(cocktailImg[cocktailflag]);
		img.setBounds(430,13,300,350);
		add(img);
		
		//칵테일 이름, 재료, 레시피 등등
		
		Iterator<Cocktail> it = CocktailDAO.getTreeMap().keySet().iterator();
		
		while(it.hasNext()) {
			Cocktail key = it.next();
			if(key.getcName().equals(str)) {
				Ingredients ing = CocktailDAO.getTreeMap().get(key);
				TextArea story = new TextArea(
						"\n칵테일 이름 : " + key.getcName() + 
						"\n\n\n재료 : " + ing.getiName() +
						"\n\n\n레시피 : " + ing.getRecipe() +
						"\n\n\n\n\n\n추천 안주 : " + key.getSideMenu()
						, 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
				story.setSize(1180,395);
				story.setLocation(0,375);
				story.setBackground(new Color(224,224,224));
				story.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
				add(story);
			}
		}
		
	
	//하단 버튼
	JPanel bottomSet = new JPanel();
	
	bottomSet.setBounds(0, 770, 1200, 100);
	bottomSet.setLayout(null);
	bottomSet.setBackground(Color.white);
	
	//다시고르기
	JButton btnBack = new JButton(retry);
	btnBack.setBackground(Color.WHITE);
	btnBack.setOpaque(false);
	btnBack.setSize(200, 100);
	btnBack.setLocation(0, 0);
	bottomSet.add(btnBack);

	btnBack.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FrameBase.disposeInstance();
			FrameBase.getInstance(new FrameSix());
		}
	});
	
	JButton btnselect = new JButton(buytab);
	btnselect.setBackground(Color.WHITE);
	btnselect.setOpaque(false);
	btnselect.setSize(200, 100);
	btnselect.setLocation(500, 0);
	bottomSet.add(btnselect);

	btnselect.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			FrameBase.disposeInstance();
			FrameBase.getInstance(new FrameShop(str));
		}
	});
	
	
	//처음으로 버튼
	JButton btnHome = new JButton(Home200);

	btnHome.setBackground(Color.white);
	btnHome.setOpaque(false);
	btnHome.setSize(200, 100);
	btnHome.setLocation(990, 0);
	bottomSet.add(btnHome);

	btnHome.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			FrameBase.disposeInstance();
			FrameBase.getInstance(new FrameMain());
		}
	});
	
	add(bottomSet, BorderLayout.SOUTH);
		
				
	}//생성자
	
	public void paintComponent(Graphics g) {
		background_image = new ImageIcon("Resources\\cocktail_bar.png").getImage();
        g.drawImage(background_image, 0, 0, null);
    }
	
}//클래스