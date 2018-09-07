/*
 *
 */
package com.phoneon.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.phoneon.dao.StudentDao;
import com.phoneon.dao.StudentDaoImpl;

public class StudentDaoImplTest {
	StudentDao sd = null;

	@Test
    public void connectionTest() {
        sd = new StudentDaoImpl();
        assertEquals(sd.listAll().size() > 0, true);
    }
}
