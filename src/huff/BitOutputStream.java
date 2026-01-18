package huff;

import java.io.*;

public class BitOutputStream {
	OutputStream out;
	int cb=0,nf=0;
	BitOutputStream(OutputStream out){
		this.out=out;
	}
	public void bitwrite(int bit) throws IOException {
		cb=(cb<<1)|bit;
		nf++;
		if(nf==8) {
			out.write(cb);
			cb=0;
			nf=0;
		}
	}
	public void close() throws IOException {
		if(nf>0) {
			cb=cb<<(8-nf);
			out.write(cb);
		}
		out.close();
	}
	
}
