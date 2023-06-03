package HelloSpringBoot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "t_customer_authority")
public class Customer_Authority {
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer customer_id;
    private Integer authority_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(Integer authority_id) {
        this.authority_id = authority_id;
    }

    @Override
    public String toString() {
        return "Customer_Authority{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", authority_id=" + authority_id +
                '}';
    }
}
