"""*******************************************************************************
 * 소요시간: 2시간
 * 시간복잡도: O(n)
 * 메모리: 55728 kb
 * 시간: 236 ms
 *******************************************************************************"""
import sys

# 개강총회를 시작한 시간 S, 개강총회를 끝낸 시간 E, 개강총회 스트리밍을 끝낸 시간 Q
lst = list(sys.stdin.readline().split()) # 시간 초과를 피하기 위한 빠른 입력 처리

time_lst = []
for i in range(len(lst)):
    time_lst.append(int(lst[i][:2])) # 시간 저장
    time_lst.append(int(lst[i][3:5])) # 분 저장

inout_lst = []
enter_count = 0  # 엔터 횟수 체크 -> while 탈출

while True:
    name_data = sys.stdin.readline().strip() # 빠른 입력 사용
    if not name_data:
        enter_count += 1
        if enter_count == 2:
            break
        continue
    else:
        enter_count = 0

    name_split = name_data.split()
    if len(name_split) >= 2:
        hour = int(name_split[0][:2])
        minute = int(name_split[0][3:])
        person = name_split[1]
        inout_lst.append([hour, minute, person])

in_set = set()  # 입실 저장 set
out_set = set()  # 퇴실 저장 set

for entry in inout_lst:
    hour, minute, person = entry

    # 입실 확인
    if hour < time_lst[0] or (hour == time_lst[0] and minute <= time_lst[1]):
        in_set.add(person)

    # 퇴실 확인 (퇴근 후 출입한 사람 추가) Q(스트리밍을 끝낸 시간) 이후 기록은 무시
    if (hour > time_lst[2] or (hour == time_lst[2] and minute >= time_lst[3])) and \
       (hour < time_lst[4] or (hour == time_lst[4] and minute <= time_lst[5])):
        out_set.add(person)

cnt = sum(1 for name in out_set if name in in_set)

print(cnt)