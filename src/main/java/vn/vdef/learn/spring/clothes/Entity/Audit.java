package vn.vdef.learn.spring.clothes.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit implements Serializable {
    private static final long serialVersionUID = -3869225360246516120L;

    @CreatedBy
    @Column(name = "created_by", length = 100, nullable = false)
    private String createdBy;

    @CreatedDate
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @LastModifiedBy
    @Column(name = "modified_by", length = 100, nullable = false)
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "modified_on", nullable = false)
    private LocalDateTime modifiedOn;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public boolean isActive() {
        return !isDeleted;
    }
}
