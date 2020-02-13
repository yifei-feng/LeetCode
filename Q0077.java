// https://leetcode.com/problems/combinations/

/*
Note:

1) in a recursion, future number > current number

2) termination criteria: either list size == number limit or current number > end number


*/


class Solution {
    
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private int endNumber; 
    
    private int limit;
        
    public List<List<Integer>> combine(int n, int k) {
        endNumber = n;
        limit = k;
        if(n > 0 && k > 0){
            doCombination(1, new ArrayList<Integer>());
        }
        return result;
    }
    
    private void doCombination(int currentStart, List<Integer> previousList){
        if(previousList.size() == limit){
            result.add(previousList);
            return;
        }
        
        if(currentStart > endNumber){
            return;
        }
        
        for(int i = currentStart; i <= endNumber; i++){
            List<Integer> currentList = new ArrayList<Integer>(previousList);
            currentList.add(i);
            doCombination(i + 1, currentList);
        }
    }
    
}
