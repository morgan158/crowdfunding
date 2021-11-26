package ru.pcs.crowdfunding.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.crowdfunding.client.domain.ProjectComment;

public interface ProjectCommentsRepository extends JpaRepository<ProjectComment, Long> {
}
