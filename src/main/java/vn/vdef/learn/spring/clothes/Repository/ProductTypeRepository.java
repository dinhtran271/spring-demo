package vn.vdef.learn.spring.clothes.Repository;

import vn.vdef.learn.spring.clothes.Entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

        @Query("Select pt from ProductType pt where pt.productTypeNo = :id")
        ProductType getProductType(int id);

        @Modifying
        @Query("delete from ProductType where productTypeNo = :id")
        public void deleteProductTypeById(Long id);
}
