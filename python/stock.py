"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 134876 kb
 * 시간: 2232 ms
 *******************************************************************************"""
import sys
input = sys.stdin.readline

def stock_cal(n):
    stock_list = list(map(int, input().split()))

    max_stock = 0 # 최대 주가 저장 변수
    result = 0 # 총 이익 변수

    # 주식 가격을 역순으로 순회
    for i in range(n-1, -1, -1):
        # 현재 주가가 최대 주가보다 크다면 최대 주가 갱신
        if stock_list[i] > max_stock:
            max_stock = stock_list[i]
        # 최대 주가와 현재 주가의 차이를 이익으로 추가
        result += (max_stock - stock_list[i])

    return result

T = int(input())

for _ in range(T):
    n = int(input())
    final = stock_cal(n)
    print(final)








