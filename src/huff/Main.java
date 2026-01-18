package huff;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		try {
			BufferedInputStream br=new BufferedInputStream(new FileInputStream("c.txt"));
			int x;
			HashMap<Byte,Integer> h=new HashMap<>(); 
			while((x=br.read())!=-1) {
				byte b=(byte)x;
				h.put(b, h.getOrDefault(b,0)+1);
			}
			br.close();
			PriorityQueue<HuffNode> pq =new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
			for(byte v:h.keySet()) {
				HuffNode ro=new HuffNode(v,h.get(v));
				pq.add(ro);
			}
			
			while(pq.size()>1) {
				HuffNode x1=pq.poll();
				HuffNode x2=pq.poll();
				HuffNode curr=new HuffNode((byte)0,x1.freq+x2.freq);
				curr.left=x1;
				curr.right=x2;
				pq.add(curr);
			}
			HuffNode root1=pq.poll();
			System.out.println("Root freq = "+root1.freq);
				
			HashMap<Byte,String> codes=new HashMap<>();
			generatecodes(root1,"",codes);
			
			for(byte v:codes.keySet()) {
				System.out.println("Byte "+v+" pattren is - "+codes.get(v));
			}
			
			DataOutputStream dos=new DataOutputStream(new FileOutputStream("com.huff"));
			dos.writeInt(h.size());
			for(byte v:h.keySet()) {
				dos.writeByte(v);
				dos.writeInt(h.get(v));
			}
			BitOutputStream bos=new BitOutputStream(dos);
			BufferedInputStream in=new BufferedInputStream(new FileInputStream("c.txt"));
			while((x=in.read())!=-1) {
				byte b=(byte)x;
				String s=codes.get(b);
				for(char ch:s.toCharArray()) {
					bos.bitwrite(ch=='1'?1:0);					
				}
			}
			bos.close();
			in.close();
			
			DataInputStream dis=new DataInputStream(new FileInputStream("com.huff"));
			int u=dis.readInt();
			int tf=0;
			HashMap<Byte,Integer> df=new HashMap<>(); 
			for(int i=0;i<u;i++) {
				byte b=dis.readByte();
				int f=dis.readInt();
				df.put(b,f);
				tf+=f;
			}
			
			PriorityQueue<HuffNode> dpq =new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
			for(byte v:df.keySet()) {
				HuffNode root=new HuffNode(v,df.get(v));
				dpq.add(root);
			}
			while(dpq.size()>1) {
				HuffNode x1=dpq.poll();
				HuffNode x2=dpq.poll();
				HuffNode curr=new HuffNode((byte)0,x1.freq+x2.freq);
				curr.left=x1;
				curr.right=x2;
				dpq.add(curr);
			}
			HuffNode root2=dpq.poll();
			
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("r.txt"));
			BitInputStream bis =new BitInputStream(dis);
			
			HuffNode curr=root2;
			int w=0;
			while(w<tf) {
				int bit=bis.bitread();
				if(bit==0) {
					curr=curr.left;
				}else {
					curr=curr.right;					
				}
				if(curr.left==null && curr.right==null) {
					out.write(curr.data);
					w++;
					curr=root2;
				}
			}
			
			
			out.close();
			dis.close();
		}catch(IOException e) {
		    e.printStackTrace();
		}

	}
	public static void generatecodes(HuffNode root,String c,HashMap<Byte,String> codes) {
		if(root==null) {
			return;
		}
		if(root.left==null && root.right==null) {
			codes.put(root.data, c);
			return;
		}
		generatecodes(root.left,c+"0",codes);
		generatecodes(root.right,c+"1",codes);
	}
}
