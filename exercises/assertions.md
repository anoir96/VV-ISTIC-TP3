# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1.	L'assertion assertTrue(3 * .4 == 1.2) échoue car 3*.4 sera égal à 1.20000000002 environ. 
On peut utiliser BigDecimal avec : 
```java
assertTrue(BigDecimal.valueOf(3).multiply(BigDecimal.valueOf(.4)).equals(BigDecimal.valueOf(1.2)));
```
2.	assertEquals utilise la méthode equals pour vérifier si les 2 objets sont égaux alors que assertSame utilise l’opér	ateur == pour vérifier si les objets sont égaux.

Voici un scénario pour lequel assertEquals et assertSame renvoit le même résultat : 
```java
@Test
	public void test1() {
		
		assertEquals("test","test");
		assertSame("test","test");
		
	}
```
Voici un scénario pour lequel assertEquals et assertSame ne renvoit pas le même résultat : 
```java
@Test
	public void test2() {
		
String s1 = new String("test"); 
       	             String s2 = new String("test"); 
		assertEquals(s1,s2);
		assertSame(s1, s2);
		
	}

```
4. Le fait d’utiliser assertThrows plutôt que @Test pour la lever d’exception rend plus homogène cette fonctionnalité. On peut également utiliser les lambda avec assertThrows car il provient de JUnit5, et qu’il y a eu l’ajout des lambda suite à cette nouvelle version. Avec assertThrows on peut écrire des exceptions de manière plus lisible, en utilisant des moyens familiers comme les lamba expression. 


