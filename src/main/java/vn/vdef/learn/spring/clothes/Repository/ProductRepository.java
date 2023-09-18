package vn.vdef.learn.spring.clothes.Repository;

import vn.vdef.learn.spring.clothes.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("delete from Product where productNo = :id")
    public void deleteProductById(Long id);

    @Modifying
    @Query("delete from Product where productType.productTypeNo = :id")
    public void deleteProductsById(Long id);
}
