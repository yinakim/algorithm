# Collection 중복허용여부 / 순서유지 여부 정리

| 컬렉션 종류 | 중복 허용 | 순서 유지 | 설명                                                     |
|---|---|---|--------------------------------------------------------|
| **List** | O | O | 순서가 있는 데이터의 집합, 중복된 요소를 허용                           |
| - ArrayList | O | O | 배열 기반으로 구현된 List로, 동적 크기 조절이 가능                        |
| - LinkedList | O | O | 연결 리스트 기반으로 구현된 List로, 삽입/삭제가 효율적                      |
| - Vector | O | O | ArrayList와 유사하지만, 스레드 동기화를 지원                          |
| **Set** | X | X / O | 순서가 없는 데이터의 집합, 중복된 요소를 허용하지 않음                      |
| - HashSet | X | X | 해시 테이블 기반으로 구현된 Set, 빠른 검색 속도를 제공                      |
| - TreeSet | X | O | 정렬된 상태로 데이터를 저장하는 Set, 이진 검색 트리를 기반으로                  |
| - LinkedHashSet | X | O | HashSet과 유사하지만, 요소의 삽입 순서를 유지                          |
| **Map** | X (Key) / O (Value) | X / O | 키-값 쌍으로 데이터를 저장하는 컬렉션, 키는 중복될 수 없지만 값은 중복될 수 있음        |
| - HashMap | X (Key) / O (Value) | X | 해시 테이블 기반으로 구현된 Map, 빠른 검색 속도를 제공                    |
| - TreeMap | X (Key) / O (Value) | O | 정렬된 상태로 데이터를 저장하는 Map, 이진 검색 트리를 기반으로                |
| - LinkedHashMap | X (Key) / O (Value) | O | HashMap과 유사하지만, 요소의 삽입 순서를 유지                          |
| **Queue** | O | O | FIFO (First-In, First-Out) 방식으로 데이터를 관리하는 컬렉션          |
| - LinkedList | O | O | List 인터페이스를 구현하는 동시에 Queue 인터페이스도 구현하여 Queue로 사용될 수 있음 |
| - PriorityQueue | O | O | 우선순위 큐로, 요소의 우선순위에 따라 순서가 결정됨                          |
| - ArrayDeque | O | O | 배열 기반으로 구현된 덱(Deque), Queue와 Stack으로 모두 사용될 수 있음     |
| **Stack** | O | O | LIFO (Last-In, First-Out) 방식으로 데이터를 관리하는 컬렉션           |
| - Stack | O | O | Vector를 상속받아 구현된 Stack                                 |