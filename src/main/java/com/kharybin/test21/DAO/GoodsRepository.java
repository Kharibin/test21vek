package com.kharybin.test21.DAO;

import com.kharybin.test21.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
