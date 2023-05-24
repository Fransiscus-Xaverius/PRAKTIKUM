--1
DELIMITER $
CREATE OR REPLACE PROCEDURE TA1(SEARCH_ID INT(10))
BEGIN
	DECLARE CEK_KOSONG INT;
	DECLARE NOPOL VARCHAR(12);
	DECLARE MERK_K VARCHAR(50);
	DECLARE ID INT(10);
	
	DECLARE NAMA_S VARCHAR(100);
	DECLARE TGL DATE;
	DECLARE ASAL INT;
	DECLARE TUJUAN INT;

	DECLARE LIST CURSOR FOR
		SELECT HP.KODE
		FROM H_PINDAH HP
		WHERE ID_KENDARAAN=SEARCH_ID
		ORDER BY HP.TANGGAL;
		
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET CEK_KOSONG = 1;
		
	SELECT K.NOPOL, K.MERK INTO NOPOL, MERK_K
	FROM KENDARAAN K
	WHERE K.ID=SEARCH_ID;
	
	SELECT '#==================================#';
	SELECT CONCAT("|",LPAD(NOPOL,17)," - ",RPAD(MERK_K,14),"|");
	SELECT '#==================================#';
	
	OPEN LIST;
	
	LUPS: LOOP
		FETCH LIST INTO ID;
		
		IF CEK_KOSONG=1 THEN
			LEAVE LUPS;
		ELSE
			SELECT S.NAMA, HP.TANGGAL, HP.ASAL, HP.TUJUAN INTO NAMA_S,TGL,ASAL,TUJUAN
			FROM SUPIR S, H_PINDAH HP
			WHERE HP.KODE=ID and S.ID=HP.ID_SUPIR
			GROUP BY HP.KODE;
			
			SELECT NAMA_S;
			SELECT TGL;
			SELECT ASAL;
			SELECT TUJUAN;
			
			SELECT '#----------------------------------#';
			SELECT CONCAT("| Tanggal : ",RPAD(CONCAT(DAY(TGL)," ",MONTHNAME(TGL),YEAR(TGL)),23),"|");
			SELECT CONCAT("| Asal : WAREHOUSE ",RPAD(ASAL,13),"|");
			SELECT '#----------------------------------#';
		END IF;
		
	END LOOP LUPS;
	CLOSE LIST;
	
END$
DELIMITER ;

--2
DELIMITER $
CREATE OR REPLACE PROCEDURE TA2(SEARCH_ID INT)
BEGIN
	DECLARE CEK_KOSONG INT;

	DECLARE LIST CURSOR FOR
		SELECT K.ID
		FROM KARYAWAN K
		WHERE K.ID=SEARCH_ID;
		
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET CEK_KOSONG=1;

	LUPS: LOOP
		FETCH LIST INTO ID
		
		IF CEK_KOSONG = 1;
			LEAVE LUPS;
		ELSE
			SELECT 

END$
DELIMITER ;