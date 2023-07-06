package store.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import store.myApp.MyApp;
import store.validators.customerValidator.changePassword.IChangePasswordValidator;
import store.validators.customerValidator.changePassword.ValidateCustomerPassword;
import store.validators.customerValidator.common.*;
import store.validators.customerValidator.create.*;
import store.validators.customerValidator.update.*;
import store.validators.productValidator.changeQuantity.ChangeProductQuantity;
import store.validators.productValidator.changeQuantity.IChangeProductQuantity;
import store.validators.productValidator.common.ValidateProductName;
import store.validators.productValidator.common.ValidateProductPrice;
import store.validators.productValidator.common.ValidateProductQuantity;
import store.validators.productValidator.create.ICreateProductValidator;
import store.validators.productValidator.update.IUpdateProductValidator;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "store")
public class BeanConfiguration {
    @Bean
    public MyApp myApp(){
        return new MyApp();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public List<ICreateCustomerValidator> createValidator(){
        List<ICreateCustomerValidator> bean = new ArrayList<>();
        bean.add(new ValidateCustomerName());
        bean.add(new ValidateCustomerAge());
        bean.add(new ValidateCustomerAddress());
        bean.add(new ValidateCustomerPhone());
        bean.add(new ValidateCustomerEmail());
        bean.add(new ValidateCreateCustomerPassword());
        return bean;
    }

    @Bean
    public List<IUpdateCustomerValidator> updateValidator(){
        List<IUpdateCustomerValidator> bean = new ArrayList<>();
        bean.add(new ValidateUpdateCustomerId());
        bean.add(new ValidateCustomerName());
        bean.add(new ValidateCustomerAge());
        bean.add(new ValidateCustomerAddress());
        bean.add(new ValidateCustomerPhone());
        bean.add(new ValidateCustomerEmail());
        return bean;
    }

    @Bean
    public IChangePasswordValidator changePasswordValidator(){
        IChangePasswordValidator bean = new ValidateCustomerPassword();
        return bean;
    }

    @Bean
    public List<ICreateProductValidator> createProductValidators(){
        List<ICreateProductValidator> bean = new ArrayList<>();
        bean.add(new ValidateProductName());
        bean.add(new ValidateProductPrice());
        bean.add(new ValidateProductQuantity());
        return bean;
    }

    @Bean
    public List<IUpdateProductValidator> updateProductValidators(){
        List<IUpdateProductValidator> bean = new ArrayList<>();
        bean.add(new ValidateProductName());
        bean.add(new ValidateProductPrice());
        bean.add(new ValidateProductQuantity());
        return bean;
    }

    @Bean
    public IChangeProductQuantity changeProductQuantity(){
        return new ChangeProductQuantity();
    }
}
