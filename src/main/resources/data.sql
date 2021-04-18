/* all these passwords are "5k_&7Pm" */
INSERT INTO user
(user_name, password, first_name, last_name, date_of_birth, email)
VALUES
('marge','$2a$10$pBLiAxZbAFJhDf4T/IRtYOB5L63n67L.UNJwYmOAJymIef3mb/LLS','marge','simpson','01/02/1995','marge@gmail.com'),
('homer','$2a$10$7rEH.DrwUs2v4NzRVHfWA.QYln0iA7nkBB9eBgcr5JMRvMfOWCpeO','homer','simpson','06/25/1995','homer@gmail.com'),
('bart','$2a$10$a6gSikY.8bF7R0zpd3LyUujv.0gDRMCMF1F/xOZ16cz2FR6snJ4OS','bart','simpson','03/03/1997','bart@gmail.com'),
('lisa','$2a$10$JbZjSDzfDyLmwy3icHBaN.zIavFQchsL7j75CBs0Uu4rYrktRmQtS','lisa','simpson','02/15/1999','lisa@gmail.com'),
('cait','$2a$10$.95FDoXYlSRlfpl/7FsrM.vQk50f3RYIL3tLC0rQzqcr.WmfX96qG','cait','white','01/31/1992','cait@gmail.com'),
('john','$2a$10$boWiD1064C7SDT7QGNLUTuSfPeFwjAybhyX1XKcl0crJ2/mRkTiom','john','doe','09/06/1998','john@gmail.com');

INSERT INTO role
(role_name)
VALUES
('ROLE_STUDENT'),
('ROLE_TEACHER');

INSERT INTO user_role
(user_id, role_id)
VALUES
(1,1),
(2,1),
(3,1),
(4,2),
(5,2),
(6,2);
