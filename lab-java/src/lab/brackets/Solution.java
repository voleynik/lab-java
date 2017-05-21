package lab.brackets;
import java.util.Stack;

class Solution {

	public int solution(String s){

		Stack<Character> stk = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c == '[' || c == '(' || c == '{' ) {
                stk.push(c);
            }else if(c == ']') {
                if(stk.isEmpty()) 	return 0;
                if((char)stk.pop() != '[') return 0;
            }else if(c == ')') {
                if(stk.isEmpty()) return 0;
                if((char)stk.pop() != '(') return 0;
            }else if(c == '}') {
                if(stk.isEmpty()) return 0;
                if((char)stk.pop() != '{') return 0;
            }
        }
		
        return stk.isEmpty() ? 1 : 0;
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int result = -1;
		
		String input = "";// 1
		result = s.solution(input);
		System.out.println("Brackets " + result);
		
		input = "{[()()]}";// 1
		result = s.solution(input);
		System.out.println("Brackets " + result);
		
		input = "([)()]";// 0
		result = s.solution(input);
		System.out.println("Brackets " + result);
	}
}