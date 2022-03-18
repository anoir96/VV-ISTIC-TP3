package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
  
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


}
