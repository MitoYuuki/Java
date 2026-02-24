package MYCALC;

public class Calculator {
    private int value;

    // コンストラクタ（初期値なし → 0）
    public Calculator() {
        this.value = 0;
    }

    // コンストラクタ（初期値あり）
    public Calculator(int initialValue) {
        this.value = initialValue;
    }

    // 現在の値を返す（戻り値 使用）
    public int getValue() {
        return value;
    }

    // -------- オーバーロードされた add メソッド --------

    // int型追加
    public int add(int x) {
        value += x;
        return value;
    }

    // double型追加（オーバーロード）
    public double add(double x) {
        value += (int)x;
        return value;
    }

    // 2つの値を足す（静的メソッドのオーバーロード例）
    public static int add(int a, int b) {
        return a + b;
    }

    // -------- 他の四則演算も同様の仕組み --------

    public int subtract(int x) {
        value -= x;
        return value;
    }

    public int multiply(int x) {
        value *= x;
        return value;
    }

    public double divide(double x) {
        value /= x;
        return value;
    }
}

