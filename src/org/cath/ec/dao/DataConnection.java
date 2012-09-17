package org.cath.ec.dao;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataConnection {

    public DataConnection() {
    }

    final static public Connection connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        // Initialize connection configurations
        ResourceBundle rb=ResourceBundle.getBundle("connection");
        String driver=rb.getString("db.driver");
        String url=rb.getString("db.url");
        String username=rb.getString("db.username");
        String password=rb.getString("db.password");

        Connection conn = null;
        Properties prop = new Properties();
        prop.put("user", username);
        prop.put("password", password);
        prop.put("charSet", "UTF-8");
        prop.put("db.characterEncoding", "UTF-8");

        // Get database connection
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, prop);

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
        PrintStream sysout = null;
        try {
            sysout = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sysout.println(search("giang"));
    }

    public static JSONObject putJSONValue(JSONObject json, String key, Object value) throws JSONException {
        if (value == null) {
            value = JSONObject.NULL;
        }

        return json.put(key, value);
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
                //JSONObject json = new JSONObject().put("ID", id).put("TenThanh", tenThanh).put("Ho", ho).put("Ten", ten).put("NgaySinh", ngaySinh).put("LopCu", lopCu).put("LopMoi", lopMoi).put("TinhTrang", tinhTrang);
                JSONObject json = new JSONObject().put("ID", id);
                json = putJSONValue(json, "TenThanh", tenThanh);
                json = putJSONValue(json, "Ho", ho);
                json = putJSONValue(json, "Ten", ten);
                json = putJSONValue(json, "NgaySinh", ngaySinh);
                System.out.println("Ngaysinh: " + json.get("NgaySinh"));
                json = putJSONValue(json, "LopCu", lopCu);
                json = putJSONValue(json, "LopMoi", lopMoi);
                json = putJSONValue(json, "TinhTrang", tinhTrang);
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

    public static String search(String keyword, String[] fields, boolean removeAccent) {
        String jsonString = null;
        Connection conn = null;
        PreparedStatement ps = null;
        StringBuilder builder = new StringBuilder("select * from XepLop");
        if (removeAccent) {
            builder.append(" where 1=0");
            for (String field : fields) {
                builder.append(String.format(" or %s like \'%%%s%%\'", field, keyword));
            }
        } else {
            builder.append(" where 1=0 binary");
            for (String field : fields) {
                builder.append(String.format(" or upper(%s) like upper(\'%%%s%%\')", field, keyword));
            }
        }
        try {
            conn = DataConnection.connect();
            System.out.println(builder.toString());
            ps = conn.prepareStatement(builder.toString());
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
                JSONObject json = new JSONObject().put("ID", id);
                json = putJSONValue(json, "TenThanh", tenThanh);
                json = putJSONValue(json, "Ho", ho);
                json = putJSONValue(json, "Ten", ten);
                json = putJSONValue(json, "NgaySinh", ngaySinh);
                json = putJSONValue(json, "LopCu", lopCu);
                json = putJSONValue(json, "LopMoi", lopMoi);
                json = putJSONValue(json, "TinhTrang", tinhTrang);
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
