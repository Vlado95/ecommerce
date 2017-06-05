package fr.eboutique.dao;

import java.util.List;

public interface IDao<T> {

	public T selectById(int id);

	public List<T> selectAll();

	public List<T> searchLike(String str);

	public T insert(T objet);

	public void update(T objet);

	public void delete(int id);

}
