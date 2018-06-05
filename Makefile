JC = javac
JCR = java

.SUFFIXES: .java .class

CLASSES = \
	Main.java \
	InheritanceTree.java \
	ListFiles.java \
	ListAllClasses.java \
	Build_Innerclassestree.java \
	ListInheritanceClasses.java \
	inner_classes_all.java

.java.class:
	$(JC) $*.java

TXT_FILES = \
	one 

default: classes exec-tests

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class *~

exec-tests: classes
	set -e; \
	for file in $(TXT_FILES); do $(JCR) Main $$file; done;


.PHONY: default clean classes exec-tests


