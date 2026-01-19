package huff;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanCompressor {
	public static void compress(String inputfile,DataOutputStream dos,HashMap<Byte,String> codes) throws IOException {
		BitOutputStream bos=new BitOutputStream(dos);
		BufferedInputStream input=new BufferedInputStream(new FileInputStream(inputfile));
		int readnext;
		
		while((readnext=input.read())!=-1) {
			byte currentbyte=(byte)readnext;
			String code=codes.get(currentbyte);
			for(char ch:code.toCharArray()) {
				bos.bitwrite(ch=='1'?1:0);					
			}
		}
		
		bos.close();
		input.close();
	}
}
