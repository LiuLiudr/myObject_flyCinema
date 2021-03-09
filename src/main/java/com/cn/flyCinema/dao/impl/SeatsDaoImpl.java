package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.SeatsDao;
import com.cn.flyCinema.entity.Seating;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class  SeatsDaoImpl implements SeatsDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Seating> getAllSeats(Integer sid) {
        String sql = "select * from table_seating where sid = ?";

        List<Seating> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Seating.class), sid);

        return list;
    }

    @Override
    public void addIndent(Integer uid, Integer sid, String[] choosingList) {
        String sql = "insert into table_indent values (null, ?, ?, ?)";

        for (int i = 0; i < choosingList.length; i++) {
            jdbcTemplate.update(sql, uid, sid, (Integer.parseInt(choosingList[i]) + 1));
        }

    }

    @Override
    public void ySeat(Integer sid, String[] choosingList) {
        String sql = "update table_seating set selected = ? where sid = ? and coord = ?";

        for (int i = 0; i < choosingList.length; i++) {
            jdbcTemplate.update(sql, "Y", sid, (Integer.parseInt(choosingList[i]) + 1));
        }
    }

    @Override
    public int findYCount(int sid) {
        String sql = "select count(*) from table_seating where sid = ? and selected = 'Y'";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, sid);
        return count;
    }
}
