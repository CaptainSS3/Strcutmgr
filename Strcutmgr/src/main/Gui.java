package main;
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
	//GlobalScreen.addNativeKeyListener(null);
	
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
    GlobalScreen.addNativeKeyListener(new Gui());
    frame.setVisible(false);
    frame2.setSize(700, 700);
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
		if(e.getKeyCode() == 29){
			System.out.println("gottem");
			frame2.setVisible(true);
			
		}
		if(e.getKeyCode() == 56){
			System.out.println("gottem");
			frame2.setVisible(false);
			
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

}
