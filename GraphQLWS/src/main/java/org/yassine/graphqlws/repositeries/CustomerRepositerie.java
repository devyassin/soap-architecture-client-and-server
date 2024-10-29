package org.yassine.graphqlws.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yassine.graphqlws.entities.Customer;

public interface CustomerRepositerie extends JpaRepository<Customer, Long> {
}
