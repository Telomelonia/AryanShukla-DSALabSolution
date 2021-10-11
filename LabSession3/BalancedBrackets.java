package LabSession3;
import java.util.*;
public class BalancedBrackets {

	static boolean balanced(String str)
	{
		// Using ArrayDeque rather than using Stack class
		Deque<Character>stack = new ArrayDeque<Character>();
		// Traversing the string
		for(int i=0;i<str.length();i++)
		{
			char x = str.charAt(i);
			
			if(x == '(' || x=='[' || x == '{') {
				// Push the element in the stack
				stack.push(x);
				continue;
			}
			/*If current character is not opening bracket, 
			then it must be closing -> stack will not be empty*/
			
			if(stack.isEmpty())
			{
				return false;
			}
			char target;
			
			switch(x) 
			{
			case')':
				target = stack.pop();
				if(target == '{' || target == '[')
					return false;
				break;
				
			case '}':
				target = stack.pop();
				if(target == '(' || target == ']')
					return false;
				break;
				
			case ']' :
				target = stack.pop();
				if(target == '(' || target == '{')
					return false;
				break;
			}
			
		}
		return (stack.isEmpty());
	}
	


	//Driver code
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		if(balanced(str))
		{
			System.out.println("The entered String has Balanced Brackets");
		}
		else
		{
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}

}
