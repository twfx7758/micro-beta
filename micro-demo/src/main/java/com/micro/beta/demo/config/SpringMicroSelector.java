/*
 * @(#)SpringMicroSelector.java      2019/8/5
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.beta.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 功能：ImportSelector
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class SpringMicroSelector implements ImportSelector, BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        annotationMetadata.getAnnotationTypes().forEach(System.out::println);

        System.out.println(beanFactory);

        return new String[0];
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
