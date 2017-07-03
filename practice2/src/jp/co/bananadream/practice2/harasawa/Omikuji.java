package jp.co.bananadream.practice2.harasawa;

abstract class Omikuji implements Fortune {
	//運勢を格納するおみくじ抽象クラス
	protected String unsei;
	protected String negaigoto;
	protected String akinai;
	protected String gakumon;
	public abstract void setUnsei();
	
}
