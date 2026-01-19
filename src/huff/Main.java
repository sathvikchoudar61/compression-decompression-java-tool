package huff;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String type;
		String inputfile;
		String outputfile;
		if(args.length==3) {
			type=args[0].toLowerCase();
			if(!type.equals("compress") && !type.equals("decompress")) {
				System.out.println("type should be compress or decompress");
				return;				
			}
			inputfile=args[1];
			outputfile=args[2];
		}else {
			System.out.println("Usage:\r\n"+ "  compress <input> <output>\r\n"+ "  decompress <input> <output>\r\n");
			return;
		}
		try {
			if(type.equals("compress")) {
				Compressor.start(inputfile,outputfile);				
			}else {
				Decompressor.start(inputfile,outputfile);			
			}
		}catch(IOException e) {
		    e.printStackTrace();
		}

	}
	
}
