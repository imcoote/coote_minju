"""*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 112592 kb
 * 시간: 1756 ms
 *******************************************************************************"""
import sys
from collections import deque
n = int(sys.stdin.readline().strip())

dq = deque()
for _ in range(n):
    command = sys.stdin.readline().strip()

    if command[:4] == "push":
        a = int(command.split()[1])
        dq.append(a)
        # 이 부분 할 때 일의 자리만 생각해서 틀렸다가
        # 10 이상도 올 수있다는걸 깨닫고 ->command.split()[1]이렇게 수정했어요 ㅎㅎ;;

    else:
        if command == "pop":
            if len(dq) > 0:
                out_num = dq.popleft()
                print(out_num)
            else:
                print(-1)
        elif command == "size":
            print(len(dq))
        elif command == "empty":
            if len(dq) == 0:
                print(1)
            else:
                print(0)
        elif command == "front":
            if len(dq) == 0:
                print(-1)
            else:
                print(dq[0])
        elif command == "back":
            if len(dq) == 0:
                print(-1)
            else:
                print(dq[-1])