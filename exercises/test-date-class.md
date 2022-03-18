# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {
	
	private int day;
	private int month;
	private int year;

    public Date(int day, int month, int year) {
    	this.day = day;
    	this.month = month;
    	this.year = year;
    }

    public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public static boolean isValidDate(int day, int month, int year) {
    	return 0<day && day<=31 && 0<month && month<=12 && year>=0;
    }

    public static boolean isLeapYear(int year) {
    	if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }else {
                	return false;
                }
            }
            return true;
        }
        return false;
    }

    public Date nextDate() {
    	int newDay = day;
    	int newMonth = month;
    	int newYear = year;
    	newDay++;
    	if(newDay>31) {
    		newDay = 1;
    		newMonth++;
    		if(newMonth>12) {
    			newMonth = 1;
    			newYear++;
    		}
    	}
    	return new Date(newDay, newMonth, newYear);
    }

    public Date previousDate() {
    	int newDay = day;
    	int newMonth = month;
    	int newYear = year;
    	newDay--;
    	if(newDay<1) {
    		newDay = 31;
    		newMonth--;
    		if(newMonth<1) {
    			newMonth = 12;
    			newYear--;
    		}
    	}
    	return new Date(newDay, newMonth, newYear);
    }

    public int compareTo(Date other) {
    	if(other.getYear() == year) {
    		if(other.getMonth() == month) {
    			return day - other.getDay();
    		}
    		return month - other.getMonth();
    	}
    	return year - other.getYear();
    }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1.  La partition est : Pour isValidDate() on a les dates valides ou non. Pour isLeapYear() on vérifie si c’est bissextile ou non. Pour nextDate() et previousDate() on fait un cas simple et un qui change de mois. Et pour compareTo() on fais les 3 cas possible plus on vérifie si il renvoie une null exception.

2.  Ajout de test pour les leaps year pour passer dans tous les cas:

```java
class DateTest {

	@Test
	void test() {
		//is not valid with 13 month, 31 or 32 day ...
		assertFalse(Date.isValidDate(13, 13, 1996));
		assertTrue(Date.isValidDate(31, 1, 2022));
		assertFalse(Date.isValidDate(32, 1, 2000));
		assertFalse(Date.isValidDate(0, 0, 0));
		
		//leap or not leap
		assertTrue(Date.isLeapYear(2004));
		assertFalse(Date.isLeapYear(2003));
		assertTrue(Date.isLeapYear(2000));
		assertFalse(Date.isLeapYear(1900));
       }
}
```

3.  Ajout de test pour nextDate() et previousDate() avec les années qui changent:

```java
class DateTest {

	@Test
	void test() {
		//next date simple and with new month
		assertTrue(new Date(12,12,1578).nextDate().getDay()==13);
		assertTrue(new Date(31,5,1578).nextDate().getDay()==1);
		assertTrue(new Date(31,12,1578).nextDate().getYear()==1579);
		
		//previous date simple and with new month
		assertTrue(new Date(1,12,1578).previousDate().getDay()==31);
		assertTrue(new Date(31,5,1578).previousDate().getDay()==30);
		assertTrue(new Date(1,1,1578).previousDate().getYear()==1577);
        }
}
```
4.  PIT a généré 49 mutations pour un score de 76%. Après l’ajout d’un test pour compareTo en fonction du mois on passe à 80%.

Les tests compareTo sont les suivants:

```java
class DateTest {

	@Test
	void test() {
		//compare equal posterior and anterior and null
		assertThrows(NullPointerException.class, () -> new Date(12,12,1578).compareTo(null));
		assertTrue(new Date(12,12,1578).compareTo(new Date(12,12,1578))==0);
		assertTrue(new Date(12,12,1578).compareTo(new Date(20,12,1578))<0);
		assertTrue(new Date(20,12,1578).compareTo(new Date(12,12,1578))>0);
		assertTrue(new Date(20,11,1578).compareTo(new Date(12,12,1578))<0);
	}
}
```
