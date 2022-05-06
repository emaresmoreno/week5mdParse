MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownTest.class: MarkdownParse.java WordCount.class
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

Test: Markdown.class MarkdownTest.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest