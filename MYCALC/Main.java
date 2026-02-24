package MYCALC;

public class Main {
    public static void main(String[] args) {

        // 初期値なしコンストラクタ
        Calculator calc1 = new Calculator();
        System.out.println("calc1 初期値: " + calc1.getValue());

        calc1.add(10);
        System.out.println("calc1 add(10): " + calc1.getValue());

        // 初期値ありコンストラクタ
        Calculator calc2 = new Calculator(50);
        System.out.println("calc2 初期値: " + calc2.getValue());

        calc2.subtract(20);
        System.out.println("calc2 subtract(20): " + calc2.getValue());

        // オーバーロードメソッド
        System.out.println("静的 add(3, 7): " + Calculator.add(3, 7));
    }
}

