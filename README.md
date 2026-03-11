# MyJavaProject

Java 学習のために作成しているプロジェクトです。

## 📘 プログラム一覧

### ■ Hello.java
初めての Java プログラム。

### ■ Janken.java
コンソールで遊べるじゃんけんアプリ。

### ■ SelfIntro.java
名前・年齢・趣味を入力すると自己紹介文を表示します。

### ■ ToDoList.java / Task.java
タスク追加・削除・編集・完了チェックができる ToDo アプリ。

### ■ Calculator.java / Main.java
計算機クラス（Calculator）を使った学習用サンプル。  
- **コンストラクタの仕組み**  
- **メソッドの戻り値**  
- **メソッドのオーバーロード**  
- **static メソッドの使い方**  
などを学ぶためのコード。

### ■ BankAccount.java / BankMain.java
銀行口座を管理する学習用サンプルアプリ。

- **private / public の使い分け**
- **フィールドのカプセル化（情報隠蔽）**
- **入金（deposit）・出金（withdraw）**
- **ユーザー入力で金額を操作**
- **残高チェック（残高不足の防止）**

オブジェクト指向をさらに深く理解するための実践的プログラム。

■ LibraryApp.java / Library.java / Book.java

コンソールで動作する 図書管理アプリ。

本の登録・貸出・返却・検索などを行うことができます。

主な機能

本の追加

本一覧の表示

本の貸出

本の返却

本の検索（タイトル）

クラス構成

Book
→ 本1冊のデータを管理（タイトル・著者・貸出状態）

Library
→ 本の追加・貸出・返却・検索などの処理を管理

LibraryApp
→ メニュー表示とユーザー入力を管理

学習ポイント

クラス設計（Book / Library / Main）

ArrayList によるデータ管理

オブジェクト指向設計

メソッドによる処理の分割

カプセル化（private フィールド）

## ▶ コンパイル方法
例：javac -encoding UTF-8 ToDoList.java
パッケージを使っていないため、同じフォルダ内で複数ファイルのコンパイルが可能です。

## ▶ 実行方法
例：java Todo.ToDoList

## ✨ 学習の記録
- Java の基礎を学習
- 複数のコンソールアプリを作成
- ファイル保存機能を実装
- コンストラクタ / 戻り値 / オーバーロード / static を理解
- GitHub への push 操作を習得