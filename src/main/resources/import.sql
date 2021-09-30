INSERT INTO category (title) VALUES ('Admin');
INSERT INTO category (title) VALUES ('Projekte');
INSERT INTO category (title) VALUES ('IT-Support');

INSERT INTO entry (checkIn,checkOut, category_id) VALUES ('2021-09-30T07:16:14.807Z', '2021-10-30T07:16:14.807Z', 1);
INSERT INTO entry (checkIn,checkOut, category_id) VALUES ('2011-08-12T20:17:46.384Z', '2011-09-11T20:17:46.384Z', 2);
INSERT INTO entry (checkIn,checkOut, category_id) VALUES ('1989-03-30T07:16:14.807Z', '1989-04-30T07:16:14.807Z', 3);
INSERT INTO entry (checkIn,checkOut, category_id) VALUES ('2031-03-17T20:17:46.384Z', '2001-02-13T20:17:46.384Z', 2);

INSERT INTO absence (end, start) VALUES ('2021-09-30T07:16:14.807Z', '2021-10-30T07:16:14.807Z');
INSERT INTO absence (end, start) VALUES ('2011-08-12T20:17:46.384Z', '2011-09-11T20:17:46.384Z');
INSERT INTO absence (end, start) VALUES ('1989-03-30T07:16:14.807Z', '1989-04-30T07:16:14.807Z');
INSERT INTO absence (end, start) VALUES ('2031-03-17T20:17:46.384Z', '2001-02-13T20:17:46.384Z');

INSERT INTO expense (amount, receipt) VALUES (67.50, 'Vapiano-SihlCity');
INSERT INTO expense (amount, receipt) VALUES (69.25, 'ArenaCinemas-SihlCity');
INSERT INTO expense (amount, receipt) VALUES (23.00, 'BurgerKing-HauptBanhofZürich');
INSERT INTO expense (amount, receipt) VALUES (11.50, 'Coop-SihlCity');
INSERT INTO expense (amount, receipt) VALUES (356.90, 'GameStop-SihlCity');

