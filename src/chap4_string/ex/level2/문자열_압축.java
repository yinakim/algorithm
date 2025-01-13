package chap4_string.ex.level2;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class 문자열_압축 {
    /* [1] 문자열을 length단위로 잘라 List에 담아 반환 */
    private List<String> splitSrc(String source, int length){
        List<String> tokens = new ArrayList<>();
        for (int startI=0; startI < source.length(); startI += length){
            int endI = startI + length;
            if(endI > source.length()) endI = source.length(); // 범위 벗어나면 최대길이로 한정

            tokens.add(source.substring(startI, endI)); // source를 length단위로 짤라서 token리스트에 추가
        }
        return tokens;
    }

    /* [2] length단위로 압축한 문자열의 길이를 반환 */
    private int compress(String source, int length){
        StringBuilder builder = new StringBuilder();

        String last = "";
        int cnt = 0;

        for (String token : splitSrc(source, length)){
            // 압축문자열 구성
            if(token.equals(last)) {
                cnt++;
            } else {
                if(cnt > 1) builder.append(cnt);
                builder.append(last);
                last = token; // 새로운 token으로 업데이트처리
                cnt = 1;      // 다시 cnt 초기화
            }
        }

        // 마지막 토큰 처리
        if(cnt > 1) builder.append(cnt);
        builder.append(last);

        // 압축된 문자열 최종 길이 리턴
        return builder.length();
    }

    /* 1~문자열전체길이까지, [1-2]를 반복하여 최소값 반환 */
    public int solution(String s) {
        int min = Integer.MAX_VALUE; // 가장 짧은 압축 문자열 담을 리턴값 변수

        for(int len = 1; len <= s.length(); len++){
            int compressed = compress(s, len);
            if (compressed < min) min = compressed; // 더 작은 값으로 업데이트
        }
        return min;
    }
}
