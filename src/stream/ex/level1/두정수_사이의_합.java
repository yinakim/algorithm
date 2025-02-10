package stream.ex.level1;

import java.util.stream.LongStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/12912
public class 두정수_사이의_합 {
    public static void main(String[] args) {
        /**
         * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
         *
         * 입출력 예
         * a	b	return
         * 3	5	12
         * 3	3	3
         * 5	3	12
         */

        // 12, 3, 12, -49, -49
        System.out.println(rangeSumPositiveOnly(3,5));
        System.out.println(rangeSumPositiveOnly(3,3));
        System.out.println(rangeSumPositiveOnly(5,3));
        System.out.println(rangeSumPositiveOnly(-10,3)); // 음수테스트
        System.out.println(rangeSumPositiveOnly(3,-10)); // 음수테스트

        // 12, 3, 12, -49, -49
        System.out.println();
        System.out.println(rangeSum(3,5));
        System.out.println(rangeSum(3,3));
        System.out.println(rangeSum(5,3));
        System.out.println(rangeSum(-10,3)); // 음수테스트
        System.out.println(rangeSum(3,-10)); // 음수테스트
        System.out.println(rangeSum(-3,10)); // 음수테스트

        // 12, 3, 12, -49, -49
        System.out.println();
        System.out.println(rangeSumOfficial(3,5));
        System.out.println(rangeSumOfficial(3,3));
        System.out.println(rangeSumOfficial(5,3));
        System.out.println(rangeSumOfficial(-10,3)); // 음수테스트
        System.out.println(rangeSumOfficial(3,-10)); // 음수테스트
    }

    // [성공] 대소비교 자리바꾸기
    private static long rangeSumPositiveOnly(int a, int b) {
        // return LongStream.range(a,b).sum(); // 7, 0, 0 리턴 ) startInclusive >= endExclusive 인경우 0 리턴하기 때문,
                                              // 그리고 endExclusive-1까지만 sum 되기때문에 안됨 3+4+5=12 여야하는데 3+4=7을 리턴함
        // return LongStream.rangeClosed(a,b).sum(); // 12, 3, 0 리턴 ) startInclusive > endInclusive 인 경우 0 리턴하기 때문

        long sum = 0;
        // a >= b 인경우 자리바꾸고 rangeClosed 사용
        if(a >= b) {
            int temp = a;
            a = b;
            b = temp;
        }
        sum = LongStream.rangeClosed(a, b).sum();
        return sum;
    }

    // [성공] Math min, max 이용
    private static long rangeSum(int a, int b) {
        if (a == b) return a;
        return LongStream.rangeClosed(Math.min(a,b), Math.max(a,b)).sum();
    }

    // [성공] Math min, max + 등차수열의 합공식 이용
    private static long rangeSumOfficial(int a, int b) {
        if (a == b) return a;

        long sum = 0;
        long min = Math.min(a, b);
        long max = Math.max(a, b);
        sum = (max - min + 1) * (min + max) / 2;
        return sum;
    }

}
