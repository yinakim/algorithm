package kit;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Hash2_L1_완주하지못한선수 {


    public static void main(String[] args) {

        /**
         입출력 예
         participant	completion	return
         ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
         ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
         ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
         */

        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        System.out.println(sol(participant, completion));
    }

    private static String sol(String[] participant, String[] completion) {
        /**
         * 참여한 선수들의 이름이 담긴 배열 participant
           완주한 선수들의 이름이 담긴 배열 completion

           완주하지 못한 선수의 이름을 return
         ------------------------------------
         * 참여한 선수의 수는 1명 이상 100,000명(십만명) 이하입니다. ===> 10000 개 이상이면 이중for 쓰면안됨
         * completion의 길이는 participant의 길이보다 1 작습니다.
         * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자
         * 참가자 중에는 동명이인이 있을 수 있습니다.
         */

        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        // 참가자 이름(key), 몇명(value) map에 저장
        for (String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1); // 동명이인이 있는 경우 +1해야되니까
        }

        // 완주자 이름에 해당되는 수를 map 에서 제거
        for(String c : completion){
            map.put(c, map.get(c) - 1);
        }

        // 인원수(value) > 1 인 이름(key) 반환
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0) return entry.getKey();
        }

        // 없는 경우 공백 리턴
        return answer;
    }

    // 다시풀기
    private static String sol2(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        // 참가자 이름(key), 인원수(val) 를 map에 추가
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0) + 1);

        }

        // 완주한 이름을 감소 : val - 1
        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        // map 모든 요소를 꺼내서 val > 0인 key값 리턴, 없으면 공백리턴
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }

        return answer;
    }

}
