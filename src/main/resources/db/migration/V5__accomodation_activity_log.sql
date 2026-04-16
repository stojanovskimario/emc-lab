create table accomodation_activity_log (
    id bigserial primary key,
    accomodation_name varchar(150) not null,
    event_time timestamp not null,
    event_type varchar(50) not null
);

