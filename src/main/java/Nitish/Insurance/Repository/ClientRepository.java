package Nitish.Insurance.Repository;

import Nitish.Insurance.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {
    // @Query(value = select * from client where clientId)
}
