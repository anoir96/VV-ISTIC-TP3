# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
    public static boolean isBalanced(String str) {
    	if(str == null) return true;
    	List<Character> l = new ArrayList<Character>();
    	while(str.length() != 0) {
    		char c = str.charAt(0);
    		if(c == ')') {
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('(')) return false;
    		}else if(c == '}'){
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('{')) return false;
    		}else if(c == ']'){
    			if(l.isEmpty() || !l.remove(l.size()-1).equals('[')) return false;
    		}else {
    			l.add(str.charAt(0));
    		}
    		str = str.substring(1);
    	}
    	return l.isEmpty();
    }
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. La partition est : null, vide et cas simple qui fonctionne et d’erreur.

2.  Ajouts de tests simple et plus complexe.
Les tests de l'étape précédente sont donc : 

```java
	@Test
	void test() {
		//null
		assertTrue(StringUtils.isBalanced(null));
		//empty
		assertTrue(StringUtils.isBalanced(""));
		//simple ()
		assertTrue(StringUtils.isBalanced("()"));
		//simple {}
		assertTrue(StringUtils.isBalanced("{}"));
		//simple []
		assertTrue(StringUtils.isBalanced("[]"));
		//complex all ({[
		assertTrue(StringUtils.isBalanced("({[]})"));
		//error (
		assertFalse(StringUtils.isBalanced("("));
		//error {
		assertFalse(StringUtils.isBalanced("{"));
		//error [
		assertFalse(StringUtils.isBalanced("["));
   }

```


3.  Ajout de nombreux cas d’erreur pour passer dans tous les cas des if.

```java
	@Test
	void test() {
		//add test
		//other error for if
		//find bug
		assertFalse(StringUtils.isBalanced("]["));
		assertFalse(StringUtils.isBalanced("(}"));
		assertFalse(StringUtils.isBalanced("}"));
		assertFalse(StringUtils.isBalanced("{)"));
		assertFalse(StringUtils.isBalanced(")"));
		assertFalse(StringUtils.isBalanced("a(a{a[a]a}a)a"));
   }

```

4.  PIT a généré 20 mutations avec un score de 100%.


