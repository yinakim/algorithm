### CHAPTER 11. 자주 등장하는 자료구조

## section 1. 스택, 큐
원소를 특정한 순서대로 삽입하고 제거할 수 있는 자료구조
  - Stack - FIFO / Queue - LIFO 
  - 원소삽입 : `add()`
  - 원소제거 : `stack.pop()` / `linkedList.poll()`
  - 자료구조가 비어있는지 검사 : `isEmpty()`   
  - 값을 제거하지 않고 가장 위(앞)에 있는 요소 얻기 : `peek()`

| 컬렉션 종류 | 중복 허용 | 순서 유지 | 설명                                                             |
|---|---|---|----------------------------------------------------------------|
| **Queue** | O | O | FIFO (First-In, First-Out) 방식으로 데이터를 관리하는 컬렉션                  |
| - LinkedList | O | O | 양방향 큐 / List 인터페이스를 구현하는 동시에 Queue 인터페이스도 구현하여 Queue로 사용될 수 있음 |
| - PriorityQueue | O | O | 우선순위 큐 / 요소의 우선순위에 따라 순서가 결정됨, Heap 구현시 사용                     |
| - ArrayDeque | O | O | 배열 기반으로 구현된 덱(Deque), Queue와 Stack으로 모두 사용될 수 있음               |
| **Stack** | O | O | LIFO (Last-In, First-Out) 방식으로 데이터를 관리하는 컬렉션                   |
| - Stack | O | O | Vector를 상속받아 구현된 Stack                                         |

* 참고) 덱 (dequeue) : 스택과 큐를 합쳐놓은 자료구조 (코테출제빈도 매우낮음)


## section 2. 그래프, 트리



## section 3. 그 외
### 3-1. 우선순위 큐
### 3-2. 투포인터
### 3-3. 유니온 파인드
### 3-4. 트라이