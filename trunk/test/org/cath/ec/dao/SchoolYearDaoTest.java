package org.cath.ec.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.cath.ec.model.Course;
import org.cath.ec.model.Grade;
import org.cath.ec.model.Room;
import org.cath.ec.model.SchoolYear;
import org.cath.ec.model.Semester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SchoolYearDaoTest {
    SchoolYearDao dao;
    @Before
    public void setUp() throws Exception {
        dao = new SchoolYearDao();
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void testGetInt() {
        System.out.println(dao.get(4).toJson());
    }

    @Test
    public void testGetAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAllIntIntStringBoolean() {
        fail("Not yet implemented");
    }

    //@Test
    public void testSaveSchoolYear() {
        SchoolYear year = new SchoolYear();
        year.setName("2012-2013");
        year.setYear(2013);

        Course c1 = new Course("RL1", "R L 1");
        year.addCourse(c1);
        year.addCourse(new Course("HS1", "H S 1"));

        year.addGrade(new Grade("hs"));
        year.addGrade(new Grade("rl"));
        year.addGrade(new Grade("kt"));

        year.addRoom(new Room("R01", "Behind apple tree"));
        year.addRoom(new Room("R02", "Under apple tree"));
        year.addRoom(new Room("R03", "Beside apple tree"));

        year.addSemester(new Semester("HK1", new Date(), new Date()));
        year.addSemester(new Semester("HK2", new Date(), new Date()));

        dao.save(year);
        
    }

    @Test
    public void testDeleteSchoolYear() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteInt() {
        fail("Not yet implemented");
    }
}
