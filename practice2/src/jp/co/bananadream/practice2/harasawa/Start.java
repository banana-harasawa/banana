package jp.co.bananadream.practice2.harasawa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Start {
	public static void main(String[]args)throws IOException{
		//ReadFileからおみくじを読み込む
		ReadFile read =new ReadFile();
		List<Omikuji> al = read.readFile();

		while(true){
			//生年月日を入力してください
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("生年月日を入力してください（yyyyMMddの形で入力して下さい）");

			try {
				//Date型を詰めるBean
				DateBean today = new DateBean();

				//入力
				String strDate = br2.readLine();

				//yyyyMMddの形に変換
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				df.setLenient(false); // ←これで厳密にチェックしてくれるようになる
				String s1 = strDate;
				String s2 = df.format(df.parse(s1)); // ←df.parseでParseExceptionがThrowされる



				//一番新しい今日の日付を生成
				Date today1 = new Date();
				//yyyyMMddの形に変換
				String day1 = df.format(today1);
				today.setToday(day1);
				//System.out.println(day);

				//比較するための今日の日付を生成
				Date today2 =new Date();
				//yyyyMMddの形に変換
				String day2 = df.format(today2);
				//System.out.println(day2);


				//入力された生年月日によって結果が変わる（同じ誕生日だと同じ結果を返す）
				Random r = new Random( Long.parseLong(strDate));

				//today1とtoday2を比較
				int diff = day2.compareTo(day1);
				//System.out.println(diff);

				//今日が今日だったら同じ結果を返す
				if(diff == 0){
					//前に入力された生年月日と同じ結果を返す
					System.out.println(al.get(r.nextInt(al.size())).disp());

					//今日が今日ではなかったら新しくランダムを生成しくじを引く
				}else if(diff>0){
					int nowDate = Integer.parseInt(df.format(day2)) ;
					int seed = nowDate - Integer.parseInt(strDate) ;
					r = new Random(seed);
					System.out.println(al.get(r.nextInt(al.size())).disp());

				}else{
					System.out.println("過去");
				}

			} catch (ParseException p) {
				p.printStackTrace();
				

			}
		}
	}
	//
	//				//today1の中身が20170707の場合
	//				String dateStr = "20170707";
	//
	//				//				//一番新しい今日の日付を生成
	//				//				Date today1 = new Date();
	//				//				//yyyyMMddの形に変換
	//				//				SimpleDateFormat sdf1= new SimpleDateFormat("yyyyMMdd");
	//				//				today.setToday(today1);
	//
	////				//比較するための今日の日付を生成
	////				today2 =new Date();
	//
	//				//入力された生年月日によって結果が変わる（同じ誕生日だと同じ結果を返す）
	//				//r = new Random( Long.parseLong(strDate));
	//
	//				//today1とtoday2を比較
	//				diff = dateStr.compareTo(day2);
	//				System.out.println(diff);
	//
	//				//今日が今日だったら同じ結果を返す
	//				if(diff == 0){
	//					//前に入力された生年月日と同じ結果を返す
	//					System.out.println(al.get(r.nextInt(al.size())).disp());
	//
	//					//未来だったら新しくランダムを生成しくじを引く
	//				}else if(diff>0){
	//					int nowDate = Integer.parseInt(day2) ;
	//					int seed = nowDate - Integer.parseInt(strDate) ;
	//					r = new Random(seed);
	//					System.out.println(al.get(r.nextInt(al.size())).disp());
	//
	//				}else{
	//					System.out.println("過去");
	//				}


}

