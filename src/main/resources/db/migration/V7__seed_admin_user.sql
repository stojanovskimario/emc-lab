insert into users (created_at, updated_at, name, surname, email, username, password, role)
select now(), now(), 'Admin', 'Admin', 'admin@emtlab.local', 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=', 'ROLE_ADMINISTRATOR'
where not exists (
    select 1 from users where username = 'admin'
);

