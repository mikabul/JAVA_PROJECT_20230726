package GUI;

import java.awt.Font;
import java.io.File;

public class FontManager {

	public static final Font titleFont;
	public static final Font questionFont;
	public static final Font btnFont;
	public static final Font labelFont;
	public static final Font infoFont;
	public static final Font shopFont;
	public static final Font preferFont;

	static {
		Font customFont = null;
		try {
			File customFontFile = new File("Resources\\font\\JalnanOTF.otf");
			customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (customFont != null) {
			titleFont = customFont.deriveFont(Font.BOLD, 60);
			questionFont = customFont.deriveFont(Font.BOLD, 30);
			btnFont = customFont.deriveFont(Font.BOLD, 20);
			labelFont = customFont.deriveFont(Font.BOLD, 25);
			infoFont = customFont.deriveFont(Font.BOLD, 15);
			shopFont = customFont.deriveFont(Font.BOLD, 8);
			preferFont = customFont.deriveFont(Font.BOLD,30);
		} else {
			titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 60);
			questionFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
			btnFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
			labelFont = new Font(Font.SANS_SERIF, Font.BOLD, 25);
			infoFont = new Font(Font.SANS_SERIF, Font.BOLD, 15);
			shopFont = new Font(Font.SANS_SERIF, Font.BOLD, 8);
			preferFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		}
	}

}
