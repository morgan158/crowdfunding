package ru.pcs.crowdfunding.client.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pcs.crowdfunding.client.domain.Project;
import ru.pcs.crowdfunding.client.domain.ProjectStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {

    Optional<Project> getProjectById (Long id);
    Optional<Project> getProjectByAccountId(Long id);

    Page<Project> findAllByAuthorId(Long authorId, Pageable pageable);
    Page<Project> findProjectsByStatusEquals(ProjectStatus projectStatus, Pageable pageable);
    Page<Project> findProjectsByDescriptionContains(String description, Pageable pageable);
    Page<Project> findProjectsByTitleContains(String title, Pageable pageable);

    Page<Project> findProjectsByFinishDateBetween(Instant finishDateOne, Instant finishDateTwo, Pageable pageable);
    Page<Project> findProjectsByFinishDateBefore(Instant finishDate, Pageable pageable);
    Page<Project> findProjectsByFinishDateAfter(Instant finishDate, Pageable pageable);
    Page<Project> findProjectsByCreatedAtBetween(Instant createdDateOne, Instant createsDateTwo, Pageable pageable);
    Page<Project> findProjectsByCreatedAtBefore(Instant createdDate, Pageable pageable);
    Page<Project> findProjectsByCreatedAtAfter(Instant createdDate, Pageable pageable);

    Page<Project> findProjectsByMoneyGoalBetween(BigDecimal moneyGoalMin, BigDecimal moneyGoalMax, Pageable pageable);
    Page<Project> findProjectsByMoneyGoalGreaterThan(BigDecimal moneyGoalMin, Pageable pageable);
    Page<Project> findProjectsByMoneyGoalLessThan(BigDecimal moneyGoalMax, Pageable pageable);
}
