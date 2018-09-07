/*
 *
 */
package com.phoneon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.phoneon.dto.Student;
import com.phoneon.util.DBConnection;

/**
 *
 * @author Ravi
 *
 */

public class StudentDaoImpl implements StudentDao{

	DBConnection dbConnection = null;
	Connection con = null;
	PreparedStatement preparedStatement = null;
	LinkedHashMap<String, List<Student>> studentMap = new LinkedHashMap<String, List<Student>>();
	List<Student> studentList =  new ArrayList<Student>();;

	@Override
	public LinkedHashMap<String, List<Student>> listAll() {

		String selectSQL = "select stu.name, sub.sub_name, m.marks from student stu inner join student_sub_rel ssr on stu.id = ssr.student_id right join subject sub on sub.id= ssr.subject_id right join marks m on m.student_id = stu.id and m.sub_id = sub.id";

		try {
			dbConnection = new DBConnection();
			con = dbConnection.getConnection();
			preparedStatement = con.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			Student stu = null;
			String name = null;
			String subName = null;

			while (rs.next()) {
				stu = new Student();
				if(name == null){
					name = rs.getString("name");
				}

				if(subName == null){
					subName = rs.getString("sub_name");
				}

				stu.setStudentName(rs.getString("name"));
				stu.setSubject(rs.getString("sub_name"));
				stu.setMarks(Integer.parseInt(rs.getString("marks")));

				if(subName != null && !subName.equals(stu.getMarks())){
					subName = rs.getString("sub_name");
				}

				if(name != null && !name.equals(stu.getStudentName())){

					studentMap.put(name + "-" + subName + "-" + calculateAverage(subName), studentList);
					name = rs.getString("name");
					studentList = new ArrayList<Student>();
				}
				studentList.add(stu);
			}

			studentMap.put(name + "-" + subName + "-" + calculateAverage(subName), studentList);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return studentMap;
	}

	public int calculateAverage(String subjectName){
		String selectSQL = "select avg(m.marks) as avg from marks m left join subject s on m.sub_id=s.id where s.sub_name = ?";
		int avg = 0;
		try {
			dbConnection = new DBConnection();
			con = dbConnection.getConnection();
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, subjectName.trim());

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				avg = rs.getInt("avg");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return avg;
	}
}//end of the class
