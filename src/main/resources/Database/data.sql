INSERT INTO users (first_name, last_name, dob, email, password, profile_photo, description)
VALUES
    ('John', 'Doe', '1990-05-15', 'john.doe@example.com', 'password123', '{"url": "https://example.com/photo1.jpg"}', 'Some description 1'),
    ('Alice', 'Smith', '1985-09-20', 'alice.smith@example.com', 'p@ssw0rd', '{"url": "https://example.com/photo2.jpg"}', 'Some description 2'),
    ('Bob', 'Johnson', '1992-03-10', 'bob.johnson@example.com', 'securepassword', '{"url": "https://example.com/photo3.jpg"}', 'Some description 3'),
    ('Bob', 'Brown', '1993-04-04', 'bob.brown@example.com', 'passwordabc', '{"url": "https://example.com/photo4.jpg"}', 'Description 4'),
    ('Eva', 'Williams', '1994-05-05', 'eva.williams@example.com', 'passworddef', '{"url": "https://example.com/photo5.jpg"}', 'Description 5'),
    ('Michael', 'Jones', '1995-06-06', 'michael.jones@example.com', 'passwordghi', '{"url": "https://example.com/photo6.jpg"}', 'Description 6'),
    ('Sophia', 'Davis', '1996-07-07', 'sophia.davis@example.com', 'passwordjkl', '{"url": "https://example.com/photo7.jpg"}', 'Description 7'),
    ('Daniel', 'Miller', '1997-08-08', 'daniel.miller@example.com', 'passwordmno', '{"url": "https://example.com/photo8.jpg"}', 'Description 8'),
    ('Olivia', 'Wilson', '1998-09-09', 'olivia.wilson@example.com', 'passwordpqr', '{"url": "https://example.com/photo9.jpg"}', 'Description 9'),
    ('William', 'Taylor', '1999-10-10', 'william.taylor@example.com', 'passwordstu', '{"url": "https://example.com/photo10.jpg"}', 'Description 10');

select * from users;

INSERT INTO trip (destination_country, destination_city, start_date, end_date, budget, type_name, transport_name, description, user_id)
VALUES
  ('France', 'Paris', '2024-05-01', '2024-05-10', 1000.00, 'Sightseeing', 'Flight', 'Trip to Paris for sightseeing', 1),
  ('Italy', 'Rome', '2024-06-15', '2024-06-25', 1500.00, 'Cultural', 'Train', 'Cultural trip to Rome', 2),
  ('Spain', 'Barcelona', '2024-07-10', '2024-07-20', 1200.00, 'Beach', 'Bus', 'Beach vacation in Barcelona', 3),
  ('Japan', 'Tokyo', '2024-08-05', '2024-08-15', 2000.00, 'Adventure', 'Flight', 'Adventure trip to Tokyo', 4),
  ('USA', 'New York', '2024-09-20', '2024-09-30', 1800.00, 'City Break', 'Flight', 'City break in New York', 5),
  ('Germany', 'Berlin', '2024-10-10', '2024-10-20', 1300.00, 'Cultural', 'Train', 'Cultural trip to Berlin', 6),
  ('Australia', 'Sydney', '2024-11-15', '2024-11-25', 2500.00, 'Adventure', 'Flight', 'Adventure trip to Sydney', 7),
  ('Greece', 'Athens', '2024-12-01', '2024-12-10', 1400.00, 'Beach', 'Flight', 'Beach vacation in Athens', 8),
  ('Canada', 'Toronto', '2025-01-05', '2025-01-15', 1700.00, 'City Break', 'Flight', 'City break in Toronto', 9),
  ('Thailand', 'Bangkok', '2025-02-10', '2025-02-20', 2200.00, 'Adventure', 'Flight', 'Adventure trip to Bangkok', 10);

select * from trip;

INSERT INTO blog (title, country, city, season_visited, description, user_id)
VALUES
    ('My Trip to Paris', 'France', 'Paris', '2023-05-15', 'Visited famous landmarks in Paris.', 1),
    ('Exploring Rome', 'Italy', 'Rome', '2023-07-20', 'Sightseeing in Rome.', 2),
    ('Beach Vacation in Bali', 'Indonesia', 'Bali', '2023-10-10', 'Relaxing on the beautiful beaches of Bali.', 3),
    ('Hiking in the Swiss Alps', 'Switzerland', 'Interlaken', '2023-08-05', 'Adventurous hike in the Alps.', 4),
    ('Cultural Tour of Kyoto', 'Japan', 'Kyoto', '2023-11-30', 'Exploring temples and traditional culture in Kyoto.', 5),
    ('City Break in New York', 'USA', 'New York', '2023-04-25', 'Exploring the vibrant city of New York.', 6),
    ('Road Trip in Australia', 'Australia', 'Sydney', '2023-09-15', 'Exploring the beautiful landscapes of Australia.', 7),
    ('Winter Holiday in Lapland', 'Finland', 'Rovaniemi', '2023-12-20', 'Meeting Santa Claus in Lapland.', 8),
    ('Backpacking in Southeast Asia', 'Thailand', 'Bangkok', '2023-06-10', 'Traveling through Southeast Asia on a budget.', 9),
    ('Cruise in the Caribbean', 'Caribbean', 'Caribbean Islands', '2023-02-15', 'Relaxing cruise in the Caribbean Sea.', 10);

select * from blog;

INSERT INTO host (country, city, available_start_date, available_end_date, house_type, user_id)
VALUES
    ('France', 'Paris', '2023-05-01', '2023-05-10', 'Apartment', 1),
    ('Italy', 'Rome', '2023-07-15', '2023-07-25', 'House', 2),
    ('Spain', 'Barcelona', '2023-08-10', '2023-08-20', 'Villa', 3),
    ('USA', 'New York', '2023-06-01', '2023-06-10', 'Condo', 4),
    ('Japan', 'Tokyo', '2023-09-05', '2023-09-15', 'Apartment', 5),
    ('Australia', 'Sydney', '2023-11-01', '2023-11-10', 'House', 6),
    ('Canada', 'Vancouver', '2023-10-15', '2023-10-25', 'Cabin', 7),
    ('Germany', 'Berlin', '2023-04-01', '2023-04-10', 'Apartment', 8),
    ('Brazil', 'Rio de Janeiro', '2023-12-01', '2023-12-10', 'Condo', 9),
    ('Greece', 'Athens', '2023-03-15', '2023-03-25', 'Villa', 10);

select * from host;


