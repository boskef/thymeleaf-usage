package com.springboot.thymeleafusage.unit.service;

import com.springboot.thymeleafusage.entity.Student;
import com.springboot.thymeleafusage.service.StudentService;
import com.springboot.thymeleafusage.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for {@link StudentServiceImpl}
 *
 * @author  Kayhan Öztürk
 * @version 0.1
 * @since   0.1
 */
public class StudentServiceImplTest {

    private StudentService studentService;
    private Student student;
    private List<Student> studentList;

    @Before
    public void setUp() throws Exception {
        studentService = mock(StudentService.class);
        student = mock(Student.class);
        studentList = new ArrayList<Student>();
    }

    @Test
    public void testFindAll(){
        when(studentService.findAll()).thenReturn(studentList);
    }

    @Test
    public void testFindById(){
        when(studentService.findById(1)).thenReturn(student);
    }

    @Test
    public void testSave(){
       studentService.save(student);
    }

    @Test
    public void testDeleteById(){
        int theStudentId = 1;
        Assert.assertNotNull(theStudentId);

        studentService.deleteById(theStudentId);
    }


}
