package org.cath.ec.dao;

import static org.junit.Assert.*;

import org.cath.ec.model.Room;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoomDaoTest {

    RoomDao dao;
    @Before
    public void setUp() throws Exception {
        dao= new RoomDao();
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
    public void testSaveRoom() {
        /*Room r = new Room("R1", "Apple Tree");
        RoomDao dao = new RoomDao();
        dao.save(r);
        assertEquals(r.getId(), new Integer(0));*/
    }

    @Test
    public void testDeleteRoom() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteInt() {
        
    }

}
