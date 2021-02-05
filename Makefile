# Makefile

JAVAFX_MODULES := javafx.controls,javafx.base,javafx.fxml,javafx.graphics,javafx.media,javafx.swing,javafx.web

OPTS := -p $(JAVAFX_PATH)/lib --add-modules $(JAVAFX_MODULES)
JAVA_OPTS := $(OPTS) -classpath bin
JAVAC_OPTS := $(OPTS) -sourcepath src -d bin


run:
	cp -r src/fxml bin
	java $(JAVA_OPTS) Main


compile:
	javac $(JAVAC_OPTS) src/Main.java

