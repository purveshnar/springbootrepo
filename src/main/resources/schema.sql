create table user (
    id NVARCHAR(40) PRIMARY KEY,
    full_name NVARCHAR (100) NOT NULL,
    email NVARCHAR(40) NOT NULL,
    password NVARCHAR(20) NOT NULL
);