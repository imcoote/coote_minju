"""*******************************************************************************
 * 소요시간: 3시간
 * 시간복잡도: O(N)
 * 메모리: 52896 kb
 * 시간: 312 ms
 *******************************************************************************"""
import sys
from collections import deque

input = sys.stdin.readline # 입력 속도 향상을 위해 sys.stdin.readline 사용

n = int(input())

# 인접 리스트(그래프 연결 관계)를 빈 리스트로 초기화
lst = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

parent_lst = [0] * (n + 1)

# 트리의 루트 노드는 1번 노드로 설정하고 큐에 추가
queue = deque([1])

while queue:
    node = queue.popleft()

    for neighbor in lst[node]:
        if parent_lst[neighbor] == 0:# 부모 노드가 아직 설정되지 않은 경우
            parent_lst[neighbor] = node
            queue.append(neighbor)# neighbor를 큐에 추가하여 다음 탐색 대상에 포함

for i in range(2, n + 1):
    print(parent_lst[i])

