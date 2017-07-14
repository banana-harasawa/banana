package jp.co.bananadream.practice3.harasawa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GetOmikuji {

	ReadFile read = new ReadFile();
	List<Omikuji> al = read.readFile();

	// 入力された生年月日によって結果が変わる（同じ誕生日だと同じ結果を返す）
	public Boolean getOmikuji(String strDate,String day2) throws ParseException{

		List<DayResult> ystrday = read.readWriterFile();
		boolean bl = true;
		boolean flg = true;
		// WriterFileを読み込む

		// 書き込まれたものを読み込む
		for (int j = 0; j < ystrday.size(); j++) {
			int diff = day2.compareTo(ystrday.get(j).day2);
			// 今日の日付とファイルの中の日付が等しい且つ、生年月日が同じ場合、前回と同じ結果を返す
			if (diff == 0 && strDate.equals(ystrday.get(j).strDate)) {
				flg = false;
				// 前に入力された生年月日と同じ結果を返す
				// System.out.println(al.get(b).disp());
				break;
				// 今日とファイルの中の日付が同じでない且つ、生年月日が同じ場合、新しくランダムを生成しくじを引く
			}
		}
		return flg;
	}
	public String date(String strDate) throws ParseException{

		// yyyyMMddの形に変換
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		df.setLenient(false); // ←これで厳密にチェックしてくれるようになる
		String s1 = strDate;
		String s2 = df.format(df.parse(s1)); // ←df.parseでParseExceptionがThrowされる

		// 占った日付を生成（DBに登録する方）
		Date today2 = new Date();
		// yyyyMMddの形に変換
		String day2 = df.format(today2);

		return day2;
	}

	public Random random(String strDate){
		Random r = new Random(Long.parseLong(strDate));
		int b = r.nextInt(al.size());
		return r;
	}
	public int getIdx(Random r,String day2,String strDate){
		int nowDate = Integer.parseInt(day2);
		int seed = nowDate - Integer.parseInt(strDate);
		r = new Random(seed);
		int idx = r.nextInt(al.size());
		return idx;
	}
}
