package org.cath.ec.dao;

import java.util.List;

import org.cath.ec.model.SchoolYear;

public class SchoolYearDao extends AbstractDao {

    public SchoolYear get(int id) {
        return super.get(SchoolYear.class, id);
    }

    public List<SchoolYear> getAll() {
        return super.getAll(SchoolYear.class);
    }

    public List<SchoolYear> getAll(int start, int limit, String sortBy, boolean sortASC) {
        return super.getAll(SchoolYear.class, start, limit, sortBy, sortASC);
    }

    public boolean save(SchoolYear year) {
        return super.save(year);
    }

    public boolean delete(SchoolYear year) {
        return super.delete(year);
    }

    public boolean delete(int id) {
        return super.delete(SchoolYear.class, id);
    }
}
