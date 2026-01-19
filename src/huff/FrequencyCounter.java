package huff;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class FrequencyCounter {
	public static HashMap<Byte,Long> count(String filename) throws IOException{
		BufferedInputStream br=new BufferedInputStream(new FileInputStream(filename));
		int readnext;
		HashMap<Byte,Long> freq=new HashMap<>(); 
		
		while((readnext=br.read())!=-1) {
			byte currentbyte=(byte)readnext;
			freq.put(currentbyte, freq.getOrDefault(currentbyte,(long) 0)+1);
		}
		
		br.close();
		
		return freq;
	}
}
