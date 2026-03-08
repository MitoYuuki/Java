package Todo;

public class Task {

    // タスク名
    String title;

    // 完了したかどうか（true = 完了）
    boolean isDone;

    // 優先度（1:高、2:中、3:低）
    int priority;

    // 期限（文字で保存）
    String dueDate;

    // カテゴリ（勉強・買い物など）
    String category;

    // 通常タスク（優先度は中、期限なし）
    public Task(String title) {
        this.title = title;
        this.isDone = false;
        this.priority = 2; // 中
        this.dueDate = "-";
        this.category = "未分類";
    }

    // 優先度つきコンストラクタ
    public Task(String title, int priority) {
        this.title = title;
        this.isDone = false;
        this.priority = priority;
        this.dueDate = "-";
        this.category = "未分類";
    }

    // ファイル読み込み時用コンストラクタ
    public Task(String title, boolean isDone, int priority, String dueDate, String category) {
        this.title = title;
        this.isDone = isDone;
        this.priority = priority;
        this.dueDate = dueDate;
        this.category = category;
    }

    // 完了状態を反転させる
    public void toggle() {
        isDone = !isDone;
    }

    // 優先度を文字に変換
    private String priorityLabel() {
        switch (priority) {
            case 1: return "高";
            case 2: return "中";
            case 3: return "低";
            default: return "?";
        }
    }

    // タスクを画面表示用の文字にする
    public String display() {
        return String.format(
                "%s %s (カテゴリ:%s, 優先度:%s, 期限:%s)",
                (isDone ? "[✓]" : "[ ]"),
                title,
                category,
                priorityLabel(),
                dueDate != null ? dueDate : "なし"
        );
    }

    // タスクをファイル保存用の1行に変換
    public String toData() {
        // 例：1,買い物,2,2024-02-28
        return (isDone ? "1" : "0") + "," + title + "," + priority + "," + dueDate + "," + category;
    }

    // 保存された1行から Task に戻す
    public static Task fromData(String line) {
        // 最大4つの項目に分割
        String[] parts = line.split(",", 5);

        boolean done = parts[0].equals("1");
        String title = parts[1];
        int priority = Integer.parseInt(parts[2]);
        String dueDate = parts.length == 4 ? parts[3] : "-";
        String category = parts.length >= 5 ? parts[4] : "未分類";

        return new Task(title, done, priority, dueDate, category);
    }
}