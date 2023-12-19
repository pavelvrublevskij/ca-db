// 1.
select *
from DARBUOTOJAS;

// 2.
select ASMENSKODAS
from DARBUOTOJAS;

// 3.
select VARDAS, PAVARDE, PAREIGOS
from DARBUOTOJAS;

// 4.
SELECT DISTINCT SKYRIUS_PAVADINIMAS
FROM DARBUOTOJAS;

// 5.
select *
from DARBUOTOJAS
where SKYRIUS_PAVADINIMAS = 'Java';

// 6.
select PAREIGOS
from DARBUOTOJAS
where VARDAS = 'Giedrius';

// 7.
select *
from DARBUOTOJAS
where GIMIMOMETAI = '1986-09-19';

// 8.
select VARDAS
from DARBUOTOJAS
where PAVARDE = 'Sabutis';

// 9.
SELECT VARDAS, PAVARDE
FROM DARBUOTOJAS
WHERE SKYRIUS_PAVADINIMAS = 'Java'
  AND (PAREIGOS = 'Programuotojas' OR PAREIGOS = 'Programuotoja');

// 10.
insert into DARBUOTOJAS
VALUES ('38503142410', 'Jonė', 'Kalnas', '2009-05-11', '1985-03-24', 'Programuotoja', 'Java', 1);

// 11.
insert into DARBUOTOJAS (ASMENSKODAS, VARDAS, PAVARDE, DIRBANUO, GIMIMOMETAI)
values ('38503142411', 'Ona', 'Onutė', '2007-05-11', '1985-03-24');

// 12.
update DARBUOTOJAS
SET SKYRIUS_PAVADINIMAS = 'Java',
    PAREIGOS            = 'Programuotoja',
    PROJEKTAS_ID        = '1'
WHERE ASMENSKODAS = '38503142411';

// 13.
DELETE
FROM DARBUOTOJAS
WHERE ASMENSKODAS = '38503142411';

// 14.
insert into DARBUOTOJAS
VALUES ('38503142411', 'Jonas', 'Antanaitis', '2009-05-11', '1985-03-24', 'Programuotojas', 'Java', 1),
       ('38503142413', 'Petras', 'Antanaitis', '2009-05-11', '1985-03-24', 'Programuotojas', 'Java', 1);

// 15.
UPDATE DARBUOTOJAS
SET PAREIGOS = 'Testuotojas'
WHERE PAVARDE = 'Antanaitis';

// 16.
SELECT COUNT(*) AS "Kiekis testuotojų"
FROM DARBUOTOJAS
WHERE PAREIGOS = 'Testuotojas' OR PAREIGOS = 'Testuotoja';
