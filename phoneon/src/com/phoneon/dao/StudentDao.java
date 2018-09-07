/*
 *
 */
package com.phoneon.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.phoneon.dto.Student;


/**
 *
 * @author Ravi
 *
 */
public interface StudentDao {
	public LinkedHashMap<String, List<Student>> listAll();
}
