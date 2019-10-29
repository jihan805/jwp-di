package core;

import core.di.factory.BeanFactory;
import core.di.factory.scanner.ClassPathBeanScanner;
import core.di.factory.scanner.AnnotatedBeanDefinitionReader;
import next.config.MyConfiguration;

public class ApplicationContext {

    private BeanFactory beanFactory;

    public ApplicationContext() {
        this.beanFactory = new BeanFactory();
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory, "next.controller");
        //AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory, "next.controller");
        ClassPathBeanScanner classPathBeanScanner = new ClassPathBeanScanner(beanFactory, "next.controller");
    }

    public <T> T getBean(Class<T> requiredType) {
        return (T) beanFactory.getBean(requiredType);
    }
}
