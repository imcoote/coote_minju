# 유기농 배추[1012]
"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(n×m)
 * 메모리: 34968 kb
 * 시간: 228 ms
 *******************************************************************************"""
from collections import deque

T = int(input())

def bfs(x, y):
    global cab_farm
    queue = deque([(x, y)])
    cab_farm[x][y] = 0  # 방문 처리

    while queue:
        cx, cy = queue.popleft()

        # 상하좌우 방향으로 탐색
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = cx + dx, cy + dy

            if 0 <= nx < n and 0 <= ny < m and cab_farm[nx][ny] == 1:
                cab_farm[nx][ny] = 0  # 방문 처리
                queue.append((nx, ny))

    return True

for _ in range(T):
    m, n, cab_cnt = map(int, input().split())

    cab_farm = [[0] * m for _ in range(n)]

    # 배추 위치 설정
    for _ in range(cab_cnt):
        a, b = map(int, input().split())
        cab_farm[b][a] = 1

    result_cnt = 0

    # BFS 탐색
    for i in range(n):
        for j in range(m):
            if cab_farm[i][j] == 1:
                if bfs(i, j):
                    result_cnt += 1

    print(result_cnt)

# 처음에는 재귀로 풀었는데 런타임 에러나서 큐로 변경
# T = int(input())
#
# def bfs(x, y):
#     global cab_farm
#     if x < 0  or x >= n or y < 0 or y >= m:
#         return False
#
#     if cab_farm[x][y] == 1:
#         cab_farm[x][y] = 0
#         bfs(x + 1, y)
#         bfs(x - 1, y)
#         bfs(x, y + 1)
#         bfs(x, y - 1)
#         return True
#     return False
#
# for _ in range(T):
#     m, n, cab_cnt = map(int, input().split())
#
#     cab_farm = [[0] * m for _ in range(n)]
#
#     for _ in range(cab_cnt):
#         a, b = map(int, input().split())
#         cab_farm[b][a] = 1
#
#     result_cnt = 0
#
#     for i in range(n):
#         for j in range(m):
#             if bfs(i, j) == True:
#                 result_cnt += 1
#
#     print(result_cnt)