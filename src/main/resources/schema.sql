CREATE TABLE if not exists Registration (
                                            id serial PRIMARY KEY,
                                            firstname VARCHAR ( 50 ) UNIQUE NOT NULL,
    lastname VARCHAR ( 50 ) NOT null,
    phone VARCHAR ( 50 ) NOT null,
    email VARCHAR ( 50 ) NOT null,
    city VARCHAR ( 50 ) NOT null,
    state VARCHAR ( 50 ) NOT null,
    zipcode VARCHAR ( 50 ) NOT null

    );

CREATE TABLE if not exists Login (
                                     id int PRIMARY KEY,
                                     username VARCHAR ( 50 ) UNIQUE NOT NULL,
    password VARCHAR ( 50 ) NOT null


    );