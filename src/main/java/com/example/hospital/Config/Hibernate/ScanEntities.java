package com.example.hospital.Config.Hibernate;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.List;

public class ScanEntities {

    public static List<Class> findAllEntities(List<Class> list) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        for (BeanDefinition bean : scanner.findCandidateComponents("com.example.hospital.Model")) {
            String name = bean.getBeanClassName();
            try {
                list.add(Class.forName(name));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
