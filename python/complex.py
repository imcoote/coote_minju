"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N² log N)
 * 메모리: 34984 kb
 * 시간: 56 ms
 *******************************************************************************"""
import sys
from collections import deque

# 빠른 입력을 위해 sys.stdin.read() 사용, 시간초과 방지!
input = sys.stdin.read
data = input().split()  # 한 번에 입력받아 리스트로 변환

n = int(data[0])
grid = [list(map(int, data[i + 1])) for i in range(n)]  # 2차원 배열 생성
visited = [[False] * n for _ in range(n)]  # 방문 여부 배열

def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = True  # 방문 처리
    house_count = 1  # 현재 단지 크기 (처음 집을 포함해야함)

    while queue:
        cx, cy = queue.popleft()

        # 상하좌우 이동
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = cx + dx, cy + dy

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and grid[nx][ny] == 1:
                visited[nx][ny] = True  # 방문 처리
                queue.append((nx, ny))
                house_count += 1  # 단지 크기 증가

    return house_count  # 단지 개수 반환

# BFS 실행
complex_count = 0  # 단지 개수
complex_sizes = []  # 단지별 크기 리스트

for i in range(n):
    for j in range(n):
        if grid[i][j] == 1 and not visited[i][j]:  # 방문하지 않은 집 찾기
            complex_count += 1  # 단지 개수 증가
            complex_sizes.append(bfs(i, j))  # BFS 실행하여 단지 크기 저장

sys.stdout.write(str(complex_count) + "\n")
sys.stdout.write("\n".join(map(str, sorted(complex_sizes))) + "\n")