CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE passwords (
                           id SERIAL PRIMARY KEY,
                           user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                           password_hash VARCHAR(255) NOT NULL,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           expires_at TIMESTAMP,
                           active BOOLEAN DEFAULT TRUE
);

CREATE TABLE password_reset_tokens (
                                       id SERIAL PRIMARY KEY,
                                       reset_token UUID NOT NULL UNIQUE,
                                       user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                                       expires_at TIMESTAMP DEFAULT (CURRENT_TIMESTAMP + INTERVAL '2 hours'),
                                       used BOOLEAN DEFAULT FALSE NOT NULL
);

CREATE TABLE favourite_places (
                                  id SERIAL PRIMARY KEY,
                                  place_name VARCHAR(100) NOT NULL,
                                  latitude DECIMAL(9,6) NOT NULL,
                                  longitude DECIMAL(9,6) NOT NULL,
                                  CONSTRAINT unique_place UNIQUE (place_name, latitude, longitude)
);

CREATE TABLE user_favourite_places (
                                       id SERIAL PRIMARY KEY,
                                       user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                                       place_id INTEGER NOT NULL REFERENCES favourite_places(id) ON DELETE CASCADE,
                                       added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
