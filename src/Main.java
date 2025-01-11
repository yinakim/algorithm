import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s1 = "3people  unFollowed me";
        String s2 = "3people  unFollowed me";
        String[] str2 = s2.split(" ", -1);
        List<String> list = Arrays.stream(str2).toList();
        System.out.println(list.toString());
        System.out.println(list.get(1).length()); // 공백의 length는 0이다
        System.out.println(list.get(2).charAt(0)); // 맨앞글자가 공백일 때 charAt은 공백을 무시하고 맨 앞글자를 반환



        for (String s : list) {
            if(s.length() > 0 ) {
                char c0 = s.charAt(0);
                if(Character.isDigit(c0)){
                    Character.toLowerCase(s.charAt(1)); // 앞글자가 숫자면 숫자 다음글자를 소문자로
                } else {
                    Character.toLowerCase(s.charAt(0)); // 앞글자가 문자면 해당글자를 소문자로
                }


            }
        }




    }
}