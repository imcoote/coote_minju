# DFS와 BFS [1260]
"""*******************************************************************************
 * 소요시간: 50분
 * 시간복잡도: O(M + N \log N + 2(N + M))
 * 메모리: 35584 kb
 * 시간: 320 ms
 *******************************************************************************"""

from collections import deque

# DFS
def dfs(v):
    stack = [v]
    while stack:
        node = stack.pop()
        if not visited[node]:  # 방문하지 않은 노드만 처리
            visited[node] = True
            print(node, end=' ')
            for i in reversed(graph[node]):  # 작은 정점부터 방문하도록 뒤집음
                if not visited[i]:
                    stack.append(i)

# BFS
def bfs(v):
    queue = deque([v])
    visited[v] = True  # 시작 노드 방문 처리
    while queue:
        node = queue.popleft()
        print(node, end=' ')
        for i in graph[node]:  # 인접 노드 탐색
            if not visited[i]:
                queue.append(i)
                visited[i] = True

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 각 정점의 인접 리스트를 정렬(정점 번호가 작은 것부터 방문)
for i in range(1, N + 1):
    graph[i].sort()

visited = [False] * (N + 1)
dfs(V)
print()

visited = [False] * (N + 1)
bfs(V)
