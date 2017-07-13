package jp.co.bananadream.practice3.harasawa;

import java.util.Formatter;

class Suekichi extends Omikuji{
	public String getUnsei() {
		return unsei;
	}
	public String getNegaigoto() {
		return negaigoto;
	}
	public void setNegaigoto(String negaigoto) {
		this.negaigoto = negaigoto;
	}
	public String getAkinai() {
		return akinai;
	}
	public void setAkinai(String akinai) {
		this.akinai = akinai;
	}
	public String getGakumon() {
		return gakumon;
	}
	public void setGakumon(String gakumon) {
		this.gakumon = gakumon;
	}
	public void setUnsei(){
	unsei="末吉";
	}
 public String disp(){

		//文字列連結
				StringBuilder buf = new StringBuilder();
				Formatter str = new Formatter();
				str.format(DISP_STR, getUnsei());
				String sep = System.getProperty("line.separator");
				
				buf.append(str);
				buf.append(sep);
				buf.append("願い事：");
				buf.append(getNegaigoto());
				buf.append(sep);
				buf.append("商い：");
				buf.append(getAkinai());
				buf.append(sep);
				buf.append("学問：");
				buf.append(getGakumon());
		return buf.toString();
	}

}
