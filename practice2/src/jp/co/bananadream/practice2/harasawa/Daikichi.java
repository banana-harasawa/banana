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
		System.out.println("今日の運勢は"+ getUnsei() +"です");
		System.out.println("願い事："+ getNegaigoto());
		System.out.println("商い"+ getAkinai());
		System.out.println("学問"+ getGakumon());

		return "";
	}
	
}

