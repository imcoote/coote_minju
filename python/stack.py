"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 39952 kb
 * 시간: 2752 ms
 *******************************************************************************"""
from collections import deque

stack = deque()  # 스택 초기화

n = int(input())

detec_lst = []
for _ in range(n):
    a = int(input())
    detec_lst.append(a)

i = 0  # 스택에 넣을 숫자 (1부터 n까지)
result = []  # 연산 결과 (+, -) 저장

for j in range(n):
    while i < n + 1:
        if len(stack) > 0:  # 스택이 비어 있지 않을 경우
            item = stack[-1]  # 스택의 top 요소 확인
            if item == detec_lst[j]:  # 스택의 top이 목표 숫자와 일치하면 pop
                result.append("-")
                stack.pop()
                break  # 다음 숫자로 이동
            i += 1
            stack.append(i)  # 목표 숫자가 아니면 다음 숫자를 push
            result.append("+")
        else:
            i += 1  # 스택이 비어있으면 새로운 숫자를 push
            stack.append(i)
            result.append("+")

if len(stack) == 0:
    for i in range(len(result)):
        print(result[i])
else:
    print("NO")  # 스택이 비어있지 않으면 수열 불가능
