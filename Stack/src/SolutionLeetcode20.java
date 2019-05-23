import java.util.Stack;

public class SolutionLeetcode20 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if(topChar == '(' && c != ')')
                    return false;
                if(topChar == '[' && c != ']')
                    return false;
                if(topChar == '{' && c != '}')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
