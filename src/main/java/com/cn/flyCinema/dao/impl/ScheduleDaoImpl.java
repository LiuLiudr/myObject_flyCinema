package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.ScheduleDao;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Schedule;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Schedule findScheduleBySid(Integer sid) {
        String sql = "select * from table_schedule where sid = ?";

        List<Schedule> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), sid);

        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public Schedule findScheduleDaoBySid(Integer sid) {
        String sql = "select * from table_schedule where sid = ?";
        List<Schedule> schedules = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), sid);
        return schedules.isEmpty()?null:schedules.get(0);
    }

    @Override
    public List<Schedule> findScheduleCid(int cid,int mid) {
        String sql = "select * from table_schedule where cid = ? and mid = ?";
        List<Schedule> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), cid,mid);
        return query.size()==0 ? null :query;
    }

    @Override
    public List<Schedule> findScheduleByCidDateMid(int cid, int mid, String dateget) {
        String sql = "select * from table_schedule where cid = ?  and mid = ? and date = ? ";
        List<Schedule> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), cid, mid, dateget);
        return query.size() == 0 ? null :query;
    }

    @Override
    public Cinema findCinemaByCid(int cid) {
        String sql = "select * from table_cinema where cid = ?  ";
        List<Cinema> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cinema.class), cid);
        return query.size() ==0 ? null :query.get(0);
    }

    @Override
    public List<Schedule> findScheduleByCidMid(int cid, int mid) {
        String sql = "select distinct date from table_schedule where cid = ?  and mid = ?  ";
        List<Schedule> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class), cid, mid);
        return query.size() == 0 ? null :query;
    }
}
