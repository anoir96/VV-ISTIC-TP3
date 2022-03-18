# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer
Ici on a utilisé [Apache Commons Lang]
Avec les commandes:
1. alias pmd="$HOME/pmd-bin-6.43.0/bin/run.sh pmd"
2. pmd  -d ../../Master/V\&V/TP3/test\ smell/commons-lang-master/src/test/java -R category/java/bestpractices.xml/JUnitAssertionsShouldIncludeMessage 

Il y a eu plein de test smell. Par exemple :

**/Users/anwar/Document/Master/V&V/TP3/test smell/commons-lang-master/src/test/java/org/apache/commons/lang3/tuple/TripleTest.java:148:	JUnitAssertionsShouldIncludeMessage:	JUnit assertions should include a message**
Il faut simplement rajouter un message pour l'assertion.
