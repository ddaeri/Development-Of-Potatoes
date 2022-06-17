CREATE TABLE GAME_ADMIN(
	   gameid			NUMBER			PRIMARY KEY
	 , title			VARCHAR2(50)	NOT NULL
	 , genre			VARCHAR2(80)	NOT NULL
	 , developer		VARCHAR2(40)	NOT NULL
	 , releasdate		VARCHAR2(10)	NOT NULL
	 , price			NUMBER			NOT NULL
);

SELECT * FROM GAME_ADMIN;

DROP TABLE GAME_ADMIN;

COMMIT;