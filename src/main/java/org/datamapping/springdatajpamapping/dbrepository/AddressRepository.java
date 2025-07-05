package org.datamapping.springdatajpamapping.dbrepository;

import org.datamapping.springdatajpamapping.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
