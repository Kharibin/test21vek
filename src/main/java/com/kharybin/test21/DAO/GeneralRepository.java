package com.kharybin.test21.DAO;

import com.kharybin.test21.model.BaseClass;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

@Component
@NoRepositoryBean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface GeneralRepository<T> extends JpaRepository<T, Long> {

}

