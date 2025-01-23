"""*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(N log N)
 * 메모리: 185188 kb
 * 시간: 1364 ms
 *******************************************************************************"""
import sys
input = sys.stdin.readline

n = int(input())
cor_list = list(map(int, input().split()))

sort_list =sorted(set(cor_list), reverse=False) # set먼저 해주고 sorted

# 시간초과 떠서 딕셔너리로 자료구조 변경
coordinate_dict = {value: index for index, value in enumerate(sort_list)}

result = ' '.join(str(coordinate_dict[x]) for x in cor_list)
print(result)