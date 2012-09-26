package org.cath.ec.dao;

import java.util.List;

import org.cath.ec.model.Room;

public class RoomDao extends AbstractDao {

    public Room get(int id) {
        return super.get(Room.class, id);
    }

    public List<Room> getAll() {
        return super.getAll(Room.class);
    }

    public List<Room> getAll(int start, int limit, String sortBy, boolean sortASC) {
        return super.getAll(Room.class, start, limit, sortBy, sortASC);
    }

    public boolean save(Room r) {
        return super.save(r);
    }

    public boolean delete(Room r) {
        return super.delete(r);
    }

    public boolean delete(int id) {
        return super.delete(Room.class, id);
    }
}
