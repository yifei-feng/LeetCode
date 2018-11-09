import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Integer[] gArray = new Integer[g.length];
        for(int i=0; i<g.length; i++){
            gArray[i] = g[i];
        }
        Integer[] sArray = new Integer[s.length];
        for(int i=0; i<s.length; i++){
            sArray[i] = s[i];
        }
        
		// sort
		Arrays.sort(gArray, Collections.reverseOrder());
		Arrays.sort(sArray, Collections.reverseOrder());
		
		// 
		int count = 0;
		
		// 
		int startSizeIndex = 0;
		for(int greed: gArray){
			for(int i = startSizeIndex; i < sArray.length; i++){
				if(sArray[i] < greed){
					break;
				}
				else{
					count++;
					startSizeIndex++;
					break;
				}
			}
		}
		
		return count;
    }
}
