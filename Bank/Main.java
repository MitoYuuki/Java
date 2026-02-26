package Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 口座作成
        System.out.print("口座名義を入力してください: ");
        String name = scanner.nextLine();

        System.out.print("初期入金額を入力してください: ");
        int initial = scanner.nextInt();

        BankAccount account = new BankAccount(name, initial);
        System.out.println("\n--- 口座が作成されました！ ---");
        account.showInfo();

        while (true) {
            System.out.println("\n===== メニュー =====");
            System.out.println("1. 入金");
            System.out.println("2. 出金");
            System.out.println("3. 残高表示");
            System.out.println("4. 終了");
            System.out.print("番号を入力してください: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) { // 入金
                System.out.print("入金額を入力: ");
                int money = scanner.nextInt();
                account.deposit(money);

            } else if (choice == 2) { // 出金
                System.out.print("出金額を入力: ");
                int money = scanner.nextInt();
                account.withdraw(money);

            } else if (choice == 3) { // 残高表示
                account.showInfo();

            } else if (choice == 4) { 
                System.out.println("終了します！");
                break;

            } else {
                System.out.println("1～4 を入力してください！");
            }
        }

        scanner.close();
    }
}
