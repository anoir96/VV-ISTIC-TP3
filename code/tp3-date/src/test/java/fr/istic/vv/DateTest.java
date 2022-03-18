package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
		
		//next date simple and with new month
		assertTrue(new Date(12,12,1578).nextDate().getDay()==13);
		assertTrue(new Date(31,5,1578).nextDate().getDay()==1);
		assertTrue(new Date(31,12,1578).nextDate().getYear()==1579);
		
		//previous date simple and with new month
		assertTrue(new Date(1,12,1578).previousDate().getDay()==31);
		assertTrue(new Date(31,5,1578).previousDate().getDay()==30);
		assertTrue(new Date(1,1,1578).previousDate().getYear()==1577);
		
		//compare equal posterior and anterior and null
		assertThrows(NullPointerException.class, () -> new Date(12,12,1578).compareTo(null));
		assertTrue(new Date(12,12,1578).compareTo(new Date(12,12,1578))==0);
		assertTrue(new Date(12,12,1578).compareTo(new Date(20,12,1578))<0);
		assertTrue(new Date(20,12,1578).compareTo(new Date(12,12,1578))>0);
		assertTrue(new Date(20,11,1578).compareTo(new Date(12,12,1578))<0);
	}
}
