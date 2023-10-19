package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Database.MyCocktail;
import PageFrame.FrameBase;
import PageFrame.FrameMain;

public class ButtonEventManager_Prefer implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		
		if(str.equals("단게좋아")) {
			MyCocktail.sweet = 1;
		}else if(str.equals("단게싫어")) {
			MyCocktail.sweet = 0;
		}else if(str.equals("취할래요")) {
			MyCocktail.hot = 1;
		}else if(str.equals("안취할래요")) {
			MyCocktail.hot = 0;
		}else if(str.equals("완 료")) {
			if(MyCocktail.sweet != 2&&MyCocktail.hot != 2) {
				FrameBase.disposeInstance();
				FrameBase.getInstance(new FrameMain());					
			}
			else {
				JOptionPane.showMessageDialog(null, "모든 질문에 답해주세요!", "경고", JOptionPane.WARNING_MESSAGE);
			}
		}else {
			System.out.println("ERROR");
			System.exit(0);
			}
		
		
		
	}
	
	
}
