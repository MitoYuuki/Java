public class Task {
    String title;
    boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public Task(String title, boolean isDone) {
        this.title = title;
        this.isDone = isDone;
    }

    public void toggle() {
        isDone = !isDone;
    }

    public String display() {
        return (isDone ? "[✓] " : "[ ] ") + title;
    }

    // 保存用形式に変換
    public String toData() {
        return (isDone ? "1" : "0") + "," + title;
    }

    // 読み込み用（"1,task" → Task オブジェクトに変換）
    public static Task fromData(String line) {
        String[] parts = line.split(",", 2);
        boolean done = parts[0].equals("1");
        return new Task(parts[1], done);
    }
}

