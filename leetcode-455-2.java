import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        if (g.length==0 || s.length==0)
            return 0;
        
		// sort
		Arrays.sort(g);
		Arrays.sort(s);
		
		// 
		int count = 0;
		
		// 
		int startSizeIndex = s.length - 1;
		for(int i=g.length - 1; i>=0; i--){
			for(int k = startSizeIndex; k>=0; k--){
				if(s[k] < g[i]){
					break;
				}
				else{
					count++;
					startSizeIndex--;
					break;
				}
			}
		}
		
		return count;
    }
}
