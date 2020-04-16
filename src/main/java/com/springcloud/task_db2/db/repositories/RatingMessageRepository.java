package com.springcloud.task_db2.db.repositories;

import com.springcloud.task_db2.db.entities.RatingMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingMessageRepository extends JpaRepository<RatingMessage, Long> {
}