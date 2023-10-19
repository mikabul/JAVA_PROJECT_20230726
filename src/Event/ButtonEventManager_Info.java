package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import PageFrame.FrameBase;
import PageFrame.FrameCocktailInfo;

public class ButtonEventManager_Info implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		
		FrameBase.disposeInstance();
		FrameBase.getInstance(new FrameCocktailInfo(e.getActionCommand()));
	}
	
	
}
