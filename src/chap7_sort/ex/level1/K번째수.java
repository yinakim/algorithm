package chap7_sort.ex.level1;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int n=0; n < answer.length; n++){
            int[] command = commands[n]; // [i,j,k]

            // 배열 인덱스는 0기반
            int i = command[0]-1;
            int j = command[1];
            int k = command[2]-1;

            int[] sub = Arrays.copyOfRange(array, i, j); // i부터 j까지 자른 배열
            Arrays.sort(sub);
            answer[n] = sub[k]; // k번째 숫자 구해서 정답배열에 넣기
        }

        // k번째 수만 들어간 배열리턴
        return answer;
    }

    // ------------------ test ------------------ //
    public static void main(String[] args) {
        /**
         * 입력
         * array [1, 5, 2, 6, 3, 7, 4]
         * command [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
         * 출력
         * [5, 6, 3]
         */
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(array, commands);
        System.out.println(Arrays.toString(solution));
    }
}
