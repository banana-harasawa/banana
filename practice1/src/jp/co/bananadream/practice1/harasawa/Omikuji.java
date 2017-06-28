package jp.co.bananadream.practice1.harasawa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Omikuji {
	public static void main(String[] args) {


		System.out.println(Omiregist());

	}

	public static String Omiregist(){

		//リストに値を詰める
		List<String> kuji = new ArrayList<String>();
		kuji.add("大吉");
		kuji.add("中吉");
		kuji.add("小吉");
		kuji.add("末吉");
		kuji.add("吉");
		kuji.add("凶");

		//ランダムで数字をだす（０〜５）
		Random rand = new Random();
		int num = rand.nextInt(5);

		//文字列連結
		StringBuilder buf = new StringBuilder();
		buf.append("今日の運勢は");
		buf.append(kuji.get(num));
		buf.append("です。");

		return buf.toString();
	}
}
