INSERT INTO contact_us
(email, full_name, issue_message, status)
VALUES('', '', '', false);

INSERT INTO media
(title, creator, synopsis, media_type, genre, status, user_id)
VALUES('', '', '', '', '', false, 0);

INSERT INTO review
(status, created_at, user_id, rating, user_review, media_id)
VALUES(false, '', 0, 0, '', 0);

INSERT INTO web_user
(first_name, last_name, email, user_password, enabled_moderator)
VALUES('', '', '', '', false);