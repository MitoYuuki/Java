import java.util.Scanner;

public class Janken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("じゃんけんアプリ！");
        System.out.println("0: グー, 1: チョキ, 2: パー");
        System.out.print("あなたの手を入力してください: ");

        int player = scanner.nextInt();

        int computer = (int)(Math.random() * 3); // 0〜2 の乱数生成

        System.out.println("あなた: " + handName(player));
        System.out.println("コンピュータ: " + handName(computer));

        // 勝敗判定
        if (player == computer) {
            System.out.println("結果: あいこ！");
        } else if ((player == 0 && computer == 1) ||
                   (player == 1 && computer == 2) ||
                   (player == 2 && computer == 0)) {
            System.out.println("結果: 勝ち！！🎉");
        } else {
            System.out.println("結果: 負け…😢");
        }
    }

    static String handName(int num) {
        switch(num) {
            case 0: return "グー";
            case 1: return "チョキ";
            case 2: return "パー";
            default: return "不明";
        }
    }
}
