INSERT INTO countries(id,created_at,updated_at,name,continent)
VALUES
    (1,now(),now(),'Germany','Europe'),
    (2,now(),now(),'Italy','Europe'),
    (3,now(),now(),'USA','North America');

INSERT INTO hosts(id,created_at,updated_at,name,surname,country_id)
VALUES
    (1,now(),now(),'John','Doe',1),
    (2,now(),now(),'Mario','Rossi',2),
    (3,now(),now(),'Mark','Smith',3);

INSERT INTO accomodations(id,created_at,updated_at,name,category,num_rooms,status,rented,host_id)
VALUES
    (1,now(),now(),'City Apartment','APARTMENT',3,'GOOD',false,1),
    (2,now(),now(),'Sea House','HOUSE',5,'BAD',false,2),
    (3,now(),now(),'Budget Motel','MOTEL',10,'GOOD',false,3);

SELECT setval('countries_id_seq', (SELECT MAX(id) FROM countries) + 1);
SELECT setval('hosts_id_seq', (SELECT MAX(id) FROM hosts) + 1);
SELECT setval('accomodations_id_seq', (SELECT MAX(id) FROM accomodations) + 1);

