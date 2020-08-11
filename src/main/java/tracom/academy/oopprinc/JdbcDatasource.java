package tracom.academy.oopprinc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.FileInputStream;
import java.util.Properties;

public class JdbcDatasource {

    private static JdbcDatasource jdbcDatasource;

    private MysqlDataSource mysqlDataSource = new MysqlDataSource();

    private JdbcDatasource(){
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("/home/majoris/workspace/OopPrinciplies/src/main/resources/db_connection.properties"));

        }catch (Exception ex){
            ex.printStackTrace();

        }
        mysqlDataSource.setUrl(properties.getProperty("DB_URL"));
        mysqlDataSource.setUser(properties.getProperty("DB_USER"));
        mysqlDataSource.setPassword(properties.getProperty("DB_PWD"));

    }

    public static JdbcDatasource getInstance(){
        if (jdbcDatasource == null)
            jdbcDatasource = new JdbcDatasource();

        return jdbcDatasource;
    }

    public MysqlDataSource getMysqlDataSource() {
        return mysqlDataSource;
    }

    public void setMysqlDataSource(MysqlDataSource mysqlDataSource) {
        this.mysqlDataSource = mysqlDataSource;
    }
}
