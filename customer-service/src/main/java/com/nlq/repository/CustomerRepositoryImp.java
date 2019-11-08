package com.nlq.repository;

import com.nlq.model.Customer;
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
@Transactional
public class CustomerRepositoryImp implements CustomerRepository {
    @Autowired
    EntityManager em;

    @Override
    public List<Customer> findAll() {
        return null;
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
}
