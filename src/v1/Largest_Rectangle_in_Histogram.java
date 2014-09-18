package v1;
import java.util.Stack;
public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] height) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int top ;
    	int length = height.length;
    	int max = 0;
    	int i=0;
    	while(i < length){
    		if(stack.empty() || height[stack.peek()] <= height[i])
    			stack.push(i++);
    		else{
    			top = stack.pop();
    			max = Math.max(max, height[top]*(stack.empty() ? i : i-stack.peek()-1));  			
    		}
    	}
    	while(!stack.empty()){
    		top = stack.pop();
    		max = Math.max(max, height[top]*(stack.empty() ? i : i-stack.peek()-1));  	
    	}
    	return max;

    }
    
	public static void main(String[] args) {
		int heigh[] = {2,1,5,6,2,3};
		System.out.println(new Largest_Rectangle_in_Histogram().largestRectangleArea(heigh));
		// TODO Auto-generated method stub

	}

}
