package huff;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTreeBuilder {
	public static HuffNode build(HashMap<Byte,Long> frequency)  {
		PriorityQueue<HuffNode> pq =new PriorityQueue<>(Comparator.comparingLong(n -> n.freq));
		
		for(byte currentbyte:frequency.keySet()) {
			HuffNode root=new HuffNode(currentbyte,frequency.get(currentbyte));
			pq.add(root);
		}
		
		while(pq.size()>1) {
			HuffNode least=pq.poll();
			HuffNode secondleast=pq.poll();
			HuffNode curr=new HuffNode((byte)0,least.freq+secondleast.freq);
			curr.left=least;
			curr.right=secondleast;
			pq.add(curr);
		}
		return pq.poll();
	}
}
