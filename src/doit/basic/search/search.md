# 1. DFS - Deepth First Search   

# 2. BFS - Breadth First Search   

# 3. Binary Search, 이진탐색
- 데이터가 **정렬된 상태**에서 원하는 값을 찾아내는 알고리즘
- 이진탐색 과정
1. 현재 데이터의 중앙값(median)을 찾는다
2. target data < 중앙값 이면, 중앙값 기준 왼쪽 데이터셋을 선택 (시작 ~ 중앙값-1 까지 대상으로 다시 탐색) 
3. 중앙값 < target data 이면, 중앙값 기준 오른쪽 데이터셋을 선택 (중앙값 +1 ~ 끝 까지 대상으로 다시 탐색)
4. 앞의 1~3 과정을 반복, **중앙값 == target data** 일 때 탐색 종료