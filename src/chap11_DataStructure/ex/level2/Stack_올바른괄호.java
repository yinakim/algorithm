package chap11_DataStructure.ex.level2;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909
// 고득점kit, Stack
public class Stack_올바른괄호 {
    private static boolean useSimpleSolution_정답(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) return false; // ')'가 먼저 나온 경우
        }

        return count == 0;
    }
    private static boolean useSimpleSolution_오답(String s) {
        /**
         ")(()" 같은 경우에도 마지막 문자가 ')'이므로 true가 반환될 수 있어 논리가 잘못됨
         문제에서 명시하지 않았지만 '올바른 괄호' 라고 하면 짝이 지어져야 한다고함.. ;;

         "(())("

         [오답케이스]

         "((())"
         "())(()"
         */
        char[] charArray = s.toCharArray();
        // [1] 맨앞글자가 닫는 소괄호면 무조건 false
        if(charArray[0] == ')') return false;

        // [2] 맨앞글자가 여는 소괄호면 ? 맨 끝 글자가 닫는 소괄호일 때 true / 여는 소괄호일 때 false
        return charArray[charArray.length-1] == ')' ? true : false;
    }
    private static boolean useStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c); // 짝이 정해지지 않은 원소는 스택에 추가하여 대기
                case ')' -> {
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }

        return stack.isEmpty(); // 모든 원소를 검사한 후, 스택이 비어있다면 ? 아직 짝을 찾지 못한 여는괄호'('가 있다는 의미
    }

    public static void main(String[] args) {
        /**
         입출력 예
         s	        answer
         "()()"	    true
         "(())()"	true
         ")()("	    false
         "(()("	    false
         */

        System.out.println(useStack("()()"));
        System.out.println(useStack("(())()"));
        System.out.println(useStack(")()("));
        System.out.println(useStack("(()("));
        System.out.println();

        System.out.println(useSimpleSolution_오답("()()"));
        System.out.println(useSimpleSolution_오답("(())()"));
        System.out.println(useSimpleSolution_오답(")()("));
        System.out.println(useSimpleSolution_오답("(()("));
        System.out.println("오답케이스, false나와야 함 : " + useSimpleSolution_오답("((())")); // true 나옴, 짝이 이루어지지 않은 ( 하나 남기 때문
        System.out.println("오답케이스, false나와야 함 : " + useSimpleSolution_오답("())(()")); // true 나옴, ")(" 같은 경우를 포함하여 괄호가 올바르게 닫히지 않음
        System.out.println();

        System.out.println(useSimpleSolution_정답("()()"));
        System.out.println(useSimpleSolution_정답("(())()"));
        System.out.println(useSimpleSolution_정답(")()("));
        System.out.println(useSimpleSolution_정답("(()("));
        System.out.println("오답케이스, false나와야 함 : " + useSimpleSolution_정답("((())"));
        System.out.println("오답케이스, false나와야 함 : " + useSimpleSolution_정답("())(()"));
        System.out.println();
    }
}
/**
 문제 설명
 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

 "()()" 또는 "(())()" 는 올바른 괄호입니다.
 ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

 제한사항
 문자열 s의 길이 : 100,000 이하의 자연수
 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 */