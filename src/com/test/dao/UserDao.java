package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.entity.AlamatUser;
import com.test.entity.User;
import com.test.util.DbUtil;

public class UserDao {
	private Connection connection;
	
	public UserDao() {
		connection = DbUtil.getConnection();
		// TODO Auto-generated constructor stub
	}
	
	public int add(User user) {
		int id = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("insert into tb_user(nama,no_hp,email) values (?,?,?)");

			ps.setString(1, user.getNama());
			ps.setString(2, user.getNoHp());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
			
			
			ResultSet tableKeys = ps.getGeneratedKeys();
			tableKeys.next();
			id = tableKeys.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return id;
	}
	
	public void tambahAlamat(AlamatUser alamatUser) {
		try {
			PreparedStatement ps = connection.prepareStatement("insert into tb_alamat(id_user,alamat) values (?,?)");

			ps.setInt(1, alamatUser.getIdUser());
			ps.setString(2, alamatUser.getAlamat());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}		
	}
	
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tb_user");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setNoHp(rs.getString("no_hp"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (Exception e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
		return users;
	}
	
	public List<User> searchUser(String nama) {
		List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tb_user where nama like '%"+nama+"%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setNoHp(rs.getString("no_hp"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (Exception e) {
        	e.printStackTrace();
			// TODO: handle exception
		}
		return users;
	}

}
