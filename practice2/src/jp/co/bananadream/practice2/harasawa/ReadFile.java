package jp.co.bananadream.practice2.harasawa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public List<Omikuji> readFile(){
		//Listを生成
		List<Omikuji> al = new ArrayList<Omikuji>();
		String line;
		try{
			//ファイルを読み込む
			File f = new File("/Users/k_harasawa/Documents/uranai.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));



			//1行ずつCSVファイルを読み込む
			//読み込んだデータがnullでなければ
			while((line = br.readLine()) != null){
				//行をカンマ区切りで配列に変換
				String[] data =line.split(",", 0);


				//data[0]の中身が大吉ならば、Daikichiオブジェクトを生成
				if(data[0].equals("大吉")){
					Daikichi dai = new Daikichi();

					//data[0]を読み込んで						
					dai.setUnsei();
					dai.setNegaigoto(data[1]);
					dai.setAkinai(data[2]);
					dai.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(dai); 
					String daikichi=dai.disp();
					//出力
					//System.out.println(daikichi);
				}

				//data[0]が中吉ならば
				if(data[0].equals("中吉")){
					//中吉オブジェクトを生成
					Tyukichi tyu = new Tyukichi();

					//data[0]を読み込んで							
					tyu.setUnsei();
					tyu.setNegaigoto(data[1]);
					tyu.setAkinai(data[2]);
					tyu.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(tyu); 
					String tyukichi=tyu.disp();
					//出力
					//					System.out.println(tyukichi);

				}
				if(data[0].equals("小吉")){
					Syoukichi syo = new Syoukichi();
					//data[0]を読み込んで							
					syo.setUnsei();
					syo.setNegaigoto(data[1]);
					syo.setAkinai(data[2]);
					syo.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(syo); 
					String syokichi=syo.disp();
					//出力
					//					System.out.println(syokichi);
				}
				if(data[0].equals("吉")){
					Kichi kichi = new Kichi();

					kichi.setUnsei();
					kichi.setNegaigoto(data[1]);
					kichi.setAkinai(data[2]);
					kichi.setGakumon(data[3]);

					//吉にセットした値をリストに格納
					al.add(kichi); 
					String kiti=kichi.disp();
					//出力
					//					System.out.println(kiti);

				}
				if(data[0].equals("末吉")){
					Suekichi sue = new Suekichi();
					//brが読み込み可能かどうか判定する

					sue.setUnsei();
					sue.setNegaigoto(data[1]);
					sue.setAkinai(data[2]);
					sue.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(sue); 
					String suekichi=sue.disp();
					//出力
					//					System.out.println(suekichi);

				}
				if(data[0].equals("凶")){
					Kyo kyo = new Kyo();

					kyo.setUnsei();
					kyo.setNegaigoto(data[1]);
					kyo.setAkinai(data[2]);
					kyo.setGakumon(data[3]);

					//大吉にセットした値をリストに格納
					al.add(kyo); 
					String kyou=kyo.disp();
					//出力
					//					System.out.println(kyou);
				}

			}
			br.close();

		}catch(IOException e){
			System.out.println(e);
		}
		return al;
	}
}
