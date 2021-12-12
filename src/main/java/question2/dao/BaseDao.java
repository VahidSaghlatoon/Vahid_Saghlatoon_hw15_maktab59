package question2.dao;

import question2.entity.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public abstract class BaseDao<T extends BaseEntity<ID>, ID extends Number> {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("jpa-bank-management");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public abstract Class<T> getEntityClass();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T loadById( ID id) {
        entityManager.getTransaction().begin();
        T entity = entityManager.find(getEntityClass(),id);
        entityManager.getTransaction().commit();
        return entity;
    }
    public List<T> loadAll() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(" FROM " + getEntityClass().getSimpleName());
        entityManager.getTransaction().commit();
        return  query.getResultList();

    }

    public void update(T entity){
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }


}
