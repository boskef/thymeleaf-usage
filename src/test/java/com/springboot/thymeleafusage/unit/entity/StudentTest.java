package com.springboot.thymeleafusage.unit.entity;

import com.springboot.thymeleafusage.entity.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit Test for {@link Student}
 *
 * @author  Kayhan ÖZTÜRK
 * @version 0.1
 * @since   0.1
 */
public class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student();

        student.setId(1888);
        student.setFirstName("firstName");
        student.setLastName("lastName");
        student.setCreatedDate(new java.util.Date());
    }

    @Test
    public void testGetter(){

        Assert.assertNotNull(student.getId());
        Assert.assertNotNull(student.getFirstName());
        Assert.assertNotNull(student.getLastName());
        Assert.assertNotNull(student.getCreatedDate());
    }
}
