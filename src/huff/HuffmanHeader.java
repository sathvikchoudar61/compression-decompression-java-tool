package huff;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanHeader {
	
	public static void write(DataOutputStream dos,HashMap<Byte,Integer> freq) throws IOException{
		dos.writeInt(freq.size());
		for(byte currentbyte:freq.keySet()) {
			dos.writeByte(currentbyte);
			dos.writeInt(freq.get(currentbyte));
		}
	}
	
	public static HashMap<Byte,Integer> read(DataInputStream dis) throws IOException{
		HashMap<Byte,Integer> freq=new HashMap<>();
		int unique=dis.readInt();
		
		for(int i=0;i<unique;i++) {
			byte currentbyte=dis.readByte();
			int freqofbyte=dis.readInt();
			freq.put(currentbyte,freqofbyte);
		}
		
		return freq;
	}
	
}
