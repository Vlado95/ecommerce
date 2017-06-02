package com.boutique.dao.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boutique.admin.entity.User;
import com.boutique.dao.IDaoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/jpaSpringConf.xml" })
public class DaoUserTest {

	@Autowired
	private IDaoUser daoUser; // ? tester

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectById() {
		User user = daoUser.selectById(1);
		Assert.assertTrue(user.getId() == 1);
		System.out.println(user.toString());

	}

	@Test
	public void testFindByEmailPdw() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchLike() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
