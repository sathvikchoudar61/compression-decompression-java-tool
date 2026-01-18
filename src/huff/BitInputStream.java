package huff;

import java.io.*;

public class BitInputStream {
	InputStream in;
	int cb=0,nb=0;
	
	BitInputStream(InputStream in){
		this.in=in;
	}
	
	public int bitread() throws IOException {
		if(nb==0) {
			cb=in.read();
			if(cb==-1) return -1;
			nb=8;
		}
		nb--;
		return (cb>>nb)&1;
	}
	
	public void close() throws IOException {
		in.close();
	}
	
}
