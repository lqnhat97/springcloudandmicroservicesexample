package com.nlq.repository;

import com.nlq.client.CustomerClient;
import com.nlq.model.Customer;
import com.nlq.model.Order;
import com.nlq.model.QOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class OrderRepositoryImp implements OrderRepository{
    @Autowired
    EntityManager em;


    @Autowired
    CustomerClient customerClient;

    public long createOrder(Order order) {
        try{
            em.persist(order);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public Order findOrderById(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = cb.createQuery(Order.class);
        Root<Order> root = criteriaQuery.from(Order.class);
        criteriaQuery.select(root).where(cb.equal(root.get("orderId"),id));
        TypedQuery<Order> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getSingleResult();
    }

    @Override
    public List<Order> findOrderByCustomerId(long id) {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QOrder qOrder = QOrder.order;
        List<Order> order = query.selectFrom(qOrder)
                .where(qOrder.customerId.eq(id))
                .fetch();
        return order;
    }

    public Order updateOrderById(long id) {
        return null;
    }

    public long deleteOrderById(long id) {
        try {
            Session session = em.unwrap(Session.class);
            Order order = session.get(Order.class, id);
            session.delete(order);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerClient.getAllCustomer();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);
//        Root<Customer> root = criteriaQuery.from(Customer.class);
//        criteriaQuery.select(root);
//        TypedQuery<Customer> typedQuery = em.createQuery(criteriaQuery);
//        return typedQuery.getResultList();
    }
}
