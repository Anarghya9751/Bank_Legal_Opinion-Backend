
package com.example.reportapi.repository;

import com.example.reportapi.model.ReportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportDetailRepository extends JpaRepository<ReportDetail, Long> {
	
	
}

