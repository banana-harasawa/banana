package jp.co.bananadream.practice2.harasawa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Start {
	public static void main(String[]args)throws IOException{
		try{
			//ファイルを読み込む
			File f = new File("/Users/k_harasawa/Documents/uranai.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));

			String line;
			//1行ずつCSVファイルを読み込む
			//読み込んだデータがnullでなければ
			while((line = br.readLine()) != null){
				//行をカンマ区切りで配列に変換
				String[] data =line.split(",", 0);

				//Listを生成
				List<Omikuji> al = new ArrayList<Omikuji>();

				//data[0]の中身が大吉ならば、Daikichiオブジェクトを生成
				if(data[0].equals("大吉")){
					Daikichi dai = new Daikichi();

					//data[0]を読み込んで						
					dai.setUnsei(data[0]);
					dai.setNegaigoto(data[1]);
					dai.setAkinai(data[2]);
					dai.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(dai); 
					String daikichi=dai.disp();
					System.out.println(daikichi);
				}

				//data[0]が中吉ならば
				if(data[0].equals("中吉")){
					//中吉オブジェクトを生成
					Tyukichi tyu = new Tyukichi();

					//data[0]を読み込んで							
					tyu.setUnsei(data[0]);
					tyu.setNegaigoto(data[1]);
					tyu.setAkinai(data[2]);
					tyu.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(tyu); 
					String tyukichi=tyu.disp();


				}
				if(data[0].equals("小吉")){
					Syoukichi syo = new Syoukichi();
					//data[0]を読み込んで							
					syo.setUnsei(data[0]);
					syo.setNegaigoto(data[1]);
					syo.setAkinai(data[2]);
					syo.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(syo); 
					String syokichi=syo.disp();
				}
				if(data[0].equals("吉")){
					Kichi kichi = new Kichi();

					kichi.setUnsei(data[0]);
					kichi.setNegaigoto(data[1]);
					kichi.setAkinai(data[2]);
					kichi.setGakumon(data[3]);

					//吉にセットした値をリストに格納
					al.add(kichi); 
					String kiti=kichi.disp();

				}
				if(data[0].equals("末吉")){
					Suekichi sue = new Suekichi();
					//brが読み込み可能かどうか判定する

					sue.setUnsei(data[0]);
					sue.setNegaigoto(data[1]);
					sue.setAkinai(data[2]);
					sue.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(sue); 
					String suekichi=sue.disp();

				}
				if(data[0].equals("凶")){
					Kyo kyo = new Kyo();

					kyo.setUnsei(data[0]);
					kyo.setNegaigoto(data[1]);
					kyo.setAkinai(data[2]);
					kyo.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(kyo); 
					String kyou=kyo.disp();
					System.out.println(kyo);
				}
//				for(int i=0; i<50; i++){
//					System.out.println(al.dai.toString());
//				}


				//誕生日を入力
				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("生年月日を入力してください");
				try {
					String strDate=br2.readLine();

					DateFormat df = DateFormat.getDateInstance();
					SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateInstance();
					
					
					Date date = formatter.parse(br.readLine());
					formatter.applyPattern("yyyyMMdd");
					String b = formatter.format(date);
					System.out.println(b);
				}
				catch (ParseException ex) {
					System.out.println("解析失敗");
				}
				

				//ランダムで数字をだす（０〜５）
				Random rand = new Random();
				int num = rand.nextInt(5);
				//数字を使ってリストの中から一つ選び出す

//				//もし入力された誕生日が当日なら
//				if(strDate == data){
//					System.out.println(strDate);
//				}
			}
			
			br.close();

		}catch(IOException e){
			System.out.println(e);
		}


	}

}

