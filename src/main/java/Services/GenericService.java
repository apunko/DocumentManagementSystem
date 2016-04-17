package Services;

import HibernateDAO.Interfaces.IDao;

import java.util.ArrayList;

public class GenericService<TEntity> {
    protected IDao<TEntity> dao;
    private Class<TEntity> entityClass;

    public GenericService(IDao<TEntity> dao, Class<TEntity> entityClass) {
        this.entityClass = entityClass;
        this.dao = dao;
    }

    public GenericService() {}

    public TEntity getById(int id){
        dao.openCurrentSessionWithTransaction();
        TEntity entity = (TEntity) dao.findById(id);
        dao.closeCurrentSessionWithTransaction();
        return entity;
    }

    public void delete(TEntity entity){
        dao.openCurrentSessionWithTransaction();
        dao.delete(entity);
        dao.closeCurrentSessionWithTransaction();
    }

    public void update(TEntity entity){
        dao.openCurrentSessionWithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionWithTransaction();
    }

    public void create(TEntity entity){
        dao.openCurrentSessionWithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionWithTransaction();
    }

    public ArrayList<TEntity> getAll(){
        dao.openCurrentSessionWithTransaction();
        ArrayList<TEntity> entities = (ArrayList<TEntity>) dao.findAll();
        dao.closeCurrentSessionWithTransaction();
        return  entities;
    }



}
