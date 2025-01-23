"""*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(N + M)
 * 메모리: 53220 kb
 * 시간: 152 ms
 *******************************************************************************"""
import sys
input = sys.stdin.readline

n = int(input())
list_A = list(map(int, input().split()))

set_A = set(list_A) # 시간 초과로 인해 set형식으로 변경

m = int(input())
find_list = list(map(int, input().split()))

for num in find_list:
    if num in set_A:
        print(1)
    else:
        print(0)

