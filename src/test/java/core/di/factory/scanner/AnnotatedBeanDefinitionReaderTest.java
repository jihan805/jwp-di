package core.di.factory.scanner;

import core.di.factory.BeanFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

class AnnotatedBeanDefinitionReaderTest {

    @Test
    void name() throws IllegalAccessException, InstantiationException {
        BeanFactory beanFactory = new BeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory, "next.controller");
        reader.registerBean();
        System.out.println(beanFactory.getBean(DataSource.class) != null);
    }
}