/*******************************************************************************
 * 소요시간: 30분
 * 시간복잡도: O(n)
 * 메모리: 14164 kb
 * 시간: 104 ms
 *******************************************************************************/
// 0 군집과 1군집의 개수를 비교하여 더 적은 군집의 개수를 출력하는 방식으로 문제 해결
// 맨 처음 입력받은 숫자가 0인지 1인지에 따라 각 숫자에 맞는 군집의 개수 +1 해줌
// 그 후 숫자가 바뀌는 시점마다 바뀐 숫자의 군집에 개수를 +1 해줌 (0->1로 바뀔 시 1군집(one이라는 이름)의 개수 +1)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int zero = 0; // 0군집 이름
        int one = 0; // 1군집 이름
        int tmp = 0; // 현재 값

        for (int i = 0; i<input.length(); i++) {
            int digit = input.charAt(i) - '0'; //입력받은 값을 int형으로 바꾸어줌
            if (i == 0){
                tmp = digit; // tmp: 현재 어떤 숫자의 군집인지를 나타내줌
                if (digit == 0){
                    zero += 1;
                }else{
                    one += 1;
                }
            }else{
                if (tmp != digit) { // 값이 바뀔 때
                    tmp = digit; // 바뀐 값을 현재 어떤 군집인지를 나타내주는 tmp에 넣음
                    if (digit == 0){
                        zero += 1;
                    }else{
                        one += 1;
                    }
                }
            }
        }
        // 값이 더 작은 쪽을 출력해줌
        System.out.println(Math.min(zero, one));
    }
}

