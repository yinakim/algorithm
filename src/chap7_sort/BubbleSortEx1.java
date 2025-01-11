package chap7_sort;

import java.util.Scanner;

/**
 * 버블정렬
 * 이웃한 두 요소의 대소관계를 비교하여 교환을 반복
 * 끝에서부터 앞쪽으로 (오른쪽에서 왼쪽으로) 스캔하면서 이웃하는 두 요소를 비교하고 교환
 */
public class BubbleSortEx1 {
    /** 배열 요소 교환 : a[idx]와 a[idx2] 요소를 교환 */
    static void swap(int[] a, int idx, int idx2) {
        int t = a[idx];
        a[idx] = a[idx2];
        a[idx2] = t;
    }

    /**
     *
     *
     *
     */
    static void bubbleSort(int[] a, int n) {
        int ccnt = 0;			// 비교 회수
        int scnt = 0;			// 교환 회수

        for (int i = 0; i < n - 1; i++) { // a[n] 배열에서 n-1개 요소의 정렬이 끝나면 마지막 요소는 이미 맨 끝에 있으므로 n-1 회 수행
            System.out.printf("패스%d : \n", i + 1);
            // --- 버블정렬의 패스 START
            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c" , a[m], (m != j-1) ? ' ' :
                            (a[j - 1] > a[j]) ? '+' : '-'); // 앞쪽이 크면 교환
                System.out.printf("%3d\n", a[n - 1]);

                ccnt++;
                if (a[j - 1] > a[j]) {
                    scnt++;
                    swap(a, j - 1, j);
                }
            }  // --- 버블정렬의 패스 END

            for (int m = 0; m < n; m++)
                System.out.printf("%3d  " , a[m]);
            System.out.println();
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환을 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순교환정렬(버블 정렬)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);				// 배열 x를 단순교환정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
