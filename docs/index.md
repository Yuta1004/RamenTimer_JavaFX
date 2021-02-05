# RamenTimer (with JavaFX)

## 目次

1. 環境
2. 完成品
3. 開発
    1. UI作成

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
画面左下にある「階層」タブから、**VBox**以外のUIコンポーネントを削除します。

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
