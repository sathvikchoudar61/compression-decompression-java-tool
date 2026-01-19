package huff;

public class HuffNode {
	byte data;
	long freq;
	HuffNode left,right;
	HuffNode(byte data,long freq){
		this.data=data;
		this.freq=freq;
		this.left=null;
		this.right=null;
	}
}
