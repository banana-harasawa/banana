package jp.co.bananadream.practice1.harasawa;

import java.util.ArrayList;
import java.util.Random;

public class Omikuji {
	public static void main(String[] args) {
	
	//リストに値を詰める
	ArrayList<String> kuji = new ArrayList<String>();
	kuji.add("大吉");
	kuji.add("中吉");
	kuji.add("小吉");
	kuji.add("末吉");
	kuji.add("吉");
	kuji.add("凶");
	
	//ランダムで数字をだす（０〜５）
	Random rand = new Random();
	int num = rand.nextInt(5);
	
	//出力
	System.out.print("今日の運勢は");
	System.out.print(kuji.get(num));
	System.out.print("です。");
	
	}
}
