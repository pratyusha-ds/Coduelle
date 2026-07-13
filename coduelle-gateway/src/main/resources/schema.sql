-- Basic schema for Coduelle gateway

CREATE TABLE IF NOT EXISTS users (
  id BIGSERIAL PRIMARY KEY,
  username TEXT NOT NULL,
  display_name TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);

CREATE TABLE IF NOT EXISTS problems (
  id BIGSERIAL PRIMARY KEY,
  title TEXT NOT NULL,
  description_markdown TEXT,
  time_limit_ms INTEGER,
  memory_limit_mb INTEGER
);

CREATE TABLE IF NOT EXISTS submissions (
  id BIGSERIAL PRIMARY KEY,
  match_id BIGINT,
  user_id BIGINT REFERENCES users(id),
  source_code TEXT,
  status_verdict TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now()
);
