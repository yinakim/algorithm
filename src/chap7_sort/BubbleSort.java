package chap7_sort;

import java.util.Scanner;

/**
 * 버블정렬
 * 이웃한 두 요소의 대소관계를 비교하여 교환을 반복
 * 끝에서부터 앞쪽으로 (오른쪽에서 왼쪽으로) 스캔하면서 이웃하는 두 요소를 비교하고 교환
 */
public class BubbleSort {
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
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++)			// 맨앞 → 맨끝 순서로 스캔
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);
        }
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
