package core.di.factory.scanner;

import core.annotation.Bean;
import core.di.factory.BeanFactory;
import next.config.MyConfiguration;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotatedBeanDefinitionReader {

    private BeanFactory beanFactory;

    public AnnotatedBeanDefinitionReader(BeanFactory beanFactory, Object... basePackage) {
        this.beanFactory = beanFactory;
    }

    public void registerBean() throws InstantiationException, IllegalAccessException {
        Set<Method> beans = getBeans(MyConfiguration.class);

        for (Method method : beans) {
                Class<?> clazz = method.getReturnType();
                beanFactory.initializeBean(MyConfiguration.class, method);
        }
    }

    public Set<Method> getBeans(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(Bean.class))
                .collect(Collectors.toSet());
    }

}
