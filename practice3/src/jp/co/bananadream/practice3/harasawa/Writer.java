package jp.co.bananadream.practice3.harasawa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Writer {
	public void writer(int b,String strDate,String day2){
		//書き込むよ
		try {
			FileWriter fw = new FileWriter("/Users/k_harasawa/Documents/Writer.csv",true);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			ReadFile read = new ReadFile();
			List<Omikuji> al = read.readFile();

			//おみくじリストを回す
			//もし同じ数字があれば書き込む
			pw.print(day2);
			pw.print(",");
			pw.print(strDate);
			pw.print(",");
			pw.print(al.get(b).unsei);
			pw.print(",");
			pw.print(al.get(b).negaigoto);
			pw.print(",");
			pw.print(al.get(b).akinai);
			pw.print(",");
			pw.print(al.get(b).gakumon);
			pw.println();

			// fw.print(al.get(r.nextInt(al.size())).disp());
			pw.close();
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
