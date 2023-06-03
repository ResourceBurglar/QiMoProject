package HelloSpringBoot.Mapper;

import HelloSpringBoot.domain.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;



public interface CustomerMapper extends BaseMapper<Customer> {
    @Insert("insert into t_customer (username,password)values(#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void insertAccount(Customer customer);



}
