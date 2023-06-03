package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.Customer_Authority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

public interface Customer_AuthorityMapper extends BaseMapper<Customer_Authority> {
    @Insert("insert into t_customer_authority(customer_id,authority_id)values(#{customer_id},#{authority_id})")
    public void setAuthority(Integer customer_id,Integer authority_id);
}
