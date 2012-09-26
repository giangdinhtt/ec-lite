package org.cath.ec.dao;

import static org.junit.Assert.*;

import org.cath.ec.model.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DateDaoTest {

    DateDao dao;
    @Before
    public void setUp() throws Exception {
        dao = new DateDao();
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void testGetInt() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetAllIntIntStringBoolean() {
        fail("Not yet implemented");
    }

    @Test
    public void testSaveDate() {
        Date d = new Date();
        java.util.Date dt = new java.util.Date();
        dao.save(d);
        System.out.println(dt.getDay() + "-" + dt.getMonth() + "-" + dt.getYear());
        assertEquals(new Integer(1), d.getId());
        assertEquals(dt.getDay(), d.getDay());
        assertEquals(dt.getMonth(), d.getMonth());
        assertEquals(dt.getYear(), d.getYear());
    }

    @Test
    public void testDeleteDate() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteInt() {
        fail("Not yet implemented");
    }
}
