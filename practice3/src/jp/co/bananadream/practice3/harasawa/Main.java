package jp.co.bananadream.practice3.harasawa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws SQLException, IOException{

		ReadFile read = new ReadFile();
		PreparedStatement ps = null;
		Writer writer = new Writer();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;		

		//入力ストリームの生成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//ファイルの読み込み（既におみくじリストに詰められた状態）
		List<Omikuji> al = read.readFile();

		try{
			// 接続     
			connection = DriverManager.getConnection("jdbc:postgresql:TEST", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
					"postgres", // ログインロール
					"sinnyuu18551"); // パスワード
			connection.setAutoCommit(false);

			//while (true) {
			// 生年月日を入力してください
			System.out.println("生年月日を入力してください（yyyyMMddの形で入力して下さい）");

			try {
				//おみくじテーブルの中身がnullなら
//				List s = "SELECT omikuji_id FROM omikuji";
//				if(s==null){
				// Date型を詰めるBean
				//おみくじDBにおみくじ（50種類）を登録したい
				//writer.writer(idx, strDate, day2);
				
//				GetUnseiId omi = new GetUnseiId();
//				int unseiTBL =omi.unseiId();
				//SQL文を定義する
				String omikujiSql = "INSERT INTO omikuji(omikuji_id,unsei_id,negaigoto,akinai,gakumon,author,created_date,updater,date_renovation)"
						+ " values(?, ?, ?, ?, ?,'原澤香織', current_date, '原澤香織', current_date)";//9  

				//omikujiテーブルに書き込む
				for(int i =0; i<al.size(); i++){
					
					GetUnseiId omi = new GetUnseiId();
					int unseiTBL = omi.unseiId(al.get(i).unsei);

					//実行するSQL文とパラメータを指定する
					ps = connection.prepareStatement(omikujiSql);
					ps.setInt(1,i);	//おみくじコード
					ps.setInt(2, unseiTBL);	//運勢コード
					ps.setString(3, al.get(i).negaigoto);//願い事
					ps.setString(4, al.get(i).akinai);	//商い
					ps.setString(5, al.get(i).gakumon);	//学問
					//作成者
					//作成日
					//登録者
					//登録日


					//INSERT文を実行する
					int j = ps.executeUpdate();
					
					//コミット
					connection.commit();
					
						
					}
					
			//	}
				

				// 入力
				String strDate = br.readLine();

				// yyyyMMddの形に変換
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				df.setLenient(false); // ←これで厳密にチェックしてくれるようになる
				String s1 = strDate;
				String s2 = df.format(df.parse(s1)); // ←df.parseでParseExceptionがThrowされる

				// 占った日付を取ってくる生成（DBに登録しない方）
				Date today1 = new Date();
				// yyyyMMddの形に変換
				String day1 = df.format(today1);
				// System.out.println(day1);

				// 占った日付を生成（DBに登録する方）
				Date today2 = new Date();
				// yyyyMMddの形に変換
				String day2 = df.format(today2);
				// System.out.println(day2);

				// 入力された生年月日によって結果が変わる（同じ誕生日だと同じ結果を返す）
				Random r = new Random(Long.parseLong(strDate));
				int b = r.nextInt(al.size());
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

				int nowDate = Integer.parseInt(day2);
				int seed = nowDate - Integer.parseInt(strDate);
				r = new Random(seed);
				int idx = r.nextInt(al.size());

				System.out.println(al.get(idx).disp());

				if (flg) {
					//DBに登録したい
					//writer.writer(idx, strDate, day2);

					//SQL文を定義する
					String resultSql = "INSERT INTO result(omikuji_id,birthday,author,created_date,updater,date_renovation)"
							+ " values(?, ?,'原澤香織', current_date, '原澤香織', current_date)";//7  

					//DBに書き込む
					
						//実行するSQL文とパラメータを指定する
						ps = connection.prepareStatement(resultSql);
						ps.setInt(1,idx);	//おみくじコード
						ps.setString(2, strDate);	//誕生日
						//作成者
						//作成日
						//登録者
						//登録日


						//INSERT文を実行する
						int j = ps.executeUpdate();

						//コミット
						connection.commit();
					}
				
			} catch (ParseException p) {
				p.printStackTrace();
			}
			
			//接続を切断する
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();

			}

			//	}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}