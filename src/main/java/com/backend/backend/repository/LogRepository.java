package com.backend.backend.repository;

import java.io.Serializable;

import com.backend.backend.entity.Log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LogRepository
 */
@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {


}