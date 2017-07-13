package jp.co.bananadream.practice3.harasawa;

public class GetUnseiId {
	
	//String sql="select unsei_id from unsei_master";
	int unseiId;
	
	public int unseiId(String unsei){
		switch(unsei){
		case "大吉": 
			this.unseiId=1;
			break;
		case "小吉": 
			this.unseiId=2;
			break;
		case "中吉": 
			this.unseiId=3;
			break;
		case "吉": 
			this.unseiId=4;
			break;
		case "末吉": 
			this.unseiId=5;
			break;
		case "凶": 
			this.unseiId=6;
			break;
		}
		return unseiId;
	}
}
