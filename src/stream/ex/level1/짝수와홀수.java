package stream.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12937
public class 짝수와홀수 {
    public static String solution(int num) {
        return num%2 == 0 ? "Even" : "Odd" ;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
