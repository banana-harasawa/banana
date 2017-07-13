package jp.co.bananadream.practice3.harasawa;


class Daikichi extends Omikuji {
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
		this.unsei="大吉";
		
	}
	@Override
	public String disp() {
		// TODO 自動生成されたメソッド・スタブ
		
		//文字列連結
				StringBuilder buf = new StringBuilder();
				String str = String.format(DISP_STR, unsei);
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

