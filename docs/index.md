# RamenTimer (with JavaFX)

## 目次

1. 環境
2. 完成品
3. 開発
    1. UI作成
        1. FXMLファイルの作成
        2. UIデザイン① 〜タイトルテキスト〜
        3. UIデザイン② 〜時刻表示テキスト〜
        4. UIデザイン③ 〜時刻設定ボタン〜
        5. UIデザイン④ 〜スタート/ストップボタン〜
        6. UIデザイン⑤ 〜見た目の調整〜
    2. プログラミング
        1. Main.java作成
        2. UI起動

## 1. 環境

以下に示す環境での動作を確認しています。

- java:  openjdk 13.0.1 2019-10-15
- javac:  13.0.1
- javafx:  13.0.1


## 2. 完成品

*ここに完成画像*

## 3. 開発

## 3.1. UI作成

SceneBuilderを用いてUIを作成します。  

## 3.1.1. FXMLファイルの作成

SceneBuilderを起動し、「基本アプリケーション」を選択します。  
画面左下にある「ドキュメント/階層」タブから、**VBox以外のUIコンポーネントを削除** します。

*1.png*  
*3.png*  
*4.png*  

ここまでの作業を **src/fxml** に **MainUI.fxml** として保存します。  

```
.
├── README.md
└── src
    └── fxml
        └── MainUI.fxml
```

## 3.1.2. UIデザイン①

タイトルテキストの追加を行います。  

「ライブラリ/**Shapes**」タブから **Text** を「ドキュメント/**階層**」タブにドラックアンドドロップします。  
このとき、**Text は VBox に含める** ようにしてください。(画像参照)  

*5.png*  
*6.png*

追加した Text をクリックし、画面右にある「インスペクタ/**Properties**」タブを選択します。  
そして、**Text入力欄** にタイトルテキストを入力します。  
また、**Font選択欄** や **Text Alignment選択** を操作して文字の表示方法を調整します。

*7.png*

「ドキュメント/階層」タブ内の VBox を選択し、「インスペクタ/Properties」タブを選択します。  
**Alignment選択欄** から **TOP CENTER** を選択します。  

*8.png*


## 3.1.3. UIデザイン②

時刻表示欄を追加します。

3.1.2.と同様にして、VBox 内に Text を追加します。  
このとき、**Text は既に存在する Text より下に追加する** ようにしてください。

3.1.2.と同様にして、表示する文字列の変更を行います。  
ここでは、とりあえずの値として **00:00** を設定します。  
また、文字サイズの変更などもこのタイミングで行います。  

*9.png*

## 3.1.4. UIデザイン③

時刻をセットするためのボタンを追加します。  

「ライブラリ/**Containers**」タブから **HBox** を「ドキュメント/階層」タブにドラックアンドドロップします。  
このとき、**HBox は既に存在する Text より下に追加する** ようにしてください。(画像参照)  

*10.png*  

追加した HBox を選択し、「インスペクタ/Properties」タブから Alignment を CENTER に変更します。

*11.png*

「ライブラリ/**Controls**」タブから **Button** を **4つ** 「ドキュメント/階層」タブにドラックアンドドロップします。  
このとき、**Button を HBox に含める** ようにしてください。(画像参照)  

*12.png*  

それぞれのボタンを選択し、「インスペクタ/Properties」タブからボタンの表示内容を画像の用に変更します。  
文字サイズの変更などもこのタイミングで行います。  

*13.png*

## 3.1.5. UIデザイン④

スタート、ストップボタンを追加します。  

3.1.4. と同様の操作を行うことで、図のようにボタンを配置します。 

*14.png*  

## 3.1.6. UIデザイン⑤

これまでに追加したUIコンポーネントの表示内容を調節します。  

各UIコンポーネントには以下の属性を設定することが出来ます。  
これらの数値を調整することで見た目を調整します。  
(数値の調整は画面右にある「インスペクタ/**Layout**」タブより行います)

- Merging/Padding: 上下左右に空き領域を設定する
- Spacing: UIコンポーネント同士の間隔を調整する(HBox/VBoxでのみ設定可能)
- Pref Width: UIコンポーネントの横幅を調整する(HBox/VBoxでのみ設定可能)
- Pref Height: UIコンポーネントの縦幅を調整する(HBox/VBoxでのみ設定可能)

調整を行うことで、次のように見た目を整えることが出来ます。  

*15.png*

## 3.2. プログラミング

## 3.2.1. Main.java作成

次のように **Main.java** ファイルを作成します。  

```
.
├── README.md
└── src
    ├── Main.java
    └── fxml
        └── MainUI.fxml
```

**VSCodeなどのテキストエディタ**を用いて Main.java を開き、次のように記述します。

```java
public class Main {

    public static void main(String[] args){
        System.out.println("Hello RamenTimer!");
    }

}
```

「**コマンドプロンプト**」や「**コンソール**」を起動し、`cd` コマンドを利用して Main.java があるパスまで移動します。  

```
$ cd Main.javaがあるパス
$ dir src または ls src
Main.java fxml
```

`dir` または `ls` コマンドを用いて src ディレクトリ内に存在するファイルを確認し、Main.java が表示されることを確認します。  

Main.java のコンパイルと実行を行います。  

```
$ javac -sourcepath src -d bin src/Main.java
$ java -classpath bin Main
Hello RamenTimer!
```

メッセージが正常に出力されることを確認してください。  

## 3.2.2. Makefile作成

コンパイルや実行を楽に行うためにMakefileを作成します。  
**Makefile** を利用することで、入力するコマンドの量を減らすことが出来ます。  

最も基本的な Makefile は「**ターゲット**」と「**コマンド**」の集合から成ります。  
フォーマットは以下のとおりです。  

```
ターゲットA:
    コマンドA
    コマンドB
    コマンドC

ターゲットB:
    コマンドD
    コマンドE
```

Makefile は `make` コマンドとともに使用します。  
上に示したファイルを例にすると `make ターゲットA` と入力することで、ターゲットAに登録されているコマンド群が自動で順に実行されます。  
この場合は、「コマンドA」「コマンドB」「コマンドC」の順に実行が行われます。  

Makefile 内では **定数** を利用することが出来ます。  
使用するライブラリのパスなど、文字列の長さが長く、変更の可能性がないものなどを登録することで、全体の記述量を減らすことが出来ます。

```
定数名 := 文字列
```

定数は次のように記述することで、その内容を参照することが出来ます。  

```
$(定数名)
```

以上のことを踏まえ、今回のラーメンタイマー開発で使用するMakefileを次に示します。  
Makefile は src を同じ階層に保存してください。  

```
├── Makefile
├── README.md
├── bin
│   └── Main.class
└── src
    ├── Main.java
    └── fxml
        └── MainUI.fxml
```

```Makefile
# Makefile

JAVAFX_PATH := JavaFXライブラリが配置されているパス
JAVAFX_MODULES := javafx.controls,javafx.base,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

OPTS := -p $(JAVAFX_PATH)/lib --add-modules $(JAVAFX_MODULES)
JAVA_OPTS := $(OPTS) -classpath bin
JAVAC_OPTS := $(OPTS) -sourcepath src -d bin


run:
	cp -r src/fxml bin
	java $(JAVA_OPTS) Main


compile:
	javac $(JAVAC_OPTS) src/Main.java

```

この Makefile を用いることで、コンパイルや実行は次のコマンドで代用することが出来ます。

```
# コンパイル
$ make compile

# 実行
$ make run
```