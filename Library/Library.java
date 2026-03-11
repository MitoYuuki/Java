package Library;

import java.util.ArrayList;

// 図書館クラス（本を管理する）
public class Library {

    // 本を保存するリスト
    private ArrayList<Book> books = new ArrayList<>();


    // 本を追加するメソッド
    public void addBook(String title, String author) {

        // 新しいBookオブジェクトを作ってリストに追加
        books.add(new Book(title, author));
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
            if (b.getTitle().contains(keyword)) {

                System.out.println(b.display());
                found = true;
            }
        }

        if (!found) {
            System.out.println("見つかりませんでした");
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