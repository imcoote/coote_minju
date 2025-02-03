"""*******************************************************************************
 * 소요시간: 3시간
 * 시간복잡도: O(n + w)
 * 메모리: 34924 kb
 * 시간: 60 ms
 *******************************************************************************"""
from collections import deque

sys = list(map(int, input().split()))  # 다리 정보 입력 (n: 트럭 수, w: 다리 길이, L: 최대 하중)
truck = list(map(int, input().split()))  # 트럭 무게 리스트
queue = deque(truck) # 트럭 리스트를 큐로 변환

bridge = deque()  # 다리 위 트럭 (무게, 현재 시간)
time = 0  # 경과 시간
weight = 0  # 현재 다리 위 총 무게

while queue or bridge:  # 트럭이 남아있거나 다리에 트럭이 남아있다면 반복
    time += 1  # 현재 시간을 한 단위 증가

    # 다리에서 트럭이 나가는 시점
    if bridge and bridge[0][1] + sys[1] == time:  # (진입 시간 + 다리 길이 == 현재 시간)
        weight -= bridge.popleft()[0]  # 다리에서 트럭 제거 및 무게 감소

    # 새로운 트럭이 다리에 올라갈 수 있는지 확인
    if queue and weight + queue[0] <= sys[2]:  # 다리 최대 하중 초과 안 하면
        truck_weight = queue.popleft()  # 큐에 대기 중인 트럭 하나 꺼내서
        bridge.append((truck_weight, time))  # 다리에 트럭 추가
        weight += truck_weight  # 다리 위 총 무게 증가

# 마지막 트럭이 다리를 완전히 건너는 시간
if bridge:
    time = bridge[-1][1] + sys[1]  # 마지막 트럭의 진입 시간 + 다리 길이

print(time)