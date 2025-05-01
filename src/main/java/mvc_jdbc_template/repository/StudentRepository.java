package mvc_jdbc_template.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import mvc_jdbc_template.model.Student;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Student> getAll() {
        String query="SELECT * FROM students";
        return jdbcTemplate.query(query,(rs,rowNum)->
                new Student(rs.getLong("id"),rs.getString("name"))
        );
    }

    public int delete(long id) {
        String query="DELETE FROM students WHERE id=?";
        return jdbcTemplate.update(query,id);
    }

    public int save(Student student) {
        String query="INSERT INTO students (name) VALUES (?)";
        return jdbcTemplate.update(query,student.getName());
    }

    public int update(Student student) {
        String query="UPDATE students SET name=? WHERE id=?";
        return jdbcTemplate.update(query,student.getName(),student.getId());
    }

    public Student getById(long id){
        String query="SELECT * FROM students WHERE id=?";
        try{
            return  jdbcTemplate.queryForObject(query,(rs,rowNum)->
                    new Student(id,rs.getString("name")),id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
