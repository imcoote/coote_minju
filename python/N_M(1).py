#N과 M (1)[15649]
"""*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N!)
 * 메모리: 32412 kb
 * 시간: 116 ms
 *******************************************************************************"""
def backtrack(lst, used):
    if len(lst) == M:
        print(' '.join(map(str, lst)))
        return

    for i in range(1, N + 1):
        if not used[i]:
            used[i] = True
            lst.append(i)
            backtrack(lst, used)
            lst.pop()
            used[i] = False


N, M = map(int, input().split())
used = [False] * (N + 1)
backtrack([], used)
