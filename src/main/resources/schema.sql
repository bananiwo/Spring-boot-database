DROP TABLE IF EXISTS reservation;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS renter;
DROP TABLE IF EXISTS item_leased;

CREATE TABLE tenant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE renter (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE item_leased (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    unit_cost DOUBLE NOT NULL,
    area DOUBLE NOT NULL,
    description VARCHAR (2000)
);

CREATE TABLE reservation (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     renter_id BIGINT FOREIGN KEY REFERENCES renter(id),
--     tenant_id BIGINT FOREIGN KEY REFERENCES tenant(id),
--     item_leased_id BIGINT FOREIGN KEY REFERENCES item_leased(id),
    cost DOUBLE NOT NULL
--     lease_start DATE NOT NULL
--     lease_end DATE NOT NULL
);
