package huff;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class HuffmanHeader {
	
	public static void write(DataOutputStream dos,HashMap<Byte,Long> freq) throws IOException{
		dos.writeInt(freq.size());
		for(byte currentbyte:freq.keySet()) {
			dos.writeByte(currentbyte);
			dos.writeLong(freq.get(currentbyte));
		}
	}
	
	public static HashMap<Byte,Long> read(DataInputStream dis) throws IOException{
		HashMap<Byte,Long> freq=new HashMap<>();
		int unique=dis.readInt();
		
		for(int i=0;i<unique;i++) {
			byte currentbyte=dis.readByte();
			long freqofbyte=dis.readLong();
			freq.put(currentbyte,freqofbyte);
		}
		
		return freq;
	}
	
}
