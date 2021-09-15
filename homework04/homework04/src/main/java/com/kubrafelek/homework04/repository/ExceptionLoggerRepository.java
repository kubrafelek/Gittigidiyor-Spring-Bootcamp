package com.kubrafelek.homework04.repository;

import com.kubrafelek.homework04.model.ExceptionsLogger;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExceptionLoggerRepository extends PagingAndSortingRepository<ExceptionsLogger, Long> {
}
