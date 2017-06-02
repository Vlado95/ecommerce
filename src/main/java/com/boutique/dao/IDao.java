package com.boutique.dao;

import java.util.List;

import com.boutique.entity.Produit;

public interface IDao<T extends Produit> {

	public T selectById(int id);

	public List<T> selectAll();

	public List<T> searchLike(String str);

	public T insert(T objet);

	public void update(T objet);

	public void delete(int id);

}
