CREATE TABLE countries (
                         id BIGSERIAL PRIMARY KEY,
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP,
                         name VARCHAR(100) NOT NULL,
                         continent VARCHAR(100) NOT NULL
);

CREATE TABLE hosts (
                      id BIGSERIAL PRIMARY KEY,
                      created_at TIMESTAMP,
                      updated_at TIMESTAMP,
                      name VARCHAR(100) NOT NULL,
                      surname VARCHAR(100) NOT NULL,
                      country_id BIGINT NOT NULL,
                      CONSTRAINT fk_host_country
                          FOREIGN KEY (country_id)
                              REFERENCES countries(id)
);

CREATE TABLE accomodations (
                               id BIGSERIAL PRIMARY KEY,
                               created_at TIMESTAMP,
                               updated_at TIMESTAMP,
                               name VARCHAR(150) NOT NULL,
                               category VARCHAR(50) NOT NULL,
                               num_rooms INTEGER NOT NULL,
                               status VARCHAR(20) NOT NULL,
                               rented BOOLEAN NOT NULL,
                               host_id BIGINT NOT NULL,
                               CONSTRAINT fk_accommodation_host
                                   FOREIGN KEY (host_id)
                                       REFERENCES hosts(id)
);