
Test%.class: Test%.java
	javac -cp /usr/share/java/junit4.jar *.java

%.class: %.java
	javac $<

doc: *java
	javadoc *java -encoding utf8 -docencoding utf8 -charset utf8 -d doc

testPoint2D: TestPoint2D.class
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore TestPoint2D

test: testPoint2D
