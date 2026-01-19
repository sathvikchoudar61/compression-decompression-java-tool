package huff;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Decompressor {
	public static void start(String inputfile,String outputfile) throws IOException {
		//read the compressed file and get the frequent map and calculate total frequency value
		DataInputStream dis=new DataInputStream(new FileInputStream(inputfile));
		HashMap<Byte, Long> freq=HuffmanHeader.read(dis); 
		int totalfreq=0;
		for(Long frequency:freq.values()) {
			totalfreq+=frequency;
		}
		
		//create the huff_man tree
		HuffNode root=HuffmanTreeBuilder.build(freq);
		
		//decompress the file and store in output file
		HuffmanDecompressor.decompress(dis,root,totalfreq,outputfile);
	}
}
