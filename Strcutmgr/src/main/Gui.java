package main;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import javax.swing.*;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Gui  implements NativeKeyListener {
	
	JFrame frame = new JFrame("My First GUI");
	JFrame frame2 = new JFrame("My second GUI");
	
	void startgui() {
		
		frame2.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		GlobalScreen.addNativeKeyListener(new Gui());
		frame.setVisible(false);
    
    	try {
    	GlobalScreen.registerNativeHook();
    	}
    	catch (NativeHookException ex) {
    	System.err.println("There was a problem registering the native hook.");
    	System.err.println(ex.getMessage());

    	System.exit(1);
    	}
	}
	

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 3655){
			System.out.println("Opening program");
			frame2.setSize(1000, 700);
			JLabel label = new JLabel("1. Java"
					+ "2. python"
					+ "3. Misc");
			frame2.add(label);
			frame2.setVisible(true);
	
			
		}
		if(e.getKeyCode() == 56){
			System.out.println("gottem");
			frame2.setVisible(false);
			
		}
		if(e.getKeyCode() == 3663){
			System.out.println("closing program");
			System.exit(0);
			
		}
		

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		// TODO Auto-generated method stub
				
	} 
	
	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		
			System.out.println("code is " + e.getKeyCode());
	}
	public void clippo(String string) { //copy to clipord method: copies whichever string you give it to the clippord
		StringSelection selection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}


}
