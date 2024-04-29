package ex03;

import java.io.FileWriter;
import java.io.IOException;

public class SimpltWrite {
	public static void main(String[] args) {
		
		FileWriter out;
		try {
			out = new FileWriter("c:/upload/data.txt");
			out.write('A');
			out.write('B');
			out.write("abcdefghi");
			out.write("--");
			out.write("korea", 2, 2);
			out.write('\n');
			out.write("korea");
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
