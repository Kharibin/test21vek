package com.kharybin.test21.DAO;

import com.kharybin.test21.model.Goods;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
@Primary
public interface GoodsRepository extends GeneralRepository<Goods> {

}
