public class Task {
    String title;
    boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public void toggle() {
        isDone = !isDone;
    }

    public String display() {
        return (isDone ? "[✓] " : "[ ] ") + title;
    }
}

