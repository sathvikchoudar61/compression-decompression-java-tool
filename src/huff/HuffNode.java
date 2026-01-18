package huff;

public class HuffNode {
	byte data;
	int freq;
	HuffNode left,right;
	HuffNode(byte data,int freq){
		this.data=data;
		this.freq=freq;
		this.left=null;
		this.right=null;
	}
}
