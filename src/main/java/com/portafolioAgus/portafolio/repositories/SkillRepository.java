package com.portafolioAgus.portafolio.repositories;


import com.portafolioAgus.portafolio.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Long> {
}
