"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 32412 kb
 * 시간: 32 ms
 *******************************************************************************"""
import sys
input = sys.stdin.readline

n = int(input())
level_list = []
for i in range(n):
    a = int(input())
    level_list.append(a)

# 마지막 레벨의 점수를 기준으로 설정
standard_num = level_list[-1]
# 점수를 감소시킨 횟수를 저장할 변수
cnt = 0

# 뒤에서 두 번째 레벨부터 첫 번째 레벨까지 역순으로 순회
for i in range(n-2, -1, -1):
    # 현재 레벨의 점수가 기준 점수보다 크거나 같다면
    if level_list[i] >= standard_num:
        # 점수를 기준 점수보다 작게 만들기 위해 필요한 감소 횟수를 더함
        cnt += (level_list[i] - standard_num + 1)
        # 기준 점수를 1 줄임
        standard_num -= 1

    else:
        # 현재 레벨의 점수가 기준 점수보다 작다면 기준 점수를 현재 레벨 점수로 갱신
        standard_num = level_list[i]

print(cnt)




