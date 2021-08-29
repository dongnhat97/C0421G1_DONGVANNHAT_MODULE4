package com.model.repository;

import com.model.bean.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> finAll() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery("select p from Product as p", Product.class);

        return typedQuery.getResultList();
    }

    @Override
    public void Save(Product product) {

//        Transaction transaction = null;
//        Session session = null;
//        try {
//            session = BaseRepository.sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(product);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }finally {
//            if (session!=null) {
//                session.close();
//            }
//        }
        try {
             BaseRepository.entityManager.getTransaction().begin();
             if (product.getId()!=null) {
                 BaseRepository.entityManager.merge(product);
             }else {
                 BaseRepository.entityManager.persist(product);
             }
             BaseRepository.entityManager.getTransaction().commit();
        }catch (PersistenceException p) {
            p.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {

        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class, id);
        BaseRepository.entityManager.remove(product);
        transaction.commit();
    }

    @Override
    public Product findByID(int id) {
        return BaseRepository.entityManager.find(Product.class, id);

    }

    @Override
    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>(BaseRepository.entityManager.createQuery(
                "select p " +
                        "from Product p", Product.class).getResultList());
        List<Product> arrayList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                arrayList.add(product);
            }
        }
        return arrayList;

    }
}
