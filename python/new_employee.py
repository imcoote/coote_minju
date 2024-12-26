# 신입사원 [1946]
"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(T×nlogn)
 * 메모리: 48072 kb
 * 시간: 3376 ms
 *******************************************************************************"""
import sys
input = sys.stdin.readline # 이거 안해주니까 런타임 에러
# sys.stdin.readline을 사용해 빠르게 입력을 처리

T = int(input())
for _ in range(T):
    n = int(input())
    appli_list = []

    for _ in range(n):
        docu_list, inter_list = map(int, input().split())

        appli_list.append((docu_list, inter_list))

    appli_list.sort(key=lambda x: x[0]) # 서류를 기준으로 줄세우기

    cnt = 1 # 1등은 무조건 선발

    interview_ranking = appli_list[0][1] # 서류 1등 면접 순위

    for i in range(1, n):
        if appli_list[i][1] < interview_ranking:
            cnt += 1
            interview_ranking = appli_list[i][1]

    print(cnt)

# import sys
# input = sys.stdin.readline
# T = int(input())
#
# for _ in range(T):
#     n = int(input())
#     data = {}  #
#
#     for i in range(n):
#         line = list(map(int, input().split()))
#         key = chr(97 + i)  # 97은 'a'의 ASCII 코드
#         data[key] = line
#
#     docu_list = sorted(data.keys(), key=lambda k: data[k][0])
#
#
#     interview_list = sorted(data.keys(), key=lambda k: data[k][1])
#
#     if docu_list[0] == interview_list[0]:
#         cnt = 1
#         continue
#     else:
#         cnt = 2
#
#     for i in range(1, len(docu_list)):
#         if interview_list[0] == docu_list[i]:
#             a = i
#         if docu_list[0] == interview_list[i]:
#             b = i
#
#     for i in range(1, a):
#         for j in range(1, b):
#             if docu_list[i] == interview_list[j]:
#                 cnt += 1
#
#     print(cnt)