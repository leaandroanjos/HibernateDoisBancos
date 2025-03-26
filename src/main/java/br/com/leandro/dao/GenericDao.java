package br.com.leandro.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao<T> implements IGenericDao<T> {

    private static final String PERSISTENCE_UNIT_NAME = "Postgre1";
    protected EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;

    private Class<T> persistenteClass;

    protected String persistence_unit_name;

    @Override
    public T cadastrar(T entity) {
        openConnection();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        closeConnection();
        return entity;
    }

    @Override
    public void excluir(T entity) {
        openConnection();
        entity = entityManager.merge(entity);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        closeConnection();
    }

    private void closeConnection() {
        entityManager.close();
        entityManagerFactory.close();
    }

    private void openConnection(){
        entityManagerFactory = Persistence.createEntityManagerFactory(getPersistenceUnitName());
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    //Se não tiver definido, o padrão é o postgres1
    private String getPersistenceUnitName() {
        if(persistence_unit_name != null && !persistence_unit_name.equals("")){
            return persistence_unit_name;
        }
        return PERSISTENCE_UNIT_NAME;
    }

    public GenericDao(Class<T> clazz, String persistenceUnitName){
        this.persistenteClass = clazz;
        this.persistence_unit_name = persistenceUnitName;
    }
}
