

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parades.ParadeProcessor;

public class Main {
	static char[] word1;
	static char[] word2;
	
	public static void read() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line1 = reader.readLine();
		String line2 = reader.readLine();
		word1 = line1.toCharArray();
		word2 = line2.toCharArray();	
	}
	
	public static void main(String[] args) throws IOException {
		read();
		ParadeProcessor p = new ParadeProcessor(word1, word2);
		//p.printMatrixRule();
		System.out.println(String.valueOf(p.getMaxWordLength()).trim());
		if(p.getMaxWordLength() != 0)System.out.println(p.getFinalWord().trim());
		

	}

}
