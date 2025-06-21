/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(T * n)
 * 메모리: 18608 kb
 * 시간: 208 ms
 *******************************************************************************/
//각 의상은 하나의 종류를 가짐 (모자, 안경, 셔츠 등)
//한 종류에서 하나만 착용 가능
//종류별로 안 입는 선택도 가능
//단, 아무것도 안 입는 경우는 제외


import java.util.*;
public class 패션왕 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 케이스 수

        while (t-- > 0) {
            int n = sc.nextInt(); // 의상 개수
            Map<String, Integer> clothesMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next(); // 의상 이름 (사용하지 않음)
                String type = sc.next(); // 의상 종류
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
                //해당 종류(type)가 이미 존재하면 값을 가져오고(get), 없으면 기본값 0을 사용
                //이후 1을 더해서 해당 종류의 옷 개수를 갱신
            }

            int result = 1; //결과값을 저장할 변수 result를 1로 초기화, 곱셈을 위해 1부터 시작
            for (int count : clothesMap.values()) { //옷 종류별 개수들을 하나씩 꺼내서 반복
                result *= (count + 1); // 입는 경우 + 안 입는 경우
            }

            System.out.println(result - 1); // 아무것도 안 입은 경우 제외
        }
    }
}

