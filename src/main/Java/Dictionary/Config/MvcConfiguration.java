package Dictionary.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Java based configuration of spring mvc.
 * Subclasses WebMvcConfigurerAdapter and overrides callback methods.
 * @see WebMvcConfigurerAdapter
 */
@Configuration
@ComponentScan(basePackages="Dictionary")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

    /**
     * Configure mvc ViewResolver.
     */
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Configure access to the project's resources.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}