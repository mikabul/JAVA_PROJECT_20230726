package PageFrame;


import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBase extends JFrame{
	
	
	private static FrameBase instance;
	
	private FrameBase(JPanel e) {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		setTitle("Get Some Alchoal!");
		setBounds(((int) tk.getScreenSize().getWidth()) / 2-600,
				((int) tk.getScreenSize().getHeight()) / 2-450,
				1200, 900);
		setLayout(null);
		add(e);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public static void getInstance(JPanel e) {
		
		instance = new FrameBase(e);
		
	}
	
	public static void disposeInstance() {
		instance.dispose();
	}
	
}