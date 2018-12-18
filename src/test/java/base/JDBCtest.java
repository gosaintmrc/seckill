package base;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Authgor: gosaint
 * @Description:
 * @Date Created in 18:47 2018/11/24
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class JDBCtest  {

    @Autowired
    private DruidDataSource dataSource;
    @Test
    public void testcom() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
