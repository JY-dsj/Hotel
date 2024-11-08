package Dao;

import bean.SState;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeaderSearchDao {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/dormitory";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    // 查询语句
    private static final String SEARCH_BY_SID_QUERY = "SELECT * FROM s_state WHERE sid = ?";

    // 根据sid搜索数据项
    public List<SState> searchBySid(int sid) {
        List<SState> sStates = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_SID_QUERY)) {


            preparedStatement.setInt(1, sid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int floor = resultSet.getInt("floor");
                String features1 = resultSet.getString("features1");
                String features2 = resultSet.getString("features2");
                String state = resultSet.getString("state");

                SState sState = new SState(floor, sid, features1, features2, state);
                sStates.add(sState);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sStates;
    }
}