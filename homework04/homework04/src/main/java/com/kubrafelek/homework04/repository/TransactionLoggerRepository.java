package com.kubrafelek.homework04.repository;

import com.kubrafelek.homework04.model.TransactionLogger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLoggerRepository extends PagingAndSortingRepository<TransactionLogger, Long> {
}
