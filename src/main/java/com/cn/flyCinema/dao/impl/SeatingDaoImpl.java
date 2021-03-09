package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.SeatingDao;
import com.cn.flyCinema.entity.Seating;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SeatingDaoImpl implements SeatingDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Seating> findSeatingBySid(Integer sid) {
        String sql = "select * from table_seating where sid = ? and selected = 'Y'";
        List<Seating> seatings = jt.query(sql, new BeanPropertyRowMapper<>(Seating.class), sid);
        return seatings.isEmpty()?null:seatings;
    }
}
