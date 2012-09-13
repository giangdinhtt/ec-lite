package org.cath.ec.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataConnection {

    public DataConnection() {
    }

    final static public Connection connect() throws ClassNotFoundException, SQLException {

        Connection conn = null;
        // try {
        Properties prop = new Properties();
        prop.put("charSet", "UTF8");
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String connectionString = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ=E:\\EclipseWorkspace\\EC-mini\\db2.mdb";
        conn = DriverManager.getConnection(connectionString, prop);
        // } catch (Exception ex) {
        // System.out.println(ex.toString());
        // }

        return conn;
    }

    final static public void main(String[] arg) throws SQLException {
        /*Connection con = null;
        try {
            con = DataConnection.Connect();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PreparedStatement s = con.prepareStatement("select * from XepLop");
        ResultSet set = s.executeQuery();
        while (set.next()) {
            System.out.println(set.getString("Ten"));
        }*/
        DataConnection.search("a");
    }

    public static String search(String keyword) {
        String jsonString = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DataConnection.connect();
            String query = String.format("select * from XepLop where Ten like \'%%%s%%\';", keyword);
            System.out.println(query);
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("ID\tTenThanh\tHo\tTen\tNgaySinh\tLopCu\tLopMoi\tTinhTrang");
            JSONArray arr = new JSONArray();
            int idx = 0;
            while (rs.next()) {
                int id = rs.getInt("ID");
                String tenThanh = rs.getString("TenThanh");
                String ho = rs.getString("Ho");
                String ten = rs.getString("Ten");
                String ngaySinh = rs.getString("NgaySinh");
                String lopCu = rs.getString("LopCu");
                String tinhTrang = rs.getString("TinhTrang");
                String lopMoi = rs.getString("LopMoi");
                System.out.println(id + "\t" + tenThanh + "\t" + ho + "\t" + ten + "\t" + ngaySinh + "\t" + lopCu + "\t" + lopMoi + "\t" + tinhTrang);
                JSONObject json = new JSONObject().put("ID", id).put("TenThanh", tenThanh).put("Ho", ho).put("Ten", ten).put("NgaySinh", ngaySinh).put("LopCu", lopCu).put("LopMoi", lopMoi).put("TinhTrang", tinhTrang);
                arr.put(idx++, json);
            }
            jsonString = arr.toString();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jsonString;
    }

    public static boolean update(String keyword) {
        boolean success = false;
/*        //cau truy van update du lieu
        String query = String.format("update ACCOUNT set AccountName = '%s', ContactID = %d, " +
                "IncomingServerID = %d, OutgoingServerID = %d, FolderID = %d, " +
                "CheckAtStartup = %b, CheckDuration = %b, Duration = %d where AccountID = %d",
                acc.getAccountName(), acc.getContactID(), acc.getIncomingServerID(),
                acc.getOutgoingServerID(),acc.getFolderID(), acc.isStartupCheck(),
                acc.isCheckDuration(),acc.getDuration(),acc.getAccountID());
        try {
            Connection conn = DataConnection.Connect();
            Statement st = conn.createStatement();

            int result = st.executeUpdate(query);
            //neu update thanh cong
            if (result != 0) {
                success = true;
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/        return success;
    }

    public static boolean add(String keyword) {
        boolean success = false;
/*        //cau truy van insert du lieu chu y neu la chuoi string thi phai dat chuoi format trong dau '', vi du '%s'
        String query = String.format("insert into ACCOUNT(AccountName, ContactID," +
                " IncomingServerID, OutgoingServerID, FolderID, CheckAtStartup, CheckDuration, Duration) " +
                "values('%s',%d,%d,%d,%d,%b,%b,%d)", acc.getAccountName(), acc.getContactID(),
                acc.getIncomingServerID(), acc.getOutgoingServerID(),acc.getFolderID(),
                acc.isStartupCheck(),acc.isCheckDuration(),acc.getDuration());
        //cau truy van de lay so autonumber vua duoc cap
        String getID = "select @@IDENTITY";
        try {
            Connection conn = DataConnection.Connect();
            Statement st = conn.createStatement();
            int result = st.executeUpdate(query);
            //neu insert thanh cong
            if (result != 0) {
                success = true;
                //lay so autonumber vua duoc cap
                Statement st2 = conn.createStatement();
                ResultSet r = st2.executeQuery(getID);
                if (r.next()) {
                    acc.setAccountID(r.getInt(1));
                }
            }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

*/
        String query = String.format("insert into XepLop(Ten) values('%s')", "Đinh Trường Trúc AAAAAAA");
        try {
            Connection conn = DataConnection.connect();
            Statement st = conn.createStatement();
            int result = st.executeUpdate(query);
            //neu insert thanh cong
            if (result != 0) {
                success = true;
                           }
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }


    public static boolean remove(String id) {
        boolean success = false;
        String query = String.format("delete from XepLop where ID = \'%s\'", id);
        try {
            Connection conn = DataConnection.connect();
            PreparedStatement ps = conn.prepareStatement(query);
            int result = ps.executeUpdate();
            if (result != 0) {
                success = true;
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return success;
    }
}
