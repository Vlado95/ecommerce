package com.boutique.dao;

import java.util.List;

import com.boutique.admin.entity.User;

public interface IDaoUser {

	public User selectById(int id);

	public User findByEmailPdw(String email, String pdw);

	public List<User> selectAll();

	public List<User> searchLike(String str);

	public User insert(User objet);

	public void update(User objet);

	public void delete(int id);

}
