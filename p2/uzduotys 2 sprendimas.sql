// 1.
SELECT ASMENSKODAS, VARDAS, PAVARDE
FROM DARBUOTOJAS
WHERE GIMIMOMETAI = '1988-07-20';

// 2.
SELECT *
FROM DARBUOTOJAS
WHERE GIMIMOMETAI < '1988-07-29';

// 3.
SELECT DIRBANUO, GIMIMOMETAI
FROM DARBUOTOJAS
-- WHERE DIRBANUO BETWEEN '2009-10-30' AND '2012-11-11';
WHERE DIRBANUO >= '2009-10-30' AND DIRBANUO <= '2012-11-11';

// 4.
SELECT VARDAS, SKYRIUS_PAVADINIMAS, PROJEKTAS_ID
FROM DARBUOTOJAS
WHERE PROJEKTAS_ID IN (2, 3);

// 5.
SELECT VARDAS, PAVARDE, ASMENSKODAS
FROM DARBUOTOJAS
WHERE ASMENSKODAS LIKE '2%'
   OR ASMENSKODAS LIKE '4%'
   OR ASMENSKODAS LIKE '6%';

// 6.
SELECT *
FROM DARBUOTOJAS
WHERE GIMIMOMETAI LIKE '%-12';

// 7.
SELECT *
FROM PROJEKTAS
WHERE PAVADINIMAS LIKE '__u%';

// 8.
SELECT *
FROM DARBUOTOJAS
WHERE PAREIGOS IS NULL;

// 9.
SELECT VARDAS, PAVARDE, DIRBANUO, PAREIGOS
FROM DARBUOTOJAS
-- WHERE DIRBANUO >=  '2011-02-12' AND PAREIGOS LIKE 'Programuot%';
-- WHERE DIRBANUO >=  '2011-02-12' AND (PAREIGOS = 'Programuotojas' OR PAREIGOS = 'Programuotoja');
WHERE DIRBANUO >=  '2011-02-12' AND PAREIGOS IN ('Programuotojas', 'Programuotoja');

// 10.
SELECT VARDAS, PAVARDE, SKYRIUS_PAVADINIMAS, PROJEKTAS_ID
FROM DARBUOTOJAS
WHERE SKYRIUS_PAVADINIMAS = 'Java' OR PROJEKTAS_ID = 1;

// 11.
SELECT VARDAS
FROM DARBUOTOJAS
WHERE VARDAS NOT LIKE 'S%';
-- WHERE SUBSTRING(VARDAS FROM 0 FOR 1) != 'S';

-- pvz naudojant subselect'a
SELECT VARDAS FROM (SELECT VARDAS, SUBSTRING(VARDAS FROM 0 FOR 1) AS pirma_vardo_raide
                    FROM DARBUOTOJAS)
WHERE pirma_vardo_raide != 'S';

// 12.
SELECT VARDAS, DIRBANUO, GIMIMOMETAI
FROM DARBUOTOJAS
-- WHERE DIRBANUO < '2009-10-30' OR DIRBANUO > '2012-11-11';
WHERE DIRBANUO NOT BETWEEN '2009-10-30' AND '2012-11-11';

// 13.
SELECT VARDAS, PAVARDE, GIMIMOMETAI
FROM DARBUOTOJAS
ORDER BY GIMIMOMETAI;

// 14.
SELECT VARDAS, PAVARDE, GIMIMOMETAI
FROM DARBUOTOJAS
ORDER BY GIMIMOMETAI DESC;

// 15.
SELECT MIN(PROJEKTAS_ID) min_projektas_id, MAX(PROJEKTAS_ID) max_projektas_id
FROM DARBUOTOJAS;

// 16.
SELECT PROJEKTAS_ID, COUNT(*)
FROM DARBUOTOJAS
GROUP BY PROJEKTAS_ID;

// 17.
SELECT PROJEKTAS_ID, 'Programuotojai' AS PAREIGOS, COUNT(*) AS skaicius
FROM DARBUOTOJAS
WHERE PAREIGOS LIKE 'Programuot%'
GROUP BY PROJEKTAS_ID, PAREIGOS;

// 18.
SELECT PROJEKTAS_ID, 'Programuotojai' AS PAREIGOS, COUNT(*) AS skaicius
FROM DARBUOTOJAS
WHERE PAREIGOS LIKE 'Programuot%'
GROUP BY PROJEKTAS_ID, PAREIGOS
HAVING COUNT(*) >= 2;
