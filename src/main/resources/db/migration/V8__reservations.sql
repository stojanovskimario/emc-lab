create table reservations (
    id bigserial primary key,
    created_at timestamp not null,
    updated_at timestamp not null,
    user_id bigint not null unique,
    accomodation_id bigint not null unique,
    reserved_at timestamp not null,
    release_at timestamp not null,
    constraint fk_reservations_user foreign key (user_id) references users(id),
    constraint fk_reservations_accomodation foreign key (accomodation_id) references accomodations(id)
);

