package solutions;

public class MaxAverageSubarray {

	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
    public double findMaxAverage(int[] nums, int k) {
        double l=Integer.MIN_VALUE,r=Integer.MAX_VALUE;
        while (r-l>0.000004) //Binary search the answer
        {
            double mid=(l+r)/2;
            if (check(nums,k,mid)) l=mid; else r=mid;
        }
        return r;
    }
    
    private boolean check(int[] nums,int k,double x) //Check whether we can find a subarray whose average is bigger than x
    {
        int n=nums.length;
        double[] a=new double[n];
        for (int i=0;i<n;i++) a[i]=nums[i]-x; //Transfer to a[i], find whether there is a subarray whose sum is bigger than 0
        double now=0,last=0;
        for (int i=0;i<k;i++) now+=a[i];
        if (now>=0) return true;
        for (int i=k;i<n;i++)
        {
            now+=a[i];
            last+=a[i-k];
            if (last<0) 
            {
                now-=last;
                last=0;
            }
            if (now>=0) return true;
        }
        return false;
    }
	
}
