package Bank;

public class BankAccount {

    private String owner;  // 口座名義（外から勝手に変えられたら困る）
    private int balance;   // 残高（絶対にprivate！）

    // コンストラクタ（新しい口座を作るときに呼ばれる）
    public BankAccount(String owner, int initialDeposit) {
        this.owner = owner;
        this.balance = initialDeposit;
    }

    // 現在の残高を読み取る（公開）
    public int getBalance() {
        return balance;
    }

    // お金を預ける（公開）
    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + "円 預けました！");
    }

    // お金を引き出す（公開）
    public void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "円 引き出しました！");
        } else {
            System.out.println("残高不足です！");
        }
    }

    // 口座情報を表示
    public void showInfo() {
        System.out.println("口座名義: " + owner);
        System.out.println("残高: " + balance + "円");
    }
}