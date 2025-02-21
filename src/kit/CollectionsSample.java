package kit;
import java.util.*;

/**
 *
 */
public class CollectionsSample {

    public static void main(String[] args) {
        /**
            1. List (ArrayList, LinkedList, Vector 등)
                - 순서가 있는 자료구조, 중복 허용
                - 구현체: ArrayList, LinkedList, Vector 등
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list); // [a, b, c]

        list.remove("a");
        list.remove(0);
        System.out.println(list); // [c]

        System.out.println(list.size()); // 1

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);

        // Collections.sort()사용해서 정렬
        // 오름차순
        Collections.sort(intList);
        System.out.println(intList); // [10, 20, 30, 40]

        // 내림차순
        Collections.sort(intList, Collections.reverseOrder());
        System.out.println(intList); // [40, 30, 20, 10]

        // List.sort()사용해서 정렬 - 오름차순
        intList.sort(Comparator.naturalOrder());
        System.out.println(intList); // [10, 20, 30, 40]

        // List.sort()사용해서 정렬 - 내림차순
        intList.sort(Comparator.reverseOrder());
        System.out.println(intList); // [40, 30, 20, 10]

        // 최대/최소값 구하기 - Collections 사용
        List<Integer> list2 = Arrays.asList(5, 2, 9, 1, 3);

        int max = Collections.max(list2);
        int min = Collections.min(list2);

        System.out.println("최대값: " + max); // 최대값: 9
        System.out.println("최소값: " + min); // 최소값: 1

        // 최대/최소값 구하기 - Stream API 사용
        int streamMax = list2.stream().max(Integer::compareTo).orElseThrow();
        int streamMin = list2.stream().min(Integer::compareTo).orElseThrow();
        System.out.println("Stream API 사용, 최대값: " + streamMax); // Stream API 사용, 최대값: 9
        System.out.println("Stream API 사용, 최소값: " + streamMin); // Stream API 사용, 최소값: 1


        /**
         * 2. Set (HashSet, TreeSet, LinkedHashSet 등)
            - 중복을 허용하지 않는 자료구조, 순서 보장 안 됨
            - 구현체: HashSet, TreeSet, LinkedHashSet 등
         */
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // 중복된 값 추가 안 됨
        System.out.println(set); // [Apple, Banana]

        set.remove("Apple");
        System.out.println(set); // [Banana]
        System.out.println(set.size()); // 1


        /**
         * 3. Queue (LinkedList, PriorityQueue 등)
            - FIFO(First-In-First-Out) 구조
            - 구현체: LinkedList, PriorityQueue 등
         */
        Queue<String> queue = new LinkedList<>();

        // 요소를 큐에 추가(중복허용) : add, offer
        queue.add("Apple"); // add() 사용하여 요소 추가 : 큐가 꽉 찬 경우 IllegalStateException 에러 발생

        // offer() 사용하여 요소 추가 : Queue.offer() 메서드는 큐가 꽉 차지 않았으면 요소를 추가하고 true 반환, 큐가 꽉 찼다면 false를 반환
        // 하지만 일반적인 LinkedList나 ArrayDeque 기반 Queue는 크기 제한이 없으므로, false를 반환하는 경우가 없음
        // (false를 반환하는 상황을 만들려면 유한한 크기를 가진 ArrayBlockingQueue 를 사용)
        queue.offer("Banana");
        queue.offer("Banana"); // 중복허용됨

        System.out.println("****************************"); // // [Apple, Banana]
        System.out.println(queue); // // [Apple, Banana]

        // 제거
        // remove(): 첫 번째 요소 제거, 없으면 예외 발생
        // poll(): 첫 번째 요소 제거, 없으면 null 반환
        String s = queue.remove();
        String poll = queue.poll();
        System.out.println("큐에서 remove한 요소 : "+s);
        System.out.println("큐에서 poll한 요소 : "+poll);
        System.out.println("요소를 2개 제거한 큐: "+queue); // []

        System.out.println(queue.size()); // 0

        /**
         * 4. Map (HashMap, TreeMap, LinkedHashMap 등)
            - Key-Value 형태의 자료구조
            - 구현체: HashMap, TreeMap, LinkedHashMap 등
           (Map은 Collection을 직접 구현하지 않지만, 관련 메서드를 포함하므로 추가 설명합니다.)
         */

        Map<String, Integer> map = new HashMap<>();
        map.put("apple",1);
        map.put("banana",2);
        System.out.println(map); // {banana=2, apple=1}

        map.remove("apple");
        System.out.println(map); // {banana=2}
        System.out.println(map.size()); // 1

        /** 저장된 데이터를 사용하기 위해서는 반복문을 사용하여 Map의 모든 key-value 쌍에 접근 */
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple",1);
        map2.put("banana",2);
        map2.put("orange",3);

        System.out.println("Map의 모든 key-value 쌍에 접근 1. keySet()과 for-each loop");
        // 장점: key만 필요한 경우 유용 / 단점 : value를 얻기 위해 get() 메서드를 추가로 호출해야 하므로 성능상 약간의 오버헤드
        for(String key: map2.keySet()) {
            Integer value = map2.get(key);
            System.out.println(key + ": " + value);
        }


        System.out.println("Map의 모든 key-value 쌍에 접근 2. entrySet()과 for-each loop");
        // 장점 : key와 value를 한 번에 얻을 수 있어 get() 메서드를 추가로 호출할 필요가 없음, keySet() 방식에 비해 약간의 성능향상
        // 단점 : Map.Entry 타입을 사용해야 하므로 코드 길이가 약간 길어짐
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }


        System.out.println("Map의 모든 key-value 쌍에 접근 3. Iterator");
        // 장점 : remove() 메서드를 사용하여 순회 중에 요소를 삭제할 수 있음
        // 단점 : 코드 길이가 길고 복잡
        Iterator<Map.Entry<String, Integer>> iterator = map2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        System.out.println("Map의 모든 key-value 쌍에 접근 4. forEach() 메서드 (Java 8 이상)");
        // 장점 : 람다 표현식을 사용, 간결하고 가독성이 좋은 코드, Java 8 이상에서 사용가능
        // 단점 : 순회 중에 요소를 삭제할 수 없음
        map2.forEach((key, value) -> System.out.println(key + ": " + value) );


        /**
         * TODO List 외 다른 Collection 들의 정렬 다시 정리하기
         */


        /**
         * Heap(힙)은 우선순위 큐(PriorityQueue) 를 구현하는 데 사용됨
         * 코딩 테스트에서 최소값/최대값을 빠르게 찾을 때 자주 활용
         *
         * PriorityQueue 사용, 최소 힙 / 최대 힙 구현가능
         * - 우선순위가 높은 요소 먼저 처리 (Heap)
         * - 최소 힙(기본), 최대 힙(Comparator 설정 필요) 구할 때 사용
         *
         * 완전 이진 트리(Complete Binary Tree) 구조
         * 최소 힙 (Min Heap): 루트 노드가 가장 작은 값을 가짐 → 우선순위가 낮은 값부터 제거
         * 최대 힙 (Max Heap): 루트 노드가 가장 큰 값을 가짐 → 우선순위가 높은 값부터 제거
         * Java의 PriorityQueue 기본 설정은 최소 힙
         */
        PriorityQueue pq = new PriorityQueue();

        pq.offer(10);
        pq.offer(5);
        pq.offer(30);
        pq.offer(1);

        System.out.println(pq.poll()); // 1 (최소값부터 꺼냄)
        System.out.println(pq.poll()); // 5
        System.out.println(pq.poll()); // 10
        System.out.println(pq.poll()); // 30

        // 최대 힙 만들기
        // Java의 PriorityQueue는 기본적으로 최소 힙이므로, 최대 힙을 만들려면 Comparator 를 사용
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(10);
        maxHeap.offer(3);
        System.out.println(maxHeap.poll()); // 10 (최대값)
        System.out.println(maxHeap.poll()); // 5
        System.out.println(maxHeap.poll()); // 3
        System.out.println(maxHeap.poll()); // 1
    }

}
