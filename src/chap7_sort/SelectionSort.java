package chap7_sort;

import java.util.Scanner;

/**
 * 단순 선택 정렬
 * 가장 작은 요소부터 선택해 알맞은 위치로 옮겨서 순서대로 정렬하는 알고리즘
 * 단순선택정렬의 경우, 서로 떨어진 idx번째 요소와 min번째 요소를 교환하는 것이므로 안정적이지 않을 수 있음 (키값중복될 경우 뒤바뀔 수 있음)
 */
public class SelectionSort {
    /** 배열 요소 교환 : a[idx]와 a[idx2] 요소를 교환 */
    static void swap(int[] a, int idx, int idx2) {
        int t = a[idx];
        a[idx] = a[idx2];
        a[idx2] = t;
    }

    /**
     * 선택정렬
     * 1. 아직 정렬되지 않은 부분에서 가장 작은 키값 a[min]을 선택
     * 2. a[min]과 아직 정렬하지 않은 부분의 첫번째 요소를 교환
     */
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            // [1] 아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스 min 찾기
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }

            for (int m = 0; m < n; m++) {
                System.out.print((m == i) ? "  * " : (m == min) ? "  + " : "    ");
            }
            System.out.println();
            for (int m = 0; m < n; m++) {
                System.out.printf("%3d ", a[m]);
            }
            System.out.println("\n");

            // [2] 아직 정렬되지 않은 부분의 맨앞 요소 a[i]와 가장 작은 요소 a[min]를 교환
            swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("단순선택정렬");
        System.out.print("요소 수 : ");
        int nx = stdIn.nextInt();

        int[] x = new int[nx];
        for (int i=0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx); // 선택정렬 실행

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]＝" + x[i]);
        }

    }

}
