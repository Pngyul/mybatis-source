package com.klayzz.mybatissource.jdbc;

import com.klayzz.mybatissource.medel.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class JdbcTest {

    @Test
    public void testJdbc() {
        String url = "jdbc:mysql://47.107.86.45:3306/mybatis_source?user=root&password=root&useUnicode=true&characterEncoding=UTF8&useSSL=false";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url);

            String author = "As";
            String date = "2020-06-23 09:18:11";
            String sql = "SELECT id, title, author, content, create_time FROM article WHERE author = '" + author+"'";

            Statement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs.getRow());
            List<Article> articles = new ArrayList<>(rs.getRow());
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setAuthor(rs.getString("author"));
                article.setContent(rs.getString("content"));
                article.setCreateTime(rs.getDate("create_time"));
                articles.add(article);
            }
            System.out.println("Query SQL ==> " + sql);
            System.out.println("Query Result: ");
            articles.forEach(System.out::println);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
