package LoginTCP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionExample {
	
    public static void main(String[] args) {
        // Thông tin kết nối cơ sở dữ liệu
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP";
        String user = "sa";
		String pass = "phanvanhieu01102004";

        // Kết nối cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            // Tạo câu lệnh SQL
            String sql = "SELECT * FROM ACCOUNT";
            
            
            // chèn
            String sql1 = "insert into ACCOUNT values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
//            ps.setString(1, txtUsername.getText());
            

            // Thực hiện truy vấn
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            

            // Xử lý kết quả truy vấn
            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String password = resultSet.getString("PASS");
                System.out.println("USERNAME: " + username + "\nPASS: " + password+"\n");
            }

            // Đóng kết nối
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
