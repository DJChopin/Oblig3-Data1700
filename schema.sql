CREATE TABLE Ticket
(
    id INTEGER AUTO_INCREMENT NOT NULL,
    ticketAmount VARCHAR(255) NOT NULL,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    film VARCHAR(255) NOT NULL ,
    PRIMARY KEY (id)
);

CREATE TABLE Movie
(
    film VARCHAR(255) NOT NULL,
    PRIMARY KEY (film)
);