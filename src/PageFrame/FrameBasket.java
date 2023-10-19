package PageFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Database.Basket;
import Database.MyCocktail;
import Event.ButtonEventManager_Shop;
import GUI.FontManager;
import GUI.ImageSelector;

public class FrameBasket extends JPanel {

	JLabel titleLabel, titleImg, total_price_label;
	JLabel[] shopBag;
	JLabel[] text;
	JButton[] listBtn, addBtn, subBtn;
	JButton tossPay, previous_button;
	ImageIcon titleIcon;
	Boolean bool = false;
	int total_price;
	Thread tCount;
	Image background_image;
	
	ImageIcon buytab, prev, buybtn,minusbtn;
	public FrameBasket() {
		
		setSize(1200, 900);
		setLayout(null);

		buytab=  new ImageIcon	("Resources\\UI_image\\buytab.png");
		prev=  new ImageIcon		("Resources\\UI_image\\previous.png");
		buybtn=  new ImageIcon	("Resources\\UI_image\\buybtn.png");
		minusbtn=  new ImageIcon	("Resources\\UI_image\\minusbtn.png");
		
		
		
		// ----------------타이틀 부분---------------
		titleIcon = new ImageIcon("Resources/basket.png");
		titleIcon = new ImageSelector().imageSetSize(titleIcon, 50, 50);
		titleImg = new JLabel(titleIcon);
		titleLabel = new JLabel("장바구니");

		titleLabel.setFont(FontManager.titleFont);

		titleImg.setBounds(430, 50, 50, 100);
		titleLabel.setBounds(titleImg.getX() + titleImg.getWidth() + 10, titleImg.getY(), 400, 100);

		add(titleImg);
		add(titleLabel);
		
		total_price_label = new JLabel();
		
		if (MyCocktail.basket != null) {

			listBtn = new JButton[MyCocktail.basket.size()];
			addBtn = new JButton[MyCocktail.basket.size()];
			subBtn = new JButton[MyCocktail.basket.size()];
			shopBag = new JLabel[MyCocktail.basket.size()];
			text = new JLabel[MyCocktail.basket.size()];
			
			for (int i = 0; i < MyCocktail.basket.size(); i++) {
				listBtn[i] = new JButton();
				addBtn[i] = new JButton(buybtn);
				subBtn[i] = new JButton(minusbtn);
				text[i] = new JLabel();
				
				
				
				listBtn[i].setIcon(new ImageSelector().imageSelctor(MyCocktail.basket.get(i).getName()));
				text[i].setText("<HTML>"+MyCocktail.basket.get(i).getName() + "<br>" + MyCocktail.basket.get(i).getPrice() + "</HTML>");
				addBtn[i].setActionCommand(MyCocktail.basket.get(i).getName());
				subBtn[i].setActionCommand("-" + MyCocktail.basket.get(i).getName());
				
				listBtn[i].setBounds(100, 150 + (110 * i), 100,100);
				addBtn[i].setBounds(listBtn[i].getX() + listBtn[i].getWidth()+170,
						listBtn[i].getY(), 80, 40);
				subBtn[i].setBounds(addBtn[i].getX(), addBtn[i].getY() + addBtn[i].getHeight() + 20, addBtn[i].getWidth(), addBtn[i].getHeight());
				text[i].setBounds(listBtn[i].getX()+100,listBtn[i].getY(),200,100);

				addBtn[i].addActionListener(new ButtonEventManager_Shop());
				subBtn[i].addActionListener(new ButtonEventManager_Shop());
				
				shopBag[i] = new JLabel(String.valueOf(MyCocktail.basket.get(i).getCount()));
				shopBag[i].setBounds(subBtn[i].getX() + subBtn[i].getWidth() + 20, subBtn[i].getY(), 20, 20);
				
				listBtn[i].setBackground(Color.LIGHT_GRAY);
				listBtn[i].setOpaque(false);
				addBtn[i].setBackground(Color.LIGHT_GRAY);
				addBtn[i].setOpaque(false);
				
				subBtn[i].setBackground(Color.LIGHT_GRAY);
				subBtn[i].setOpaque(false);
				
				shopBag[i].setBackground(Color.LIGHT_GRAY);
				
				listBtn[i].setBorder(null);
				shopBag[i].setBorder(null);
				
			}

			tCount = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						if (MyCocktail.basket != null) {
							total_price = 0;
							for (int i = 0; i < addBtn.length; i++) {
								Iterator<Basket> basketit = MyCocktail.basket.iterator();
								while (basketit.hasNext()) {
									Basket b = basketit.next();
									if (b.getName().equals(addBtn[i].getActionCommand())) {
										shopBag[i].setText(String.valueOf(b.getCount()));
										bool = true;
										total_price += b.getPrice()*b.getCount();
										break;
									}
								}
								if (!bool) {
									shopBag[i].setText("0");
								}
								bool = false;
								total_price_label.setText(String.valueOf(total_price)+"원");
								
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
			
			tCount.setDaemon(true);
			tCount.start();
			
			for(int i = 0; i < addBtn.length; i++) {
				add(subBtn[i]);
				add(addBtn[i]);
				add(listBtn[i]);
				add(shopBag[i]);
				add(text[i]);
			}
		}
		
		
		//String.valueOf(total_price)
		tossPay = new JButton(buytab);
		tossPay.setBounds(900,700,200,100);
		tossPay.setBackground(Color.LIGHT_GRAY);
		tossPay.setOpaque(false);
		add(tossPay);
		tossPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, String.valueOf(total_price) +"원 결제되었습니다.!","결제창", JOptionPane.WARNING_MESSAGE);
				for(int i = 0; i < MyCocktail.basket.size();i++) {
					MyCocktail.basket.clear();
				}
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMyInfo());
			}
		});
		
		total_price_label = new JLabel(String.valueOf(total_price));
		total_price_label.setBounds((tossPay.getX() - tossPay.getWidth()) - 450, tossPay.getY(), tossPay.getWidth() + 400,
                tossPay.getHeight());
		total_price_label.setHorizontalAlignment(JLabel.RIGHT);
		total_price_label.setFont(FontManager.questionFont);
		total_price_label.setForeground(Color.black);
		add(total_price_label);
		
		
		
		previous_button = new JButton(prev);
		previous_button.setBounds(0,getHeight()-155,120,120);
		previous_button.setBackground(Color.LIGHT_GRAY);
		previous_button.setOpaque(false);
		
		add(previous_button);
		previous_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tCount.stop();
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMain());
			}
		});
		
	}
	public void paintComponent(Graphics g) {
		background_image = new ImageIcon("Resources\\cocktail_bar.png").getImage();
        g.drawImage(background_image, 0, 0, null);
    }
}
