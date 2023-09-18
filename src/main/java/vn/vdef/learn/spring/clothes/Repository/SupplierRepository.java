package vn.vdef.learn.spring.clothes.Repository;

import vn.vdef.learn.spring.clothes.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
