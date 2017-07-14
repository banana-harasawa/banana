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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws SQLException, IOException{

		ReadFile read = new ReadFile();

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
			//DBに登録
			WriterSql writer = new WriterSql();
			writer.writerOmikujiTbl(connection);

			while (true) {
				// 生年月日を入力してください
				System.out.println("生年月日を入力してください（yyyyMMddの形で入力して下さい）");

				try {
					//				//おみくじテーブルの中身がnullなら
					//				    private String selectAll = "SELECT omikuji_id FROM omikuji";
					//				    
					//				    public void printSelectAll() throws SQLException {
					//				        Connection con = DBManager.getConnection();
					//				        Statement stmt = con.createStatement();
					//				        ResultSet result = stmt.executeQuery(selectAll);
					//				        List stockList = new ArrayList();
					//				        while (result.next()) {
					//				            StockBean bean = new StockBean();
					//				            bean.setCode(result.getString(1));
					//				            bean.setName(result.getString(2));
					//				            bean.setOpenPrice(result.getInt(3));
					//				            bean.setHighPrice(result.getInt(4));
					//				            bean.setLowPrice(result.getInt(5));
					//				            bean.setClosePrice(result.getInt(6));
					//				            stockList.add(bean);
					//				        }
					//				        
					//				if(selectAll != null){
					//					
					//				}else{


					// 入力
					String strDate = br.readLine();

					//日付取得
					GetOmikuji omikuji = new GetOmikuji();
					String day2 = omikuji.date(strDate);
					Random r = omikuji.random(strDate);
					Boolean flg = omikuji.getOmikuji(strDate,day2);
					int idx = omikuji.getIdx(r,day2,strDate);

					System.out.println(al.get(idx).disp());

					if (flg) {
						//DBに登録
						writer.writerResultTbl(idx, strDate,connection);

					}
					//				}
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
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}