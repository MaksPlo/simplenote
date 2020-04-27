package com.spring.simplenote;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlContainer extends PostgreSQLContainer<PostgresqlContainer> {
    private static final String IMAGE_VERSION = "postgres:10.4";
    private static final String DB_NAME = "testdb";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "testpw";
    private static final PostgresqlContainer POSTGRESQL_CONTAINER = new PostgresqlContainer()
            .withDatabaseName(DB_NAME)
            .withUsername(USERNAME)
            .withPassword(PASSWORD);

    private PostgresqlContainer() {
        super(IMAGE_VERSION);
    }

    public static PostgresqlContainer getInstance() {
        return POSTGRESQL_CONTAINER;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", POSTGRESQL_CONTAINER.getJdbcUrl());
        System.setProperty("DB_USERNAME", POSTGRESQL_CONTAINER.getUsername());
        System.setProperty("DB_PASSWORD", POSTGRESQL_CONTAINER.getPassword());
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
