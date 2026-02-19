import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("=== ToDo メニュー ===");
            System.out.println("1. タスクを追加");
            System.out.println("2. タスク一覧を表示");
            System.out.println("3. 終了");
            System.out.println("4. タスクを削除");
            System.out.println("5. タスクを編集");
            System.out.println("6. 完了チェックの切り替え");
            System.out.print("番号を選んでください: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 改行を消す

            if (choice == 3) {
                System.out.println("終了します！");
                break;
            }

            // 1. タスク追加
            if (choice == 1) {
                System.out.print("追加するタスクを入力してください: ");
                String newTask = scanner.nextLine();
                tasks.add(new Task(newTask));
                System.out.println("タスクを追加しました！");
            }

            // 2. 一覧表示
            else if (choice == 2) {
                System.out.println("\n=== タスク一覧 ===");
                if (tasks.isEmpty()) {
                    System.out.println("タスクはありません！");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ": " + tasks.get(i).display());
                    }
                }
            }

            // 4. 削除
            else if (choice == 4) {
                if (tasks.isEmpty()) {
                    System.out.println("削除できるタスクがありません！");
                } else {
                    System.out.println("\n=== 削除するタスクを選んでください ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ": " + tasks.get(i).display());
                    }

                    System.out.print("削除したいタスク番号を入力: ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); // 改行消し

                    if (deleteIndex < 1 || deleteIndex > tasks.size()) {
                        System.out.println("番号が正しくありません！");
                    } else {
                        String removed = tasks.remove(deleteIndex - 1).title;
                        System.out.println("「" + removed + "」を削除しました！");
                    }
                }
            }

            // 5. 編集
            else if (choice == 5) {
                if (tasks.isEmpty()) {
                    System.out.println("編集できるタスクがありません！");
                } else {
                    System.out.println("\n=== 編集するタスクを選んでください ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ": " + tasks.get(i).display());
                    }

                    System.out.print("編集したいタスク番号を入力: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // 改行消し

                    if (editIndex < 1 || editIndex > tasks.size()) {
                        System.out.println("番号が正しくありません！");
                    } else {
                        System.out.print("新しい内容を入力してください: ");
                        String newText = scanner.nextLine();

                        String old = tasks.get(editIndex - 1).title;
                        tasks.get(editIndex - 1).title = newText;

                        System.out.println("「" + old + "」を「" + newText + "」に編集しました！");
                    }
                }
            }

            // 6. 完了チェック
            else if (choice == 6) {
                if (tasks.isEmpty()) {
                    System.out.println("タスクがありません！");
                } else {
                    System.out.println("\n=== 完了状態を切り替えるタスクを選んでください ===");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ": " + tasks.get(i).display());
                    }

                    System.out.print("番号を入力: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();

                    if (index < 1 || index > tasks.size()) {
                        System.out.println("番号が正しくありません！");
                    } else {
                        tasks.get(index - 1).toggle();
                        System.out.println("状態を切り替えました！");
                    }
                }
            }

            // それ以外
            else {
                System.out.println("1～6 の番号を入力してください！");
            }
        }
    }
}
