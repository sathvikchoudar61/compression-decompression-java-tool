package huff;

import java.io.*;

public class BitOutputStream {
	OutputStream output;
	int currentbyte=0;
	int numberofbits=0;
	
	BitOutputStream(OutputStream output){
		this.output=output;
	}
	
	public void bitwrite(int bit) throws IOException {
		currentbyte=(currentbyte<<1)|bit;
		numberofbits++;
		if(numberofbits==8) {
			output.write(currentbyte);
			currentbyte=0;
			numberofbits=0;
		}
	}
	
	public void close() throws IOException {
		if(numberofbits>0) {
			currentbyte=currentbyte<<(8-numberofbits);
			output.write(currentbyte);
		}
		output.close();
	}
	
}
