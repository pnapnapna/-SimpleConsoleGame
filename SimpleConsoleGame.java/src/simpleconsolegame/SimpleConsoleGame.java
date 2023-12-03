package simpleconsolegame;
import java.util.Scanner;
import java.util.Random;

public class SimpleConsoleGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerPosition = 5;
        int enemyPosition = random.nextInt(10);
        int score = 0;
        boolean isGameOver = false;

        while (!isGameOver) {
            // 게임 상태를 표시
            for (int i = 0; i < 10; i++) {
                if (i == playerPosition) {
                    System.out.print("P");
                } else if (i == enemyPosition) {
                    System.out.print("E");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println("\n점수: " + score);

            // 사용자 입력 받기
            System.out.print("이동 (A: 왼쪽, D: 오른쪽): ");
            String input = scanner.nextLine().toUpperCase();

            // 사용자 입력에 따라 게임 상태 업데이트
            if (input.equals("A") && playerPosition > 0) {
                playerPosition--;
            } else if (input.equals("D") && playerPosition < 9) {
                playerPosition++;
            }

            // 적 이동
            enemyPosition = (enemyPosition + 1) % 10;

            // 충돌 확인
            if (playerPosition == enemyPosition) {
                isGameOver = true;
                System.out.println("게임 종료! 점수: " + score);
            }

            // 점수 증가
            score++;

            // 게임이 콘솔에서 플레이 가능하게 짧은 시간 동안 일시 중지
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 콘솔 내용 지우기
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        // 스캐너 닫기
        scanner.close();
    }
}
