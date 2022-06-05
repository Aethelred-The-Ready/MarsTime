import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Displayer {
	private static JPanel j;
	private static MarsTime t;
	
	public static void main(String[] args) {
		
		render();
		 
		
		while(true) {
			j.repaint();
			//System.out.println(t.curTime().toString());
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private static void render(){
		JFrame frame = new JFrame("Mars Time");
		
		j = new JPanel(){
			public void paint(Graphics p) {	
				p.setColor(Color.WHITE);// Color(150, 32, 32));
				p.fillRect(0, 0, 400, 50);
				p.setColor(Color.BLACK);
				p.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
				p.drawString(t.curTime().toString(), 10, 20);
			}
		};
		
		frame.add(j);
		frame.setLocation(10,10);
		frame.setSize(400, 70);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
