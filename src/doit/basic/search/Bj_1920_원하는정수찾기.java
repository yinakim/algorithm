package doit.basic.search;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1920
public class Bj_1920_원하는정수찾기 {
    public static void main(String[] args) {
        /**
         예제입력
         5
         4 1 5 2 3
         5
         1 3 7 9 5
         -----------
         예제 출력
         5
         4 1 5 2 3
         5
         1 3 7 9 5
         */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N개의 정수로 이루어진 배열A 생성
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();

        }

        /** 이진탐색을 하기 위해 반드시 정렬 */
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();

            /** 이진탐색 시작 */
            int start = 0;
            int end = A.length -1;
            while (start <= end) {
                int mid1 = (start + end) / 2; // 중앙값 찾기 공식
                int mid2 = A[mid1]; // 임시 중앙값, target과 비교해서 갱신될 임시중앙값

                /** [중앙값 < target] 인 경우, [중앙값-1]으로 엔드값 설정 */
                if (mid2 > target) {
                    end = mid1 -1;

                /** [target < 중앙값] 인 경우, [중앙값+1]으로 시작값 설정 */
                } else if (mid2 < target) {
                    start = mid1 + 1;

                /** [중앙값 == target], 탐색종료 */
                } else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1); // 문제에서 요구, 값이 존재할 경우 1출력
            } else {
                System.out.println(1); // 문제에서 요구, 값이 존재하지 않을 경우 0출력
            }
        }

    }
}
