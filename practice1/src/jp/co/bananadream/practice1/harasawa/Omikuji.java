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
		String s1 = "今日の運勢は";
		String s2 = kuji.get(num);
		String s3 = "です。";
		StringBuffer buf = new StringBuffer();
		buf.append(s1);
		buf.append(s2);
		buf.append(s3);
		String s = buf.toString();

		return s;
	}
}
