"""*******************************************************************************
 * 소요시간: 1시간 30분
 * 시간복잡도: O(N^2 log N)
 * 메모리: 35508 kb
 * 시간: 1624 ms
 *******************************************************************************"""
import sys
import heapq

input = sys.stdin.readline # 입력 속도 향상을 위해 sys.stdin.readline 사용

n = int(input())

min_heap = []

# 행렬 데이터를 입력받으면서 최소 힙 유지
# 최대 N개까지만 힙에 유지하고, N개를 초과하면 최소값 제거
for _ in range(n):
    row = list(map(int, input().split()))
    for num in row:
        heapq.heappush(min_heap, num)
        # 힙의 크기가 N을 초과하면 가장 작은 값 제거
        # N이 5라면 힙에 항상 가장 큰 5개 숫자만 남게 됨
        if len(min_heap) > n:
            heapq.heappop(min_heap)

# 힙의 최소값(min_heap[0])이 N번째로 큰 수
# 왜냐하면 힙에는 항상 N개의 가장 큰 숫자만 남기 때문!
print(min_heap[0])

