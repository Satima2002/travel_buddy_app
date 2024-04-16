INSERT INTO users (first_name, last_name,user_name, dob, email, password, profile_photo, description)
VALUES
    ('John', 'Doe','userJ', '1990-05-15', 'john.doe@example.com', 'password123', '{"url": "https://example.com/photo1.jpg"}', 'Some description 1'),
    ('Alice', 'Smith','userA', '1985-09-20', 'alice.smith@example.com', 'p@ssw0rd', '{"url": "https://example.com/photo2.jpg"}', 'Some description 2'),
    ('Bob', 'Johnson','userB', '1992-03-10', 'bob.johnson@example.com', 'securepassword', '{"url": "https://example.com/photo3.jpg"}', 'Some description 3'),
    ('Bob', 'Brown', 'userL','1993-04-04', 'bob.brown@example.com', 'passwordabc', '{"url": "https://example.com/photo4.jpg"}', 'Description 4'),
    ('Eva', 'Williams', 'userE','1994-05-05' , 'eva.williams@example.com', 'passworddef', '{"url": "https://example.com/photo5.jpg"}', 'Description 5'),
    ('Michael', 'Jones','userM', '1995-06-06', 'michael.jones@example.com', 'passwordghi', '{"url": "https://example.com/photo6.jpg"}', 'Description 6'),
    ('Sophia', 'Davis', 'userJ', '1996-07-07', 'sophia.davis@example.com', 'passwordjkl', '{"url": "https://example.com/photo7.jpg"}', 'Description 7'),
    ('Daniel', 'Miller', 'userK','1997-08-08', 'daniel.miller@example.com', 'passwordmno', '{"url": "https://example.com/photo8.jpg"}', 'Description 8'),
    ('Olivia', 'Wilson', 'userW','1998-09-09', 'olivia.wilson@example.com', 'passwordpqr', '{"url": "https://example.com/photo9.jpg"}', 'Description 9'),
    ('William', 'Taylor', 'userT','1999-10-10', 'william.taylor@example.com', 'passwordstu', '{"url": "https://example.com/photo10.jpg"}', 'Description 10');

select * from users;

INSERT INTO trip (destination_country, destination_city, start_date, end_date, budget, type_name, transport_name, description, user_id)
VALUES
('France', 'Paris', '2024-07-01', '2024-07-10', 2000.00, 'Sightseeing', 'Train', 'Visited famous landmarks in Paris.', 1),
('Italy', 'Rome', '2024-08-15', '2024-08-25', 2500.00, 'Cultural', 'Flight', 'Sightseeing in Rome.', 2),
('Japan', 'Kyoto', '2024-09-01', '2024-09-10', 1800.00, 'Historical', 'Flight', 'Exploring temples and traditional culture in Kyoto.', 3),
('USA', 'New York', '2024-10-15', '2024-10-25', 3000.00, 'City Break', 'Flight', 'Exploring the vibrant city of New York.', 4),
('Australia', 'Sydney', '2024-11-01', '2024-11-10', 2800.00, 'Beach', 'Flight', 'Exploring the beautiful beaches of Sydney.', 5),
('Thailand', 'Bangkok', '2024-12-01', '2024-12-10', 1500.00, 'Backpacking', 'Flight', 'Traveling through Southeast Asia on a budget.', 6),
('Switzerland', 'Interlaken', '2025-01-15', '2025-01-25', 3500.00, 'Adventure', 'Train', 'Adventurous hike in the Swiss Alps.', 7),
('Spain', 'Barcelona', '2025-02-01', '2025-02-10', 2200.00, 'Cultural', 'Flight', 'Exploring the rich culture of Barcelona.', 8),
('Greece', 'Santorini', '2025-03-15', '2025-03-25', 2700.00, 'Beach', 'Flight', 'Relaxing on the beautiful beaches of Santorini.', 9),
('Vietnam', 'Ho Chi Minh City', '2025-04-01', '2025-04-10', 1600.00, 'Historical', 'Flight', 'Exploring the historical sites of Ho Chi Minh City.', 10),
('France', 'Nice', '2025-05-15', '2025-05-25', 2400.00, 'Beach', 'Flight', 'Relaxing on the beaches of Nice.', 1),
('Germany', 'Berlin', '2025-06-01', '2025-06-10', 2000.00, 'City Break', 'Flight', 'Exploring the vibrant city of Berlin.', 2),
('Brazil', 'Rio de Janeiro', '2025-07-15', '2025-07-25', 2800.00, 'Beach', 'Flight', 'Exploring the beaches of Rio de Janeiro.', 3),
('Italy', 'Venice', '2025-08-01', '2025-08-10', 2300.00, 'Romantic', 'Flight', 'Romantic gondola rides in Venice.', 4),
('Mexico', 'Cancun', '2025-09-15', '2025-09-25', 3200.00, 'Beach', 'Flight', 'Relaxing on the beaches of Cancun.', 5),
('Canada', 'Vancouver', '2025-10-01', '2025-10-10', 2600.00, 'Outdoor', 'Flight', 'Exploring the outdoor activities in Vancouver.', 6),
('South Africa', 'Cape Town', '2025-11-15', '2025-11-25', 3100.00, 'Adventure', 'Flight', 'Adventurous activities in Cape Town.', 7),
('New Zealand', 'Queenstown', '2025-12-01', '2025-12-10', 2900.00, 'Adventure', 'Flight', 'Adventure sports in Queenstown.', 8),
('USA', 'Las Vegas', '2026-01-15', '2026-01-25', 3300.00, 'Entertainment', 'Flight', 'Entertainment and nightlife in Las Vegas.', 9),
('Maldives', 'Maldives', '2026-02-01', '2026-02-10', 3600.00, 'Beach', 'Flight', 'Luxury beach experience in the Maldives.', 10),
('France', 'Paris', '2026-03-15', '2026-03-25', 2700.00, 'City Break', 'Flight', 'Another visit to the famous landmarks of Paris.', 1),
('Italy', 'Florence', '2026-04-01', '2026-04-10', 2100.00, 'Art', 'Flight', 'Exploring the art and culture of Florence.', 2),
('USA', 'Los Angeles', '2026-05-15', '2026-05-25', 3400.00, 'Entertainment', 'Flight', 'Entertainment and sightseeing in Los Angeles.', 3),
('Thailand', 'Phuket', '2026-06-01', '2026-06-10', 1900.00, 'Beach', 'Flight', 'Relaxing on the beaches of Phuket.', 4),
('Spain', 'Madrid', '2026-07-15', '2026-07-25', 2500.00, 'Cultural', 'Flight', 'Exploring the cultural heritage of Madrid.', 5),
('Australia', 'Melbourne', '2026-08-01', '2026-08-10', 2800.00, 'City Break', 'Flight', 'Exploring the vibrant city of Melbourne.', 6),
('Greece', 'Athens', '2026-09-15', '2026-09-25', 2200.00, 'Historical', 'Flight', 'Exploring the historical sites of Athens.', 7),
('Italy', 'Amalfi Coast', '2026-10-01', '2026-10-10', 2900.00, 'Beach', 'Flight', 'Relaxing on the beautiful beaches of the Amalfi Coast.', 8),
('Japan', 'Tokyo', '2026-11-15', '2026-11-25', 3200.00, 'City Break', 'Flight', 'Exploring the bustling city of Tokyo.', 9),
('USA', 'San Francisco', '2026-12-01', '2026-12-10', 3300.00, 'City Break', 'Flight', 'Exploring the vibrant city of San Francisco.', 10);

select * from trip;

INSERT INTO blog (title, country, city, season_visited, description, user_id)
VALUES
('Trip to Paris', 'France', 'Paris', 'summer', 'Visited famous landmarks in Paris.', 1),
('Exploring Rome', 'Italy', 'Rome', 'spring', 'Sightseeing in Rome.', 2),
('Beach Vacation in Bali', 'Indonesia', 'Bali', 'winter', 'Relaxing on the beautiful beaches of Bali.', 3),
('Hiking in the Swiss Alps', 'Switzerland', 'Interlaken', 'autumn', 'Adventurous hike in the Alps.', 4),
('Cultural Tour of Kyoto', 'Japan', 'Kyoto', 'summer', 'Exploring temples and traditional culture in Kyoto.', 5),
('City Break in New York', 'USA', 'New York', 'spring', 'Exploring the vibrant city of New York.', 6),
('Road Trip in Australia', 'Australia', 'Sydney', 'summer', 'Exploring the beautiful landscapes of Australia.', 7),
('Winter Holiday in Lapland', 'Finland', 'Rovaniemi', 'spring', 'Meeting Santa Claus in Lapland.', 8),
('Backpacking in Southeast Asia', 'Thailand', 'Bangkok', 'autumn', 'Traveling through Southeast Asia on a budget.', 9),
('Cruise in the Caribbean', 'Caribbean', 'Caribbean Islands', 'autumn', 'Relaxing cruise in the Caribbean Sea.', 10),
('Exploring Tokyo', 'Japan', 'Tokyo', 'summer', 'Exploring the bustling streets of Tokyo.', 1),
('Skiing in the French Alps', 'France', 'Chamonix', 'winter', 'Enjoying skiing and snowboarding in the French Alps.', 2),
('Beach Vacation in Miami', 'USA', 'Miami', 'summer', 'Relaxing on the sandy beaches of Miami.', 3),
('City Break in London', 'UK', 'London', 'autumn', 'Exploring the historic landmarks of London.', 4),
('Exploring Sydney', 'Australia', 'Sydney', 'spring', 'Discovering the iconic landmarks of Sydney.', 5),
('Cultural Tour of Athens', 'Greece', 'Athens', 'summer', 'Exploring ancient ruins and museums in Athens.', 6),
('Safari in South Africa', 'South Africa', 'Kruger National Park', 'spring', 'Spotting wildlife on an African safari.', 7),
('Backpacking in Europe', 'Germany', 'Berlin', 'autumn', 'Exploring Europe on a backpacking adventure.', 8),
('City Break in Barcelona', 'Spain', 'Barcelona', 'summer', 'Exploring the architecture and culture of Barcelona.', 9),
('Beach Vacation in Cancun', 'Mexico', 'Cancun', 'winter', 'Relaxing on the pristine beaches of Cancun.', 10),
('Exploring Hong Kong', 'China', 'Hong Kong', 'spring', 'Discovering the vibrant street markets of Hong Kong.', 1),
('Skiing in Aspen', 'USA', 'Aspen', 'winter', 'Enjoying skiing and snowboarding in the Rocky Mountains.', 2),
('Cultural Tour of Rome', 'Italy', 'Rome', 'summer', 'Exploring ancient landmarks and monuments in Rome.', 3),
('Safari in Kenya', 'Kenya', 'Maasai Mara', 'autumn', 'Spotting wildlife on a safari in the Maasai Mara.', 4),
('City Break in Paris', 'France', 'Paris', 'spring', 'Exploring the romantic streets of Paris.', 5),
('Beach Vacation in Phuket', 'Thailand', 'Phuket', 'summer', 'Relaxing on the beautiful beaches of Phuket.', 6),
('Exploring Rio de Janeiro', 'Brazil', 'Rio de Janeiro', 'autumn', 'Discovering the vibrant culture of Rio de Janeiro.', 7),
('Hiking in Yosemite National Park', 'USA', 'Yosemite', 'spring', 'Hiking among the breathtaking landscapes of Yosemite.', 8),
('City Break in Amsterdam', 'Netherlands', 'Amsterdam', 'summer', 'Exploring the historic canals and museums of Amsterdam.', 9),
('Beach Vacation in Maldives', 'Maldives', 'Maldives', 'winter', 'Relaxing in luxury on the pristine beaches of the Maldives.', 10);


select * from blog;

INSERT INTO host (country, city, available_start_date, available_end_date, house_type, user_id)
VALUES
('France', 'Paris', '2024-07-01', '2024-08-01', 'Apartment', 1),
('Italy', 'Rome', '2024-06-15', '2024-07-15', 'House', 2),
('Indonesia', 'Bali', '2024-09-01', '2024-10-01', 'Villa', 3),
('Switzerland', 'Interlaken', '2024-08-15', '2024-09-15', 'Chalet', 4),
('Japan', 'Kyoto', '2024-07-15', '2024-08-15', 'Traditional House', 5),
('USA', 'New York', '2024-06-01', '2024-07-01', 'Apartment', 6),
('Australia', 'Sydney', '2024-09-15', '2024-10-15', 'House', 7),
('Finland', 'Rovaniemi', '2024-12-01', '2025-01-01', 'Cabin', 8),
('Thailand', 'Bangkok', '2024-10-01', '2024-11-01', 'Apartment', 9),
('Caribbean', 'Caribbean Islands', '2024-11-15', '2024-12-15', 'Beach House', 10),
('France', 'Chamonix', '2024-12-15', '2025-01-15', 'Chalet', 1),
('USA', 'Miami', '2024-06-01', '2024-07-01', 'Apartment', 2),
('UK', 'London', '2024-09-01', '2024-10-01', 'House', 3),
('Australia', 'Sydney', '2024-08-01', '2024-09-01', 'Apartment', 4),
('Greece', 'Athens', '2024-07-15', '2024-08-15', 'Apartment', 5),
('South Africa', 'Kruger National Park', '2024-10-15', '2024-11-15', 'Safari Lodge', 6),
('Germany', 'Berlin', '2024-11-01', '2024-12-01', 'Apartment', 7),
('Spain', 'Barcelona', '2024-06-15', '2024-07-15', 'Apartment', 8),
('Mexico', 'Cancun', '2024-12-01', '2025-01-01', 'Resort', 9),
('China', 'Hong Kong', '2024-08-15', '2024-09-15', 'Apartment', 10),
('USA', 'Aspen', '2024-12-15', '2025-01-15', 'Chalet', 1),
('Italy', 'Rome', '2024-07-01', '2024-08-01', 'Apartment', 2),
('Thailand', 'Phuket', '2024-09-01', '2024-10-01', 'Villa', 3),
('Brazil', 'Rio de Janeiro', '2024-08-15', '2024-09-15', 'Apartment', 4),
('USA', 'Yosemite', '2024-10-01', '2024-11-01', 'Cabin', 5),
('Netherlands', 'Amsterdam', '2024-11-15', '2024-12-15', 'House', 6),
('Maldives', 'Maldives', '2024-06-15', '2024-07-15', 'Overwater Bungalow', 7),
('France', 'Nice', '2024-09-01', '2024-10-01', 'Apartment', 8),
('Italy', 'Venice', '2024-10-15', '2024-11-15', 'Apartment', 9),
('USA', 'San Francisco', '2024-12-01', '2025-01-01', 'Apartment', 10);


select * from host;


