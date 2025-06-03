/*******************************************************************************
 * 소요시간: 1시간
 * 시간복잡도: O(N)
 * 메모리: 14016 kb
 * 시간: 100 ms
 *******************************************************************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class isSimilar {
    // 두 단어가 비슷한지 판단하는 함수
    public static boolean isSimilar(String word1, String word2) {
        int[] alphabet = new int[26];

        // word1 알파벳 개수 증가
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            alphabet[ch - 'A']++;
        }

        // word2 알파벳 개수 감소
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            alphabet[ch - 'A']--;
        }

        // 얼마나 다른지 확인
        int plus = 0;  // word1에는 없고 word2에는 있는 알파벳 개수
        int minus = 0; // word1에는 있고 word2에는 없는 알파벳 개수

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                plus += alphabet[i];
            } else if (alphabet[i] < 0) {
                minus -= alphabet[i];
            }
        }

        // 조건: 완전 같거나, 하나만 다르거나, 하나 바꾸면 되는 경우
        if (plus == 0 && minus == 0) return true; // 같은 구성
        if ((plus == 1 && minus == 0) || (plus == 0 && minus == 1)) return true; // 한 글자 추가 or 제거
        if (plus == 1 && minus == 1) return true; // 한 글자 바꾸기

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        String base = words[0]; // 기준 단어
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (isSimilar(base, words[i])) {
                count++;
            }
        }

        System.out.println(count);
    }
}


