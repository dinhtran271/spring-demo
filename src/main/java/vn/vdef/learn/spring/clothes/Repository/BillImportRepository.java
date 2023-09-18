package vn.vdef.learn.spring.clothes.Repository;

import vn.vdef.learn.spring.clothes.Entity.BillImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillImportRepository extends JpaRepository<BillImport, Long> {
}
