package jp.co.bananadream.practice3.harasawa;

import java.util.ResourceBundle;

interface Fortune {
	
ResourceBundle rb= ResourceBundle.getBundle("fortune");
String DISP_STR = rb.getString("disp_str");
	String disp();
}
