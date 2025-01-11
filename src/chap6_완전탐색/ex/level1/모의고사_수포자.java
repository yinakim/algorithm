package chap6_완전탐색.ex.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 모의고사_수포자 {
    // 수포자 1~3 각자 문제 찍는 패턴
    private static final int[][] RULES = {
            {1, 2, 3, 4, 5}
            ,{2, 1, 2, 3, 2, 4, 2, 5}
            ,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    /* 각 문제번호당 몇번 수포자가 정답을 몇으로 찍었는지 구하는 메서드 */
    private static int getPicked(int person, int quiz){
        int[] rule = RULES[person];
        int i = quiz % rule.length;
        return rule[i];
    }

    public static int[] solution(int[] answers) {
        int[] corrects = new int[3]; // 각 수포자 별 정답배열
        int max = 0; // 그래서 가장 많은 정답이 몇개인지

        for (int quiz=0; quiz < answers.length; quiz++){
            int answer = answers[quiz];
            for(int person=0; person < RULES.length; person++){
                if(answer == getPicked(person, quiz)){
                    if(++corrects[person] > max) max = corrects[person]; //max 업데이트
                }
            }
        }

        // 가장 많은 정답을 가진 수포자 번호 리턴
        final int maxCorrects = max;
        return IntStream.range(0, 3) // 수포자 1~3
                .filter(i -> corrects[i] == maxCorrects)
                .map(i -> i + 1)
                .toArray();
    }

    // ------------------ test ------------------ //
    public static void main(String[] args) {
        /**
         입출력 예
         answers	    return
         [1,2,3,4,5]	[1]
         [1,3,2,4,2]	[1,2,3]
         */
        int[] array = {1,2,3,4,5};
        int[] array2 = {1,3,2,4,2};

        int[] solution1 = solution(array);
        int[] solution2 = solution(array2);
        System.out.println("**************************");
        System.out.println(Arrays.toString(solution1));
        System.out.println(Arrays.toString(solution2));
    }
}
