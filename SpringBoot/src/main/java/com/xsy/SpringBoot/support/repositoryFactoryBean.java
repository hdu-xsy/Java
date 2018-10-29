package com.xsy.SpringBoot.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class repositoryFactoryBean<T extends JpaRepository<S,ID>,S,ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID>  {

    @Override
    protected RepositoryFactoryBeanSupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomRepositoryFactory(entityManager);
    }


    private static class CustomRepositoryFactory extends JpaRepositoryFactory {


        public CustomRepositoryFactory(EntityManager entityManager) {
            super(entityManager);
        }


        @Override
        @SuppressWarnings(("unchecked"))
        protected <T,ID extends Serializable> SimpleJpaRepository<?,?> getTargetRepository(RepositoryInformation information,EntityManager entityManager) {
            return new CustomRepositoryImpl<T,ID>((Class<T>)information.getDomainType(),entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return CustomRepositoryImpl.class;
        }
    }
}
