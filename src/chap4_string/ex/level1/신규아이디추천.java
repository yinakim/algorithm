package chap4_string.ex.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class 신규아이디추천 {
    public static String solution(String new_id) {

        String newId = "";
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        newId = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        newId = newId.replaceAll("\\.+",".");
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        newId = newId.replaceAll("^\\.+|$\\.+","");
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        newId = newId.isEmpty() ? "a" : newId;
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(16 <= newId.length()) newId = newId.substring(0,15);
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        newId = newId.replaceAll("\\.+$","");
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        //if(2 >= newId.length()) {        }
        while(3 > newId.length()) {
            newId += newId.charAt(newId.length()-1);
        }

        return newId;
    }


    public static void main(String[] args) {

        /**
         입출력 예
         no	    new_id	                        result
         예1	    "...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
         예2	    "z-+.^."	                    "z--"
         예3	    "=.="	                        "aaa"
         예4	    "123_.def"	                    "123_.def"
         예5	    "abcdefghijklmn.p"              "abcdefghijklmn"
         */

        System.out.println("예1 : " + solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("예2 : " + solution("z-+.^."));
        System.out.println("예3 : " + solution("=.="));
        System.out.println("예4 : " + solution("123_.def"));
        System.out.println("예5 : " + solution("abcdefghijklmn.p"));
    }
}
