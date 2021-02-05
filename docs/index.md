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
    2. 起動準備
        1. Main.java作成
        2. Makefile作成
        3. UI起動確認
    3. プログラミングの準備
        1. MainUIController.java作成
        2. 時刻表示テキストを変更してみる
        3. ボタンクリック時の動作を実装してみる
        4. コードの整理
        5. ID設定
        6. Timer.javaの準備
    4. タイマーの実装
        1. 時刻の初期化
        2. 10分増加ボタンの実装

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

## 3.2. 起動準備

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

## 3.2.3. UI起動確認

3.1.で作成したUIが正常に起動することを確認します。  

Main.javaを次のように編集してください。  
**※3.2.1.で記述した内容はすべて削除してください**

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // シーン作成
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainUI.fxml"));
            Scene scene = new Scene(loader.load());

            // ステージ初期化
            stage.setTitle("ラーメンタイマー");
            stage.setScene(scene);

            // UI表示
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
```

「**シーン作成**」では、3.1.で作成した MainUI.fxml の読み込みを行い、**Scene** の初期化を行っています。  
「**ステージ初期化**」では初期化済みの Scene を **Stage** に登録する処理を行います。  
このタイミングでウィンドウタイトルの設定を行います。  
 
実行時に実際に表示される画面は Stage 、UIコンポーネントの統括的な管理を行うものが Scene です。  
JavaFXアプリケーションにおける Stage と Scene の関係は以下に示す図を参照してください。 

[Figure](https://lh3.googleusercontent.com/proxy/7J3Tx0l9387UbgHYI-y-CCnQDaVFJiLd4CpBBpMzX0D_BT9X5HwUt1nfSwBH_5HaW6tr1WtK6v6H7PclZSBc35ndetvm7QNl20wBIdFnChPq8qfKmTJLSxlaJyA)

編集後は次のコマンドを実行して、正常にUIが表示されることを確認してください。

```
$ make compile
$ make run
```

*16.png*

## 3.3. プログラミングの準備

## 3.3.1. MainUIController.java作成

3.2.3.までの内容でUIの起動を表示確認を行うことが出来ました。    
ボタンクリック時の挙動など、UIコンポーネントに意味をもたせるためには Controller を使用します。  

以下に示す場所に **MainUIController.java** を作成し、テキストエディタで内容を記述してください。

```
.
├── Makefile
├── README.md
├── bin
│   ├── Main.class
│   └── fxml
│       └── MainUI.fxml
└── src
    ├── Main.java
    ├── MainUIController.java
    └── fxml
        └── MainUI.fxml
```

```java
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resource) {}

}
```

次に MainUI.java を開き

```java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainUI.fxml"));
```

の次の行に

```java
loader.setController(new MainUIController());
```

を追加してください。  

追加後の Main.java は以下のようになります。  

```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            // シーン作成
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainUI.fxml"));
            loader.setController(new MainUIController());
            Scene scene = new Scene(loader.load());

            // ステージ初期化
            stage.setTitle("ラーメンタイマー");
            stage.setScene(scene);

            // UI表示
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
```

ここで作成した MainUIController には動作を記述してないため新しい動きをするなどはありませんが、プログラムのチェックのためにコンパイルと実行を行ってください。  

```
$ make compile
$ make run
```

3.2.3.と同じように UI が表示された場合、正常に動作しています。  


## 3.3.2. 時刻表示テキストを変更してみる

3.3.1.で作成した MainUIController の動作を確認してみます。  

Controller から UI の表示を制御する場合、制御したいUIコンポーネントに ID を設定する必要があります。  
ここでは、時刻表示テキストを Controller から変更してみます。  

--

まず、SceneBuilder で MainUI.fxml を開きます。  
次に、時刻表示テキストをクリックし、画面右側の「インスペクタ/**Code**」を選択します。  
そして **fx:id入力欄** にIDを設定します。  
任意のIDを設定することが出来ますが、ここでは **clockText** とします。

*17.png*


以上の操作により、時刻表示テキストは ID "clockText" が設定され、 Controller から制御することが可能になりました。  

---

MainUIController.java をテキストエディタで開き、次のように編集してください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        clockText.setText("12:04");
    }

}
```
**(変更: 1, 3, 10, 11, 15行目)**  

FXMLファイルに記述されたUIコンポーネントの制御のために必要なクラスを使用できるように、1、3行目に import 文が追加されています。  
また、Text クラスの変数 clockText を10、11行目で宣言しています。  
このように**変数名とIDを対応付ける**ことで、FXMLファイル内のUIコンポーネントを Controller から使用することが出来ます。  
15行目では、clockText の **setTextメソッド** を用いて時刻表示テキストに表示する文字列が "12:04" となるように処理を行っています。  

**initializeメソッド** は Controller の初期化時に1度だけ実行されるものです。  

この状態でコンパイルし実行すると、時刻表示テキストが指定した文字列に変更されていることが確認できます。  

```
$ make compile
$ make run
```

*18.png*

## 3.3.3. ボタンクリック時の動作を実装してみる

3.3.2.では Controller 初期化時に時刻表示テキストの変更を行いました。  
3.3.3.ではスタートボタンをクリックした時に時刻表示できストを変更するようにしてみます。  

まず、3.3.2.と同様にしてスタートボタンに **startButton** という ID を設定してください。  
次に、MainUIController.java を以下のように編集してください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        startButton.setOnAction(event -> {
            clockText.setText("12:04");
        });
    }

}
```
**(変更: 4, 13, 14, 18, 19, 20行目)**

ボタンクリック時の動作は、**setOnActionメソッド** を上のように記述することで実装することが出来ます。  
複数の動作を設定することもでき、その場合は `{}` の内部に複数行の処理を記述します。   

この状態でコンパイルし実行すると、スタートボタンを押すと時刻表示テキストが指定した文字列に変更されることが確認できます。  

```
$ make compile
$ make run
```

*19.png*


## 3.3.4. コードの整理

ラーメンタイマーの実装を行う前に、3.3.2.と3.3.3.で追記したコードを削除します。  
MainUIController.java を次のようにしてください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resource) {}

}
```

## 3.3.5. ID設定

3.3.2.と3.3.3.では時刻表示テキストとスタートボタンに ID を設定しました。  
ここでは、制御対象である全てのUIコンポーネントに ID を設定します。  

以下のように ID の設定を行ってください。  

- +10分: **plus10Min**
- +1分: **plus1Min**
- -10分: **minus10Min**
- -1分: **minus1Min**
- ストップボタン: **stopButton**

MainUIController.java を次のように編集してください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button plus10Min, plus1Min, minus10Min, minus1Min, startButton, stopButton;

    @Override
    public void initialize(URL location, ResourceBundle resource) {}

}
```
**(変更: 14行目)**

変更後はコンパイルと実行を行い、正常にUIが表示されることを確認してください。  
もしエラーが発生する場合、IDの設定ミスの可能性があります。  

## 3.3.6. Timer.javaの準備

ラーメンタイマー実装の前に、**Timer.java** を準備します。  
Timer.java は時刻管理を行うためのクラスが記述されたプログラムファイルです。  
本稿では JavaFX を用いた GUI をもつアプリケーションの作成に焦点を当てているためタイマーの実装は省略します。  

次のプログラムを Timer.java として以下に示す場所に保存してください。  

```
.
├── Makefile
├── README.md
├── bin
│   ├── Clock.class
│   ├── Main.class
│   ├── MainUIController.class
│   └── fxml
│       └── MainUI.fxml
└── src
    ├── Main.java
    ├── MainUIController.java
    ├── Timer.java
    └── fxml
        └── MainUI.fxml
```

```java
public class Timer {

    private int second = 0;
    public static final int M = 60, S = 1;

    public Timer(int m, int s) {
        set(m, s);
    }

    public void set(int m, int s) {
        second = m*M + s*S;
    }

    public void tick() {
        tick(1);
    }

    public void tick(int t) {
        // 加算
        second += t;

        // 繰り上げ処理
        if(second >= 60*100)
            second %= 60*100;
        if(second < 0)
            second = (60*100)-Math.abs(second)%(60*100);
    }

    public String toString() {
        return String.format("%02d:%02d", second/M, second%M);
    }
}
```

## 3.4. タイマーの実装

## 3.4.1. 時刻の初期化

タイマー起動時に時刻表示を3分で初期化するようにします。  
また、内部でタイマーとして扱うTimerクラスのインスタンス化と初期化も行います。  

MainUIController.java を次のように編集してください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button plus10Min, plus1Min, minus10Min, minus1Min, startButton, stopButton;

    private Timer timer;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // 初期化時に3分を設定
        timer = new Timer(3, 0);
        clockText.setText("03:00");
    }

}
```
**(変更: 16, 20, 21, 22, 23行目)**

16行目では3.3.6.で準備した Timer を扱うための変数を宣言しています。  
20\~23行目では、timer と時刻表示テキストを3分で初期化しています。  

正常に変更できている場合、次のように表示されます。  

*20.png*

## 3.4.2. 10分増加ボタンの実装

タイマーの時刻を調整するボタンのうちの1つである、10分増加ボタンの動作を実装します。  

MainUIController.java を次のように変更してください。  

```java
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private Text clockText;
    @FXML
    private Button plus10Min, plus1Min, minus10Min, minus1Min, startButton, stopButton;

    private Timer timer;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // 初期化時に3分を設定
        timer = new Timer(3, 0);
        clockText.setText("03:00");

        // 10分増加ボタンが押されたときの動作
        plus10Min.setOnAction(event -> {
            timer.tick(10*60);
            clockText.setText( timer.toString() );
        });
    }

}
```
**(変更: 24, 25, 26, 27, 28行目)**

Timerクラスには **tickメソッド** が実装されており、引数で指定された秒数だけ内部の時刻を進めるという処理を行います。  
26行目では、10分増加ボタンが押された時に Timer インスタンスがもつ時刻を 600 秒 (=10分) 進めるという処理を行っています。
 
Timerクラスには **toStringメソッド** が実装されており、時刻データを文字列の形式へ変換するという処理を行います。  
27行目では、toString メソッドの実行結果を時刻表示テキストにセットすることで、時刻の更新処理を行っています。  

正常に実装出来ている場合、10分増加ボタンを押すことで時刻表示テキストが更新されます。  

*21.png*

