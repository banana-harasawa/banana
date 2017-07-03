package jp.co.bananadream.practice2.harasawa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {
	public static void main(String[]args){
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
				//ここでは値がでる
				for(int i=0; i < data.length; i++){
					System.out.println(data[i]);
				}
			
				
				//Listを生成
				List<String> al = new ArrayList<String>();
				
				//csvを回す
				for(String kuji : data){
					//data[0]の中身が大吉ならば、Daikichiオブジェクトを生成
					if(data[0].equals("大吉")){
						Daikichi dai = new Daikichi();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							dai.setUnsei(data[0]);
							dai.setNegaigoto(data[1]);
							dai.setAkinai(data[2]);
							dai.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(dai.getUnsei()); 
							al.add(dai.getNegaigoto());
							al.add(dai.getAkinai());
							al.add(dai.getGakumon());
						}
					}
					//data[0]が中吉ならば
					if(data[0].equals("中吉")){
						//中吉オブジェクトを生成
						Tyukichi tyu = new Tyukichi();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							tyu.setUnsei(data[0]);
							tyu.setNegaigoto(data[1]);
							tyu.setAkinai(data[2]);
							tyu.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(tyu.getUnsei()); 
							al.add(tyu.getNegaigoto());
							al.add(tyu.getAkinai());
							al.add(tyu.getGakumon());
						}
						
					}
					if(data[0].equals("小吉")){
						Syoukichi syo = new Syoukichi();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							syo.setUnsei(data[0]);
							syo.setNegaigoto(data[1]);
							syo.setAkinai(data[2]);
							syo.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(syo.getUnsei()); 
							al.add(syo.getNegaigoto());
							al.add(syo.getAkinai());
							al.add(syo.getGakumon());
						}
					}
					if(data[0].equals("吉")){
						Kichi kichi = new Kichi();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							kichi.setUnsei(data[0]);
							kichi.setNegaigoto(data[1]);
							kichi.setAkinai(data[2]);
							kichi.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(kichi.getUnsei()); 
							al.add(kichi.getNegaigoto());
							al.add(kichi.getAkinai());
							al.add(kichi.getGakumon());
						}
					}
					if(data[0].equals("末吉")){
						Suekichi sue = new Suekichi();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							sue.setUnsei(data[0]);
							sue.setNegaigoto(data[1]);
							sue.setAkinai(data[2]);
							sue.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(sue.getUnsei()); 
							al.add(sue.getNegaigoto());
							al.add(sue.getAkinai());
							al.add(sue.getGakumon());
						}
					}
					if(data[0].equals("凶")){
						Kyo kyo = new Kyo();
						//brが読み込み可能かどうか判定する
						while(br.ready()){
							//data[0]を読み込んで
							line=br.readLine();
							kyo.setUnsei(data[0]);
							kyo.setNegaigoto(data[1]);
							kyo.setAkinai(data[2]);
							kyo.setGakumon(data[3]);
							
							//大吉にセットした値をリストに格納
							al.add(kyo.getUnsei()); 
							al.add(kyo.getNegaigoto());
							al.add(kyo.getAkinai());
							al.add(kyo.getGakumon());
						}
						
					}
						
					//for(int j=0; j< al.size(); j++){
					//System.out.println(al.get(j));
					//					}
				}

			}

			br.close();

		}catch(IOException e){
			System.out.println(e);
		}

		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//		String str=br.readLine();
	}


}

