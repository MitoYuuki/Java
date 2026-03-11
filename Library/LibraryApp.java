package Library;

import java.util.Scanner;

// メインプログラム
public class LibraryApp {

    public static void main(String[] args) {

        // キーボード入力
        Scanner scanner = new Scanner(System.in);

        // 図書館オブジェクト
        Library library = new Library();

        // 無限ループ（メニューを繰り返す）
        while (true) {

            System.out.println("\n=== Library Menu ===");
            System.out.println("1 本を追加");
            System.out.println("2 本一覧");
            System.out.println("3 本を借りる");
            System.out.println("4 本を返す");
            System.out.println("5 本を検索");
            System.out.println("6 終了");

            System.out.print("選択: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // 本追加
                case 1:

                    System.out.print("タイトル: ");
                    String title = scanner.nextLine();

                    System.out.print("著者: ");
                    String author = scanner.nextLine();

                    library.addBook(title, author);
                    break;


                // 本一覧
                case 2:
                    library.showBooks();
                    break;


                // 貸出
                case 3:

                    library.showBooks();

                    System.out.print("借りる本番号: ");
                    int borrow = scanner.nextInt() - 1;

                    library.borrowBook(borrow);
                    break;


                // 返却
                case 4:

                    library.showBooks();

                    System.out.print("返す本番号: ");
                    int ret = scanner.nextInt() - 1;

                    library.returnBook(ret);
                    break;


                // 検索
                case 5:

                    System.out.print("検索キーワード: ");
                    String keyword = scanner.nextLine();

                    library.searchBook(keyword);
                    break;


                // 終了
                case 6:

                    System.out.println("終了します");
                    return;


                default:
                    System.out.println("1〜6を選んでください");
            }
        }
    }
}