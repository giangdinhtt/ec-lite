package org.cath.ec.dao;

import java.util.List;

import org.cath.ec.model.Date;

public class DateDao extends AbstractDao {

    public Date get(int id) {
        return super.get(Date.class, id);
    }

    public List<Date> getAll() {
        return super.getAll(Date.class);
    }

    public List<Date> getAll(int start, int limit, String sortBy, boolean sortASC) {
        return super.getAll(Date.class, start, limit, sortBy, sortASC);
    }

    public boolean save(Date d) {
        return super.save(d);
    }

    public boolean delete(Date d) {
        return super.delete(d);
    }

    public boolean delete(int id) {
        return super.delete(Date.class, id);
    }
}
