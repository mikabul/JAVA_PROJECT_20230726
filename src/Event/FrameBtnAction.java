package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PageFrame.FrameBase;
import PageFrame.FrameFavor;

public class FrameBtnAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		FrameBase.disposeInstance();
		FrameBase.getInstance(new FrameFavor(e.getActionCommand()));
		
	}

}