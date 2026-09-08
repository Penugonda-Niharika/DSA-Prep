// Source - https://stackoverflow.com/q/30940246
// Posted by anonymous, modified by community. See post 'Timeline' for change history
// Retrieved 2026-09-09, License - CC BY-SA 3.0

public class Solution {
    public int trap(int[] height) {
        if (height.length <=2 )
            return 0;
        int h = 0, sum = 0, i = 0, j = height.length - 1;
        while(i < j)
        {
            if ( height[i] < height[j] )
            {
                h = Math.max(h,height[i]);
                sum += h - height[i];
                i++;
            }
            else
            {   
                h = Math.max(h,height[j]);
                sum += h - height[j];
                j--;
            }
        }
        return sum;
    }
}
