package doit.basic.search;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2343
public class Bj_2343_기타레슨 {
    public static void main(String[] args) {
        /**
         예제입력
9 3
1 2 3 4 5 6 7 8 9

         예제출력
         17
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            if(start < A[i]) start = A[i]; // 레슨 최대값을 시작인덱스로 저장
            end = end + A[i];              // 모든 레슨의 총합을 종료인덱스로 저장
        }

        while (start <= end) {
            int middle = (start+end)/2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) { // middle 값으로 모든 레슨을 저장할 수 있는지 확인
                if(sum + A[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }
            if(sum != 0) {
                count++;  // 탐색 후 sum != 0 이면 블루레이 1개 더 필요하므로 더함
            }
            if (count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
