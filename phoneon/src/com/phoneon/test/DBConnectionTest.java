/*
 *
 */
package com.phoneon.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;

import com.phoneon.util.DBConnection;

/**
 *
 * @author Ravi
 *
 */
public class DBConnectionTest {

	@Test
    public void connectionTest() {
		//String url = "jdbc:mysql://localhost:3306/phoneondb";
		//String username = "root";
		//String password = "ravi";
        DBConnection dbConnection = new DBConnection();
        Connection con = dbConnection.getConnection();
        assertEquals(con!= null, true);
    }
}
