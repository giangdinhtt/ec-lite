package org.cath.ec.bus;

import org.cath.ec.dao.DataConnection;

public class BUS {

    public static String search(String keyword) {
        return DataConnection.search(keyword);
    }

    public static boolean update(String keyword) {
        return DataConnection.update(keyword);
    }

    public static boolean add(String keyword) {
        return DataConnection.add(keyword);
    }

    public static boolean remove(String id) {
        return DataConnection.remove(id);
    }
}
