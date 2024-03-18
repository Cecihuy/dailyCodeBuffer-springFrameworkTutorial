package demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo")
public class BeanConfig {
    @Bean
    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }
}
