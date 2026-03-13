package Library;

// 本1冊を表すクラス
public class Book {

    // 本のタイトル
    private String title;

    // 著者
    private String author;

    // 貸出状態（trueなら貸出中）
    private boolean borrowed;

    // 本のカテゴリ（例: 技術 / 小説 / ビジネス）
    private String category;

    // コンストラクタ（本を作るときにタイトルと著者を設定）
    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        // 本のカテゴリ
        this.category = category;
        this.borrowed = false; // 最初は貸出されていない
    }

    // タイトルを取得するメソッド
    public String getTitle() {
        return title;
    }

    // 貸出状態を取得するメソッド
    public boolean isBorrowed() {
        return borrowed;
    }

    // 本を貸し出すメソッド
    public void borrow() {
        borrowed = true;
    }

    // 本を返却するメソッド
    public void returnBook() {
        borrowed = false;
    }

    // 本の情報を表示用の文字列に変換する
    public String display() {

        // 貸出中なら [貸出中] を表示
        return title + " - " + author +
           " (" + category + ")" + (borrowed ? " [貸出中]" : "");
    }

    // 著者を取得するgetter
    public String getAuthor() {
        return author;
    }

    // カテゴリを取得するgetter
    public String getCategory() {
        return category;
    }
}