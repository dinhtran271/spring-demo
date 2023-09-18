package vn.vdef.learn.spring.clothes.Repository;

import vn.vdef.learn.spring.clothes.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("delete from User where userNo = :userNo")
    public void deleteByUserNo(Long userNo);

    @Query("SELECT u " +
            "from User u " +
            "WHERE u.role.roleNo = :roleNo")
    List<User> getUsersByRoleNo(Long roleNo);
}
