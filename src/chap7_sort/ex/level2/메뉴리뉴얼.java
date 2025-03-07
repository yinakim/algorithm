package chap7_sort.ex.level2;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/72411?language=java
/**
 단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다.
 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

 [문제]
 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders,
 "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
 TODO "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

 [제한사항]
 * orders 배열의 크기는 2 이상 20 이하입니다.
 * orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
 - 각 문자열은 알파벳 대문자로만 이루어져 있습니다.
 - 각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
 * course 배열의 크기는 1 이상 10 이하입니다.
 - course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
 - course 배열에는 같은 값이 중복해서 들어있지 않습니다.
 * 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
 - 배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
 - 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
 - orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
 */
public class 메뉴리뉴얼 {
    private static class Course{
        public final String courses;
        public final int occurrences;

        public Course(String courses, int occurrences) {
            this.courses = courses;
            this.occurrences = occurrences;
        }
    }

    /**
     * 재귀를 이용하여 만들수있는 모든 메뉴의 조합을 구한 후, 메뉴별 주문에서 등장한 횟수를 구하면
     * 문제 조건을 만족하는 메뉴 코스를 구할 수 있다.
     * 코스들을 알파벳 오름차순 순서로 정렬하여 반환한다.
     */
    public static String[] solution(String[] orders, int[] course) {

        List<Set<String>> orderList = Arrays.stream(orders)
                .map(String::chars)
                .map(charStream -> charStream
                        .mapToObj(menu -> String.valueOf((char)menu))
                        .collect(Collectors.toSet()))
                .collect(Collectors.toUnmodifiableList());

        Map<Integer, List<Course>> cources = new HashMap<>();
        for (int length : course) {
            List<Course> list = new ArrayList<>();
            list.add(new Course("",0));
            cources.put(length, list);
        }

        getCourses('A', new HashSet<>(), orderList, cources);

        return cources.values().stream()
                .filter(list -> list.get(0).occurrences > 0)
                .flatMap(List::stream)
                .map(c -> c.courses)
                .sorted()
                .toArray(String[]::new);
    }

    /**
     [모든 조합을 찾는 재귀 정의]
     * 하나의 재귀에서 하나의 메뉴가 조합에 포함될지 여부를 결정
     * 모든 메뉴에 대해 재귀 진행하면 문제조건을 만족하는 모든 조합을 구할 수 있음

     * nextMenu : 포함 여부를 결정할 메뉴
     * selectedMenus : 현재까지 선택한 메뉴 정보를 담은 배열
     * 종료조건
     * 1. 더 이상 조합할 메뉴가 없는 경우
     * 2. 조합의 등장 횟수 2회 미만인 경우
     */
    private static void getCourses(char nextMenu, Set<String> selectedMenus,
                                   List<Set<String>> orderList, Map<Integer, List<Course>> cources){
        int occurrences = (int) orderList.stream()
                .filter(order -> order.containsAll(selectedMenus))
                .count();

        if(occurrences < 2) return; // 종료조건 2

        int size = selectedMenus.size();
        if(cources.containsKey(size)){
            List<Course> courseList = cources.get(size);
            Course course = new Course(
                    selectedMenus.stream()
                            .sorted()
                            .collect(Collectors.joining(""))
                    , occurrences);

            Course original = courseList.get(0);

            if(original.occurrences < occurrences) {
                courseList.clear();
                courseList.add(course);
            } else if (original.occurrences == occurrences){
                courseList.add(course);
            }
        }

        if(size >= 10) return;
        for (char menuChar = nextMenu; menuChar < 'Z'; menuChar++) {
            String menu = String.valueOf(menuChar);
            selectedMenus.add(menu);

            getCourses((char) (menuChar+1), selectedMenus, orderList, cources);
            selectedMenus.remove(menu);
        }
    }

    public static void main(String[] args) {
        /**
         * [입출력 예]
         * orders	                                            course	    result
         * ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	    [2,3,4]	    ["AC", "ACDE", "BCFG", "CDE"]
         * ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	    ["ACD", "AD", "ADE", "CD", "XYZ"]
         * ["XYZ", "XWY", "WXA"]	                            [2,3,4]	    ["WX", "XY"]
         */

        String[] orders1 = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = new int[]{2,3,4};
        String[] orders2 = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = new int[]{2,3,5};
        String[] orders3 = new String[]{"XYZ", "XWY", "WXA"};
        int[] course3 = new int[]{2,3,4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
        System.out.println(Arrays.toString(solution(orders2, course2)));
        System.out.println(Arrays.toString(solution(orders3, course3)));
    }
}