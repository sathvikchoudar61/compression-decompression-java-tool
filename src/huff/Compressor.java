package huff;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Compressor {
	public static void start(String inputfile,String outputfile) throws IOException {
		//get frequency
		HashMap<Byte,Integer> freq=FrequencyCounter.count(inputfile); 
		
		//create huff_man coding tree
		HuffNode root= HuffmanTreeBuilder.build(freq);
		
		//assign codes to the bytes
		HashMap<Byte,String> codes=new HashMap<>();
		HuffmanCodeGenerator.generatecodes(root,"",codes);

		//create the output_file and write header and compress the file
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(outputfile));
		HuffmanHeader.write(dos, freq);
		HuffmanCompressor.compress("c.txt", dos, codes);
	}
}
