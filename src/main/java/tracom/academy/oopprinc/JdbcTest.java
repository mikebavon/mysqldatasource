package tracom.academy.oopprinc;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

    public static void main(String args []){

        try {
            MysqlDataSource dataSource = JdbcDatasource.getInstance().getMysqlDataSource();

            /*InitialContext ictx = new InitialContext();
            DataSource dataSource = (DataSource) ictx.lookup("java:jboss/datasources/DbDatasource/");*/

            Connection connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement("select * from students");
            statement.execute();

            ResultSet result = statement.getResultSet();

            while (result.next()){
                System.out.println(result.getString("name"));
            }




        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
