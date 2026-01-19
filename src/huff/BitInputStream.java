package huff;

import java.io.*;

public class BitInputStream {
	InputStream input;
	int currentbyte=0;
	int numberofbits=0;
	
	BitInputStream(InputStream input){
		this.input=input;
	}
	
	public int bitread() throws IOException {
		if(numberofbits==0) {
			currentbyte=input.read();
			if(currentbyte==-1) return -1;
			numberofbits=8;
		}
		numberofbits--;
		return (currentbyte>>numberofbits)&1;
	}
	/*if we are starting we will take any entire byte and we set number of bits to 8 and 
	later we decrement that and right shift current byte with number of biits and get our
	wanted bit*/
	
	
	public void close() throws IOException {
		input.close();
	}
	
}
