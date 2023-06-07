import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnectionPool {
    private static BasicDataSource dataSource = null;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/OnlineBookstoreSystem");
        dataSource.setUsername("root");
        dataSource.setPassword("solvdadmin");
        dataSource.setInitialSize(5); // Set the initial connection pool size
    }
    public static BasicDataSource getDataSource() {
        return dataSource;
    }
}
