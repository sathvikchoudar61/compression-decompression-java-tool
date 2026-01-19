package huff;

import java.util.HashMap;

public class HuffmanCodeGenerator {
	public static void generatecodes(HuffNode root,String code,HashMap<Byte,String> codes) {
		if(root==null) return;
		
		if(root.left==null && root.right==null) {
			if (code.length() == 0) {
                code = "0";
            }
			codes.put(root.data, code);
			return;
		}
		
		generatecodes(root.left,code+"0",codes);
		generatecodes(root.right,code+"1",codes);
	}
}
