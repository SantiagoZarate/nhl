INSERT INTO player (id, name, team)
VALUES
('ab04173b-100b-48a3-aa53-20ed6286af43', 'John Doe', 'New Jersey'),
('6a416463-7a33-4466-a4d4-58d75a1b243d', 'Jane Smith', 'New Jersey'),
('7f76a49f-ed23-487b-9b2e-ec065d63ec0e', 'Michael Johnson', 'Philadelphia'),
('a2664695-c57d-46f2-a574-78e3abae9935', 'Emily Williams', 'Philadelphia.'),
('cdcb9f70-f782-4a51-bd48-10d5b9f59185', 'David Brown', 'Buffalo'),
('dcd67ebd-fddf-4c99-a4c0-83a96b1beba7', 'Sarah Wilson', 'Buffalo');

INSERT INTO match (id, host_team, guest_team, mvp_player_id, score, winner)
VALUES
('match_1', 'New Jersey', 'Philadelphia', '6a416463-7a33-4466-a4d4-58d75a1b243d', '5-3', 'New Jersey'),
('match_2', 'Philadelphia', 'Buffalo', 'a2664695-c57d-46f2-a574-78e3abae9935', '2-1', 'Philadelphia'),
('match_3', 'Buffalo', 'New Jersey', 'dcd67ebd-fddf-4c99-a4c0-83a96b1beba7', '3-2', 'Buffalo');

INSERT INTO team (id, logo_url, captain_id)
VALUES
('New Jersey', 'https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/New_Jersey_Devils_logo.svg/1200px-New_Jersey_Devils_logo.svg.png', 'ab04173b-100b-48a3-aa53-20ed6286af43'),
('Philadelphia', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Logo_Philadelphia_Flyers.svg/1200px-Logo_Philadelphia_Flyers.svg.png', '7f76a49f-ed23-487b-9b2e-ec065d63ec0e'),
('Buffalo', 'https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Buffalo_Sabres_Logo.svg/1200px-Buffalo_Sabres_Logo.svg.png', 'cdcb9f70-f782-4a51-bd48-10d5b9f59185');