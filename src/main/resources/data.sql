insert into author (id, name) values (default, 'Josh'), (default, 'James'), (default, 'Matt'), (default, 'John');

insert into book (id, title, publisher, author_id)
values (default, 'Alice in wonderland', 'R Publishers', 1),
       (default, 'Tale of Two cities', 'Z publishers', 1),
       (default, 'Murder in oriental express', 'Matt publishing house', 2);