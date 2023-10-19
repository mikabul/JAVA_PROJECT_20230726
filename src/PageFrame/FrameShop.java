package PageFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.Basket;
import Database.Cocktail;
import Database.CocktailDAO;
import Database.Ingredients;
import Database.MyCocktail;
import Event.ButtonEventManager_Shop;
import GUI.CreateUI;
import GUI.FontManager;
import GUI.ImageSelector;

public class FrameShop extends JPanel implements CreateUI{
	
	String btnAct;
	String iName;
	Ingredients ingredients;
	
	JButton[] btn;
	ImageIcon prev, pay, buy,minus;
	JButton previous_button,basket_Button;
	JLabel[] label;
	Image background_image;
	int iPrice;
	 Thread tCount;
	
	JLabel[] shopBag;
	Boolean bool = false;
	
	
	public FrameShop() {
		
	}
	
	public FrameShop(String str) {
		
		prev = new ImageIcon("Resources\\UI_Image\\previous.png");
		pay = new ImageIcon("Resources\\UI_Image\\pay.png");
		buy = new ImageIcon("Resources\\UI_Image\\buybtn.png");
		minus = new ImageIcon("Resources\\UI_Image\\minusbtn.png");
		
		
		setSize(1200, 900);
		setLayout(null);
		setBackground(null);
		
		
		
		Iterator<Cocktail> it = CocktailDAO.getTreeMap().keySet().iterator();
		
		while(it.hasNext()) {
			
			Cocktail key = it.next();
			
			if(key.getcName().equals(str)) {
				ingredients = CocktailDAO.getTreeMap().get(key);
			}
		}
		
		btn = new JButton[ingredients.getiName().size()*2];
		label = new JLabel[ingredients.getiName().size()*2];
		shopBag = new JLabel[ingredients.getiName().size()];
		Dimension dim = new Dimension(100,100);
		int j = 0;
		
		

        for(int i = 0; i < ingredients.getiName().size() * 2; i += 2) {
            label[i] = createImageLabel(new ImageSelector().imageSelctor(ingredients.getiName().get(j)), FontManager.labelFont, 50, 50 + (int)(dim.height * i/1.3),
                    dim.width, dim.height);
            label[i + 1] = createTextLabel("<HTML>"+ingredients.getiName().get(j) + "<br>" +
                    ingredients.getPrice().get(j) + "원</HTML>", FontManager.labelFont,
                    label[i].getX() + (int)dim.getWidth(),
                    label[i].getY(), 200, 100);
            label[i+1].setForeground(Color.black);
            btn[i] = createImageButton(buy, FontManager.btnFont, label[i+1].getX()+label[i+1].getWidth(),
                    label[i].getY(), 80, 40,"추가");
            btn[i].setActionCommand(ingredients.getiName().get(j));

            btn[i + 1] = createImageButton(minus, FontManager.btnFont, label[i+1].getX()+label[i+1].getWidth(),
                        label[i].getY() + btn[i].getHeight() +  20, 80, 40,"빼기");
            btn[i + 1].setActionCommand("-"+ingredients.getiName().get(j));
            btn[i].addActionListener(new ButtonEventManager_Shop());
            btn[i+1].addActionListener(new ButtonEventManager_Shop());
            
            shopBag[j] = new JLabel("0");
            shopBag[j].setBounds(btn[i + 1].getX() + btn[i + 1].getWidth() + 20, btn[i + 1].getY() + 10, 100, 30);
            shopBag[j].setFont(FontManager.labelFont);
            shopBag[j].setForeground(Color.black);
            
            j++;
        }
        
        
        tCount = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (MyCocktail.basket != null) {

                        for (int i = 0; i < ingredients.getiName().size(); i++) {
                            Iterator<Basket> basketit = MyCocktail.basket.iterator();
                            while (basketit.hasNext()) {
                                Basket b = basketit.next();
                                if (b.getName().equals(ingredients.getiName().get(i))) {
                                    shopBag[i].setText("개수 : "+String.valueOf(b.getCount()));
                                    bool = true;
                                    break;
                                }
                            }
                            if(!bool) {
                                shopBag[i].setText("개수 : "+"0");
                            }
                            bool = false;
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        });
        
        for (int i = 0; i < shopBag.length; i++) {
            add(shopBag[i]);
        }

        tCount.setDaemon(true);
        tCount.start();
        
		previous_button = createImageButton(prev,FontManager.btnFont,0,getHeight()-130,100,100,"이전");
		previous_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tCount.stop();
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameCocktailInfo(str));
				
			}
		});
		
		basket_Button = createImageButton(pay, FontManager.btnFont, 1085, getHeight() - 130, 100, 100,"구매하기");
		basket_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameBasket());
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
	    button.setBackground(Color.black);
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
