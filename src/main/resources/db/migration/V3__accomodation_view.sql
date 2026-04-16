create or replace view accomodation_view as
select
    a.id as id,
    a.name as name,
    a.category as category,
    a.num_rooms as num_rooms,
    h.name || ' ' || h.surname as host_full_name,
    c.name as country_name
from accomodations a
    join hosts h on h.id = a.host_id
    join countries c on c.id = h.country_id;

