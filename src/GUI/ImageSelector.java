package GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageSelector {


	ImageIcon img;
	public ImageSelector() {}
	
	public ImageIcon imageSelctor(String name) {
		
		if(name.equals("마티니")) {
			img = new ImageIcon("Resources/dry/Martini.jpg");
		}else if(name.equals("베르무트")) {
			img = new ImageIcon("Resources/dry/Vermouth.jpg");
		}else if(name.equals("미도리샤워")) {
			img = new ImageIcon("Resources/fruit/MidoriSour.jpg");
		}else if(name.equals("시브리즈")) {
			img = new ImageIcon("Resources/fruit/SeaBreeze.jpg");
		}else if(name.equals("블랙러시안")) {
			img = new ImageIcon("Resources/hot/BlackRussian.jpg");
		}else if(name.equals("위스키콕")) {
			img = new ImageIcon("Resources/hot/WhiskyCoke.jpg");
		}else if(name.equals("코스모폴리탄")) {
			img = new ImageIcon("Resources/refresing/Cosmopolitan.jpg");
		}else if(name.equals("그래스호퍼")) {
			img = new ImageIcon("Resources/refresing/Grasshopper.jpg");
		}else if(name.equals("피나콜라다")) {
			img = new ImageIcon("Resources/smoothie/PinaColada.jpg");
		}else if(name.equals("다이키리")) {
			img = new ImageIcon("Resources/smoothie/Daiquiri.jpg");
		}else if(name.equals("마가리타")) {
			img = new ImageIcon("Resources/sweet/Margarita.jpg");
		}else if(name.equals("깔루아밀크")) {
			img = new ImageIcon("Resources/sweet/Kahlua Milk.jpg");
		}else {
			img = new ImageIcon("Resources/ingredient/" + name + ".png");
		}
		
		return img;
	}
	
	public ImageIcon imageSetSize(ImageIcon img, int width, int height) {
        Image image = img.getImage();
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        img = new ImageIcon(image);
        return img;
    }
}
