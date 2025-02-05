package doit.basic.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 합배열 공식(원본배열 A, 합배열S)    S[i] = S[i-1] + A[i]
 * 2. 구간합 공식(i~j 구간)            S[j] - S[i]
 */
// https://www.acmicpc.net/problem/11659
public class 구간합 {
    public static void main(String[] args) throws IOException {

        /**
         입력 예
5 3
5 4 3 2 1
1 3
2 4
5 5


         출력 예
         12
         9
         1

         */
        // 배열길이(N), 질의 개수(M) 저장하기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // 배열 입력받기
        tokenizer = new StringTokenizer(bufferedReader.readLine());

        // 합배결 초기화, 1,000보다 작거나 같은 자연수
        long[] S = new long[N+1];

        // 배열 길이만큼 반복, 합배열 생성작업
        System.out.println();
        for (int i = 1; i<=N; i++) {
            // S[i] = S[i-1] + A[i]
            int a = Integer.parseInt(tokenizer.nextToken());
            int aIndex = i-1;
            System.out.println("원본배열 A["+ aIndex +"] = " + a);

            S[i] = S[i-1] + a;
        }
        System.out.println("합배열 S : " + Arrays.toString(S));

        // 질의 개수만큼 반복, 구간 입력받아 구간합 구하기
        for (int m = 0; m < M; m++) {
            // 구간값 입력받기
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(tokenizer.nextToken());
            int j = Integer.parseInt(tokenizer.nextToken());

            // 구간합 구하기
            System.out.println(S[j] - S[i - 1]);
        }

        /* test 결과
        원본배열 A[0] = 5
        원본배열 A[1] = 4
        원본배열 A[2] = 3
        원본배열 A[3] = 2
        원본배열 A[4] = 1
        합배열 S : [0, 5, 9, 12, 14, 15]
        12
        9
        1
         */
    }

}
