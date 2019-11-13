package com.nlq.repository;

import com.nlq.client.OrderClient;
import com.nlq.model.Customer;
import com.nlq.model.QCustomer;
import com.nlq.response.CustomerOrder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Repository
@Transactional(rollbackOn = Exception.class)
public class CustomerRepositoryImp implements CustomerRepository {
    @Autowired
    EntityManager em;

    @Autowired
    OrderClient orderClient;

    @Override
    public List<Customer> getAllCustomer() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        TypedQuery<Customer> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findCustomerById(long id) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Customer> criteriaQuery = cb.createQuery(Customer.class);

            Root<Customer> root = criteriaQuery.from(Customer.class);
            criteriaQuery.select(root).where(cb.equal(root.get("id"), id));

            TypedQuery<Customer> query = em.createQuery(criteriaQuery);

            return query.getSingleResult();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long createCustomer(Customer customer) {
        try {
            em.persist(customer);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public CustomerOrder listCustomerOrderByCustomerId(long id){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QCustomer qCustomer = QCustomer.customer;
        Customer customer = queryFactory.selectFrom(qCustomer)
                .where(qCustomer.id.eq(id))
                .fetchOne();
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        customerOrder.setOrders(orderClient.getOrderById(id));
        return customerOrder;
    }
}
