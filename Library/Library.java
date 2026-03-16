package Library;

import java.util.ArrayList;
import java.io.*;

// 図書館クラス（本を管理する）
public class Library {

    // 本を保存するリスト
    private ArrayList<Book> books = new ArrayList<>();


    // 本を追加するメソッド
    public void addBook(String title, String author, String category) {

        // 新しいBookオブジェクトを作ってリストに追加
        books.add(new Book(title, author, category));
    }


    // 本一覧を表示するメソッド
    public void showBooks() {

        // 本が1冊もない場合
        if (books.isEmpty()) {
            System.out.println("本がありません");
            return;
        }

        // すべての本を表示
        for (int i = 0; i < books.size(); i++) {

            // 番号 + 本の情報
            System.out.println((i + 1) + ": " + books.get(i).display());
        }
    }


    // 本を借りるメソッド
    public void borrowBook(int index) {

        // インデックスチェック
        if (!isValidIndex(index)) return;

        Book book = books.get(index);

        // すでに貸出中
        if (book.isBorrowed()) {
            System.out.println("すでに貸出中です");

        } else {

            // 貸出処理
            book.borrow();
            System.out.println("貸出しました");
        }
    }


    // 本を返却するメソッド
    public void returnBook(int index) {

        if (!isValidIndex(index)) return;

        Book book = books.get(index);

        // まだ借りられていない
        if (!book.isBorrowed()) {
            System.out.println("この本は貸出されていません");

        } else {

            // 返却処理
            book.returnBook();
            System.out.println("返却しました");
        }
    }


    // 本を検索するメソッド
    public void searchBook(String keyword) {

        boolean found = false;

        for (Book b : books) {

            // タイトルにキーワードが含まれているか
            if (b.getTitle().contains(keyword) ||
                b.getAuthor().contains(keyword) ||
                b.getCategory().contains(keyword)) {

                System.out.println(b.display());
                found = true;
            }
        }

        if (!found) {
            System.out.println("見つかりませんでした");
        }
    }

    // 本を削除するメソッド
    public void deleteBook(int index) {

        if (!isValidIndex(index)) return;

        //指定した本を削除
        Book removed = books.remove(index);

        System.out.println("削除しました: " + removed.display());
    }

    // ファイルから本のデータを読み込むメソッド
    public void loadBooks() {

        // 処理が終わったら自動でファイルを閉じる
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {

            String line;

            // 1行ずつ読み込む
            while ((line = br.readLine()) != null) {

                // 例: Java入門,山田,技術,false
                // カンマで分割
                String[] data = line.split(",");

                // 配列からデータを取得
                String title = data[0];
                String author = data[1];
                String category = data[2];
                boolean borrowed = Boolean.parseBoolean(data[3]);

                // 本オブジェクトを作成
                Book book = new Book(title, author, category);

                // 貸出状態がtrueならborrow()を呼ぶ
                if (borrowed) {
                    book.borrow();
                }

                // 本リスト(ArrayList)に追加
                books.add(book);
            }

        } catch (IOException e) {

            // ファイルがまだ存在しない場合
            System.out.println("保存ファイルがありません");
        }
    }

    // 本リストをファイルに保存するメソッド
    public void saveBooks() {

        // PrintWriterでファイルに書き込み
        try (PrintWriter pw = new PrintWriter(new FileWriter("books.txt"))) {

            // booksリストを1冊ずつ処理
            for (Book b : books) {

                // CSV形式で保存
                pw.println(
                    b.getTitle() + "," +
                    b.getAuthor() + "," +
                    b.getCategory() + "," +
                    b.isBorrowed()
                );
            }

        } catch (IOException e) {

            // 保存時エラー
            System.out.println("保存エラー");
        }
    }


    // インデックスが正しいかチェック
    private boolean isValidIndex(int index) {

        // 範囲外ならエラー
        if (index < 0 || index >= books.size()) {

            System.out.println("番号が不正です");
            return false;
        }

        return true;
    }
}