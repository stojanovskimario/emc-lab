create materialized view accomodation_category_summary_view as
select
    category,
    count(*)::bigint as total_accommodations,
    coalesce(sum(num_rooms), 0)::bigint as total_rooms,
    coalesce(avg(num_rooms), 0)::numeric(19,2) as average_rooms_per_accommodation
from accomodations
group by category;

create unique index idx_accomodation_category_summary_view_category
    on accomodation_category_summary_view(category);


