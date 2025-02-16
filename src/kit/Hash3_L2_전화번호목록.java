package kit;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Hash3_L2_전화번호목록 { // 근데 해시 이용해서 풀면 개복잡함,, 그냥 for문돌려서 품
    public static void main(String[] args) {
        /**
         * 입출력 예제
         * phone_book	                        return
         * ["119", "97674223", "1195524421"]	false
         * ["123","456","789"]	                true
         * ["12","123","1235","567","88"]	    false
         */

        String[] phoneBook = new String[]{"119", "97674223", "1195524421"};
        String[] phoneBook2 = new String[]{"123","456","789"};
        String[] phoneBook3 = new String[]{"12","123","1235","567","88"};
        System.out.println(isStartWith(phoneBook));
        System.out.println(isStartWith(phoneBook2));
        System.out.println(isStartWith(phoneBook3));
    }

    private static boolean isStartWith(String[] phone_book) {
        Arrays.sort(phone_book); // 정렬해두면, 앞의 요소로 나머지 요소를 검사해서 바로 리턴할 수 있음

        for(int i = 0; i < phone_book.length-1 ; i++){ // 맨마지막 요소는 검사할 필요가 없으니까

            // 앞의 요소 대상, 나머지 뒤 요소중에 접두어로 포함되는 요소존재여부 확인
            String prefix = phone_book[i];
            if(phone_book[i+1].startsWith(prefix)) return false;
        }
        return true;
    }


}
