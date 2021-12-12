package question2.manager;

import question2.dao.BaseDao;
import question2.entity.BaseEntity;

import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public class BaseManager<T extends BaseEntity<ID> , ID extends Number> {

    private BaseDao baseDao  ;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public BaseDao getBaseDao() {
        return baseDao;
    }

    public void save(T entity){
        baseDao.save(entity);
    }

    public T loadById(ID id) {
        return (T) baseDao.loadById(id);
    }

    public List<T> loadAll() {
        return baseDao.loadAll();
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void delete(T entity) {
        baseDao.delete(entity);
    }

}
