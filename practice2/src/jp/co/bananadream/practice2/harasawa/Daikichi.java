package jp.co.bananadream.practice2.harasawa;

class Daikichi extends Omikuji {
	public String getUnsei() {
		return unsei;
	}
	public void setUnsei(String unsei) {
		this.unsei = unsei;
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
		//csvの中の大吉の値を代入したい。
	}
	@Override
	public String disp() {
		// TODO 自動生成されたメソッド・スタブ
		
		//文字列連結
				StringBuilder buf = new StringBuilder();
				buf.append("今日の運勢は");
				buf.append(getUnsei());
				buf.append("です。");
				buf.append(" 願い事：");
				buf.append(getAkinai());
				buf.append(" 学問：");
				buf.append(getGakumon());
		return buf.toString();
	}
	
}

