package br.com.leandro.dao;

public interface IGenericDao<T> {

    T cadastrar(T entity);

    public void excluir(T entity);

}
