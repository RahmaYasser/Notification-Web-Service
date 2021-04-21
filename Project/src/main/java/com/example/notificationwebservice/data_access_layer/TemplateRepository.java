package com.example.notificationwebservice.data_access_layer;


import com.example.notificationwebservice.models.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class TemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Template> readAll(){
        return  jdbcTemplate.query("select * from template",new TemplateRowMapper());
    }

    public Template read(String templateType){

        String sql = "SELECT * FROM template WHERE template_type = ?";
        try{
            return  (Template) this.jdbcTemplate.queryForObject(
                    sql, new Object[] { templateType }, new TemplateRowMapper());
        }
        catch(EmptyResultDataAccessException ex){
            return null;
        }

    }

    public Boolean create(Template template ){
        String query="insert into template(template_type,subject,content) values(?,?,?)";
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setString(1,template.getTemplateType());
                ps.setString(2,template.getSubject());
                ps.setString(3,template.getContent());
                return ps.execute();
            }
        });
    }

    public Template update(String templateType,Template template){
        String query="update template set subject = ? , content = ?  where template_type = ?";
        Object[] params = {template.getSubject(), template.getContent(),templateType};
        int[] types = {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
        int res =  jdbcTemplate.update(query, params, types);
        template = read(templateType);
        return template;
    }

    public Template delete(String templateType){
        Template template = read(templateType);
        int res =  jdbcTemplate.update("delete from template where template_type = ?",templateType);
        return template;
    }

    private class TemplateRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Template template = new Template();
            template.setTemplateType(rs.getString("template_type"));
            template.setContent(rs.getString("content"));
            template.setSubject(rs.getString("subject"));
            return template;
        }
    }
}
