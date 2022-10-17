package com.denmats.nplusone.repository;

import com.denmats.nplusone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByUserIdIsIn(List<Long> userIds);
}
