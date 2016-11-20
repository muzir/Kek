package com.muzir.kek.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashyTest {

	private Hashy hashy;

	@Before
	public void setUp() throws Exception {
		hashy = new Hashy();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldNullAndEmptyParameter() {
		Assert.assertEquals("", hashy.calculateHash(""));
		Assert.assertEquals("", hashy.calculateHash(null));
	}

	@Test
	public void shouldNotNull() {
		Assert.assertNotNull(hashy.calculateHash("pass"));
	}

	@Test
	public void shouldVerifySameValue() {
		String parameter = "password";
		String calculatedHash = hashy.calculateHash(parameter);
		Assert.assertTrue(hashy.verifyHash(calculatedHash, parameter));
	}
}
