package huff;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HuffmanDecompressor {
	public static void decompress( DataInputStream dis,HuffNode root,int tf,String outputFile) throws IOException {
		BufferedOutputStream output=new BufferedOutputStream(new FileOutputStream(outputFile));
		BitInputStream bis =new BitInputStream(dis);
		HuffNode curr=root;
		int written=0;
		
		while(written<tf) {
			int bit=bis.bitread();
			
			if(bit==0) {
				curr=curr.left;
			}else {
				curr=curr.right;					
			}
			
			if(curr.left==null && curr.right==null) {
				output.write(curr.data);
				written++;
				curr=root;
			}
		}
		
		
		output.close();
		dis.close();
	}
}
