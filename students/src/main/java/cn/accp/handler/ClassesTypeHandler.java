package cn.accp.handler;

import cn.accp.domain.Classes;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedJdbcTypes(JdbcType.INTEGER)
public class ClassesTypeHandler extends BaseTypeHandler<Classes> {

        @Override
        public void setNonNullParameter(PreparedStatement preparedStatement, int i, Classes classes, JdbcType jdbcType) throws SQLException {
            preparedStatement.setInt(i, classes.getId());
        }

        @Override
        public Classes getNullableResult(ResultSet resultSet, String s) throws SQLException {
            Classes classes = new Classes();
            classes.setId(resultSet.getInt(s));
            classes.setName(resultSet.getString("name"));
            return classes;
        }

        @Override
        public Classes getNullableResult(ResultSet resultSet, int i) throws SQLException {
            Classes classes = new Classes();
            classes.setId(resultSet.getInt(i));
            return classes;
        }

        @Override
        public Classes getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
            return null;
        }
    }


