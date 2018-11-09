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
        
		if(intervals.length == 0){
			return 0;
		}
		
		if(intervals.length == 1){
			return 0;
		}
		
		// sort as per interval.end
		Arrays.sort(intervals, new Comparator<Interval>(){
				@Override
				public int compare(Interval interval1, Interval interval2){
					if(interval1.end != interval2.end){
						return interval1.end - interval2.end;
					}
					else{
						return interval1.start - interval2.start;
					}
				}
			}
		);
		
		//
		Interval preInterval = intervals[0];
		int count = 0;
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i].start < preInterval.end){
				count++;				
			}
            else{
                preInterval = intervals[i];
            }
		}
		return count;
    }
}
