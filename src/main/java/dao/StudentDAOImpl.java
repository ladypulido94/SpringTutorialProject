package dao;

import model.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
  private JdbcTemplate jdbcTemplate;

  public StudentDAOImpl( JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }
  @Override
  public Student getStudentById(int id) {
    try {
      return jdbcTemplate.queryForObject("SELECT * FROM Students WHERE studentID=?", new Object[]{12345},
              new BeanPropertyRowMapper<>(Student.class));

    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  @Override
  public List<Student> getAllStudents() {
    return jdbcTemplate.query("SELECT * FROM Students", new BeanPropertyRowMapper<>(Student.class));
  }
}
