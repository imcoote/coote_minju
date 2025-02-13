"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N + M)
 * 메모리: 34924 kb
 * 시간: 56 ms
 *******************************************************************************"""
import sys
from collections import defaultdict, deque

input = sys.stdin.read
data = input().split()

n = int(data[0])  # 컴퓨터 수
m = int(data[1])  # 네트워크 연결 수

graph = defaultdict(list)

index = 2
for _ in range(m):
    a, b = int(data[index]), int(data[index + 1])
    graph[a].append(b)
    graph[b].append(a)
    index += 2

def bfs(start):
    queue = deque([start])
    visited = set([start])  # 방문한 노드 저장
    count = 0  # 감염된 컴퓨터 개수

    while queue:
        node = queue.popleft()
        for neighbor in graph[node]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
                count += 1  # 감염된 컴퓨터 개수 증가

    return count

print(bfs(1))