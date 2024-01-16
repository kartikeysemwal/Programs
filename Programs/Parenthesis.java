/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Parenthesis {
    public static void main(String[] args) {
        // code
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char arr[] = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean run = false;
            for (int i = 0; i < arr.length; i++) {
                char cur = arr[i];

                if (cur == '(' || cur == '[' || cur == '{') {
                    stack.push(cur);
                    continue;
                }
                if (stack.size() == 0) {
                    run = true;
                    sb.append("not balanced").append("\n");
                    break;
                }
                if ((stack.peek() == '(' && cur == ')') || (stack.peek() == '{' && cur == '}')
                        || (stack.peek() == '[' && cur == ']')) {
                    stack.pop();
                } else {
                    break;
                }
            }
            if (stack.size() == 0) {
                if (!run)
                    sb.append("balanced").append("\n");
            } else {
                sb.append("not balanced").append("\n");
            }
        }
        System.out.print(sb);
    }
}