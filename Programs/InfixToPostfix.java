/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class InfixToPostfix {
    public static int preced(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        // code
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.toString();

        for (int t = 0; t < testCases; t++) {
            String str = sc.nextLine();
            char arr[] = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                char cur = arr[i];
                if (Character.isLetterOrDigit(cur)) {
                    sb.append(cur);
                    continue;
                }
                if (stack.size() == 0) {
                    stack.push(cur);
                    continue;
                }
                if (cur == '(' || preced(stack.peek()) < preced(cur)) {
                    stack.push(cur);
                    continue;
                }
                if (cur == ')') {
                    char remove = stack.pop();
                    while (remove != '(') {
                        sb.append(remove);
                        remove = stack.pop();
                    }
                    continue;
                }
                while (stack.size() > 0 && preced(stack.peek()) >= preced(cur) && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(cur);
            }
            while (stack.size() > 0) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}