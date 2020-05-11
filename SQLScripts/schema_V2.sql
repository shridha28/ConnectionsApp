DROP TABLE city;

DROP TABLE states;

ALTER TABLE customers DROP COLUMN city, DROP COLUMN state,DROP COLUMN street,
DROP COLUMN house_Number,DROP COLUMN land_Mark; 


SET GLOBAL max_allowed_packet=1073741824;
