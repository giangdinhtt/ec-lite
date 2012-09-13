package org.cath.ec.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        try{
            System.out.println('\u1110');
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
 
            System.out.println(rename(s));
        }
        catch(IOException e)
        {
                e.printStackTrace();
        }
        
    }
    public static String rename(String file)
    {
        file = file.replace('\u1110', 'd');
        file = file.replace('\340', 'a');
        file = file.replace('\341', 'a');
        file = file.replace('\u1EA3', 'a');
        file = file.replace('\343', 'a');
        file = file.replace('\u1EA1', 'a');
        file = file.replace('\u0103', 'a');
        file = file.replace('\u1EB1', 'a');
        file = file.replace('\u1EAF', 'a');
        file = file.replace('\u1EB3', 'a');
        file = file.replace('\u1EB5', 'a');
        file = file.replace('\u1EB7', 'a');
        file = file.replace('\342', 'a');
        file = file.replace('\u1EA7', 'a');
        file = file.replace('\u1EA5', 'a');
        file = file.replace('\u1EA9', 'a');
        file = file.replace('\u1EAB', 'a');
        file = file.replace('\u1EAD', 'a');
        file = file.replace('\300', 'a');
        file = file.replace('\301', 'a');
        file = file.replace('\u1EA2', 'a');
        file = file.replace('\303', 'a');
        file = file.replace('\u1EA0', 'a');
        file = file.replace('\u0102', 'a');
        file = file.replace('\u1EB0', 'a');
        file = file.replace('\u1EAE', 'a');
        file = file.replace('\u1EB2', 'a');
        file = file.replace('\u1EB4', 'a');
        file = file.replace('\u1EB6', 'a');
        file = file.replace('\302', 'a');
        file = file.replace('\u1EA6', 'a');
        file = file.replace('\u1EA4', 'a');
        file = file.replace('\u1EA8', 'a');
        file = file.replace('\u1EAA', 'a');
        file = file.replace('\u1EAC', 'a');
        file = file.replace('\u0111', 'd');
        file = file.replace('\u0110', 'd');
        file = file.replace('\350', 'e');
        file = file.replace('\351', 'e');
        file = file.replace('\u1EBB', 'e');
        file = file.replace('\u1EBD', 'e');
        file = file.replace('\u1EB9', 'e');
        file = file.replace('\352', 'e');
        file = file.replace('\u1EC1', 'e');
        file = file.replace('\u1EBF', 'e');
        file = file.replace('\u1EC3', 'e');
        file = file.replace('\u1EC5', 'e');
        file = file.replace('\u1EC7', 'e');
        file = file.replace('\310', 'e');
        file = file.replace('\311', 'e');
        file = file.replace('\u1EBA', 'e');
        file = file.replace('\u1EBC', 'e');
        file = file.replace('\u1EB8', 'e');
        file = file.replace('\312', 'e');
        file = file.replace('\u1EC0', 'e');
        file = file.replace('\u1EBE', 'e');
        file = file.replace('\u1EC2', 'e');
        file = file.replace('\u1EC4', 'e');
        file = file.replace('\u1EC6', 'e');
        file = file.replace('\354', 'i');
        file = file.replace('\355', 'i');
        file = file.replace('\u1EC9', 'i');
        file = file.replace('\u0129', 'i');
        file = file.replace('\u1ECB', 'i');
        file = file.replace('\314', 'i');
        file = file.replace('\315', 'i');
        file = file.replace('\u1EC8', 'i');
        file = file.replace('\u0128', 'i');
        file = file.replace('\u1ECA', 'i');
        file = file.replace('\362', 'o');
        file = file.replace('\363', 'o');
        file = file.replace('\u1ECF', 'o');
        file = file.replace('\365', 'o');
        file = file.replace('\u1ECD', 'o');
        file = file.replace('\364', 'o');
        file = file.replace('\u1ED3', 'o');
        file = file.replace('\u1ED1', 'o');
        file = file.replace('\u1ED5', 'o');
        file = file.replace('\u1ED7', 'o');
        file = file.replace('\u1ED9', 'o');
        file = file.replace('\u01A1', 'o');
        file = file.replace('\u1EDD', 'o');
        file = file.replace('\u1EDB', 'o');
        file = file.replace('\u1EDF', 'o');
        file = file.replace('\u1EE1', 'o');
        file = file.replace('\u1EE3', 'o');
        file = file.replace('\322', 'o');
        file = file.replace('\323', 'o');
        file = file.replace('\u1ECE', 'o');
        file = file.replace('\325', 'o');
        file = file.replace('\u1ECC', 'o');
        file = file.replace('\324', 'o');
        file = file.replace('\u1ED2', 'o');
        file = file.replace('\u1ED0', 'o');
        file = file.replace('\u1ED4', 'o');
        file = file.replace('\u1ED6', 'o');
        file = file.replace('\u1ED8', 'o');
        file = file.replace('\u01A0', 'o');
        file = file.replace('\u1EDC', 'o');
        file = file.replace('\u1EDA', 'o');
        file = file.replace('\u1EDE', 'o');
        file = file.replace('\u1EE0', 'o');
        file = file.replace('\u1EE2', 'o');
        file = file.replace('\371', 'u');
        file = file.replace('\372', 'u');
        file = file.replace('\u1EE7', 'u');
        file = file.replace('\u0169', 'u');
        file = file.replace('\u1EE5', 'u');
        file = file.replace('\u01B0', 'u');
        file = file.replace('\u1EEB', 'u');
        file = file.replace('\u1EE9', 'u');
        file = file.replace('\u1EED', 'u');
        file = file.replace('\u1EEF', 'u');
        file = file.replace('\u1EF1', 'u');
        file = file.replace('\331', 'u');
        file = file.replace('\332', 'u');
        file = file.replace('\u1EE6', 'u');
        file = file.replace('\u0168', 'u');
        file = file.replace('\u1EE4', 'u');
        file = file.replace('\u01AF', 'u');
        file = file.replace('\u1EEA', 'u');
        file = file.replace('\u1EE8', 'u');
        file = file.replace('\u1EEC', 'u');
        file = file.replace('\u1EEE', 'u');
        file = file.replace('\u1EF0', 'u');
        file = file.replace('\u1EF3', 'y');
        file = file.replace('\375', 'y');
        file = file.replace('\u1EF7', 'y');
        file = file.replace('\u1EF9', 'y');
        file = file.replace('\u1EF5', 'y');
        file = file.replace('Y', 'y');
        file = file.replace('\u1EF2', 'y');
        file = file.replace('\335', 'y');
        file = file.replace('\u1EF6', 'y');
        file = file.replace('\u1EF8', 'y');
        file = file.replace('\u1EF4', 'y');
        return file;
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
        String query = String.format("insert into XepLop(Ten) values('%s')", "");
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
