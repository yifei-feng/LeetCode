/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        
		int n = intervals.length;
		
		if(n == 0){
			return 0;
		}
		
		if(n == 1){
			return 0;
		}
		
        // sort as per interval.end
		Arrays.sort(intervals, new Comparator<Interval>(){
				@Override
            
                /*
				public int compare(Interval interval1, Interval interval2){
					if(interval1.end != interval2.end){
						return interval1.end - interval2.end;
					}
					else{
						return interval1.start - interval2.start;
					}
				}
                */
            
                public int compare(Interval interval1, Interval interval2){
					if(interval1.start != interval2.start){
						return interval1.start - interval2.start;
					}
					else{
						return interval1.end - interval2.end;
					}
				}
			}
        );
        
        
		// memory[i]: the max number of proper intervals after checking intervals[i]
		int memory[] = new int[n];
		Arrays.fill(memory, 1);
		
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){				
				int newNum = memory[j];
				if(intervals[i].start >= intervals[j].end){
					newNum += 1;
				}				
				memory[i] = Math.max(memory[i], newNum);
			}
		}		
        
        int maxNumIntervals = 0;
        for(int num: memory){
			maxNumIntervals = (maxNumIntervals > num)? maxNumIntervals: num;
		}
        
		return intervals.length - maxNumIntervals;
    }
}
