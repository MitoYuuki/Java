package Todo;

import java.io.*;
import java.util.*;

public class ToDoList {

    // 保存するファイルの場所（Todoフォルダ内）
    private static final String FILE_NAME = "Todo/tasks.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Task オブジェクトを入れておくリスト
        ArrayList<Task> tasks = new ArrayList<>();

        // ⭐ 起動したときにファイルからタスクを読み込む
        loadTasks(tasks);

        // メニューを永遠に表示するループ
        while (true) {
            System.out.println("\n=== ToDo メニュー ===");
            System.out.println("1. タスクを追加");
            System.out.println("2. タスク一覧を表示");
            System.out.println("3. 終了（保存）");
            System.out.println("4. タスクを削除");
            System.out.println("5. タスクを編集");
            System.out.println("6. 完了チェックの切り替え");
            System.out.println("7. 優先度順に並び替え");

            System.out.print("番号を選んでください: ");
            int choice = scanner.nextInt();   // メニュー番号を入力
            scanner.nextLine();               // 改行を読み捨て

            switch (choice) {

                // 1. タスク追加
                case 1:
                    System.out.print("追加するタスクのタイトル: ");
                    String title = scanner.nextLine();

                    System.out.print("優先度を選択 (1:高 2:中 3:低): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("期限を入力 (例: 2024-03-01 / 無しなら Enter): ");
                    String due = scanner.nextLine();
                    if (due.isEmpty()) due = "-";
                        System.out.print("カテゴリを入力 (例: 勉強 / 買い物 / 仕事): ");
                        String category = scanner.nextLine();
                        if (category.isEmpty()) category = "未分類";
                        
                    // 新しいタスクを作成しリストへ追加
                    tasks.add(new Task(title, false, priority, due, category));

                    System.out.println("タスクを追加しました！");
                    break;

                // 2. 一覧表示
                case 2:
                    showTasks(tasks);
                    break;

                // 3. 終了（保存してプログラム終了）
                case 3:
                    saveTasks(tasks);  // ファイルに書き出し
                    System.out.println("保存して終了します！");
                    return;

                // 4. タスク削除
                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("削除できるタスクがありません！");
                        break;
                    }

                    showTasks(tasks);
                    System.out.print("削除する番号: ");
                    int del = scanner.nextInt();
                    scanner.nextLine();

                    // 正しい番号かチェック
                    if (isValidIndex(del, tasks)) {
                        System.out.println("「" + tasks.get(del - 1).title + "」を削除しました！");
                        tasks.remove(del - 1);  // 実際に削除
                    } else {
                        System.out.println("番号が正しくありません！");
                    }
                    break;

                // 5. タスク編集
                case 5:
                    if (tasks.isEmpty()) {
                        System.out.println("編集できるタスクがありません！");
                        break;
                    }

                    showTasks(tasks);
                    System.out.print("編集する番号: ");
                    int edit = scanner.nextInt();
                    scanner.nextLine();

                    if (!isValidIndex(edit, tasks)) {
                        System.out.println("番号が正しくありません！");
                        break;
                    }

                    // 編集対象のタスクを取得
                    Task target = tasks.get(edit - 1);

                    // タイトル編集
                    System.out.print("新しいタイトル (空で変更なし): ");
                    String newTitle = scanner.nextLine();
                    if (!newTitle.isEmpty()) target.title = newTitle;

                    // 優先度編集
                    System.out.print("新しい優先度 (1:高 2:中 3:低 / 0:変更なし): ");
                    int newPri = scanner.nextInt();
                    scanner.nextLine();
                    if (newPri >= 1 && newPri <= 3) target.priority = newPri;

                    // 期限編集
                    System.out.print("新しい期限 (例 2024-03-01 / Enterで変更なし): ");
                    String newDue = scanner.nextLine();
                    if (!newDue.isEmpty()) target.dueDate = newDue;

                    System.out.println("編集しました！");
                    break;

                // 6. 完了チェック切り替え
                case 6:
                    if (tasks.isEmpty()) {
                        System.out.println("タスクがありません！");
                        break;
                    }
                    showTasks(tasks);

                    System.out.print("切り替える番号: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();

                    if (isValidIndex(idx, tasks)) {
                        tasks.get(idx - 1).toggle(); // 完了状態を反転
                        System.out.println("完了状態を切り替えました！");
                    } else {
                        System.out.println("番号が正しくありません！");
                    }
                    break;

                // 7. 優先度順（数字が小さいほど高い）
                case 7:
                    tasks.sort(Comparator.comparingInt(t -> t.priority));
                    System.out.println("優先度順に並び替えました！（高 → 低）");
                    break;

                default:
                    System.out.println("1〜7 を選んでください！");
            }
        }
    }

    // ----------------------------
    // ⭐ タスク一覧表示
    // ----------------------------
    private static void showTasks(ArrayList<Task> tasks) {

        System.out.println("\n=== タスク一覧 ===");

        if (tasks.isEmpty()) {
            System.out.println("タスクはありません！");
            return;
        }

        // タスクを1つずつ表示（番号つき）
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i).display());
        }
    }

    // ----------------------------
    // ⭐ 入力された番号が正しい範囲かチェック
    // ----------------------------
    private static boolean isValidIndex(int index, ArrayList<Task> tasks) {
        // 配列は0始まりだけど、メニューは1始まりなので1〜サイズの範囲でOK
        return index >= 1 && index <= tasks.size();
    }

    // ----------------------------
    // ⭐ ファイルからタスクを読み込む
    // ----------------------------
    private static void loadTasks(ArrayList<Task> tasks) {

        File file = new File(FILE_NAME);

        // ファイルがないときは読み込まない
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {

                // 保存した1行を Task に変換する
                tasks.add(Task.fromData(line));
            }

        } catch (Exception e) {
            System.out.println("読み込みエラー: " + e.getMessage());
        }
    }

    // ----------------------------
    // ⭐ タスクをファイルへ保存
    // ----------------------------
    private static void saveTasks(ArrayList<Task> tasks) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Task t : tasks) {
                // 1行の文字列に変換して保存
                pw.println(t.toData());
            }

        } catch (Exception e) {
            System.out.println("保存エラー: " + e.getMessage());
        }
    }
}