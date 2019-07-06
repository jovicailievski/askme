package com.askme.askme.repository.jpa;

import com.askme.askme.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAnswerRepository extends JpaRepository<Answer,Long> {
}
