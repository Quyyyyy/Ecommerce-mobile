package org.example.webdt.repositories;

import org.example.webdt.dto.SaleData;
import org.example.webdt.entities.OrderEntity;
import org.example.webdt.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
    @Query(value="SELECT COUNT(*) AS TONG FROM orders  WHERE MONTH(created) = MONTH(CURRENT_DATE()) AND YEAR(created) = YEAR(CURRENT_DATE()) GROUP BY MONTH(CURRENT_DATE()) ORDER BY MONTH(CURRENT_DATE())",nativeQuery = true)
    Long getTotalOrderByMonth();
    @Query(value = "SELECT COUNT(*) AS TONGSO FROM orders WHERE order_status = 'mới'",nativeQuery = true)
    Long getTotalOrderNews();
    @Query(value = "SELECT SUM(total) AS TongDoanhThu FROM orders WHERE order_status='Đã nhận hàng' AND MONTH(created) = MONTH(CURRENT_DATE()) AND YEAR(created) = YEAR(CURRENT_DATE())", nativeQuery = true)
    Long getTotalRevenueForCurrentMonth();

    @Query(value = "SELECT COUNT(*) AS TONG, DATE(created) AS NGAY " +
            "FROM orders " +
            "WHERE order_status = 'Đã nhận hàng' AND MONTH(created) = MONTH(CURRENT_DATE()) AND YEAR(created) = YEAR(CURRENT_DATE()) " +
            "GROUP BY NGAY", nativeQuery = true)
    List<SaleData> getByMonth();

    @Query(value = "SELECT * FROM orders WHERE order_status =:status ORDER BY (CASE WHEN order_status = 'mới' THEN 0 ELSE 1 END), updated DESC",nativeQuery = true)
    Page<OrderEntity> findAllByStatus(@Param("status") String status, Pageable pageable);
    Page<OrderEntity> findByUser(UserEntity user,Pageable pageable);

    @Query(value = "SELECT * FROM orders WHERE user_id =:id and order_status =:status",nativeQuery = true)
    Page<OrderEntity> findByUserAndOrder_status(@Param("id") Long userId,@Param("status") String status, Pageable pageable);
}

