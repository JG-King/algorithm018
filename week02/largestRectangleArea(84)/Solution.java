class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        //数组前后加入0，这样所有元素从栈中都可以弹出来计算面积
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            //当栈内元素比当前元素小于或等于的时候
            while(!stack.isEmpty() && tmp[stack.peek()] > tmp[i]){
                int left = stack.pop();
                int areaLen = i - stack.peek() -1;
                area = Math.max(area,areaLen * tmp[left]);
            }
            stack.push(i);
        }

       
        return area;
    }
}