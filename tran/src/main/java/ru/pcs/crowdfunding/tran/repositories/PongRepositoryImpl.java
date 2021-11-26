package ru.pcs.crowdfunding.tran.repositories;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PongRepositoryImpl implements PongRepository {
    //language=SQL
    private final static String SQL_SELECT_PONG = "SELECT 'Pong from TransactionService!';";

    private final JdbcTemplate jdbcTemplate;

    @Override
    public String getPong() {
        log.info("Query: SELECT 'Pong from TransactionService!'");
        return jdbcTemplate.queryForObject(SQL_SELECT_PONG, String.class);
    }
}
