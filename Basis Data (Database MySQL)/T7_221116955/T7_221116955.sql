--2
delimiter $
CREATE OR REPLACE PROCEDURE tugas2(nama_manager VARCHAR(100))
BEGIN
	DECLARE NAMA VARCHAR(100);
	DECLARE MANAGER_ID INT(10);
	DECLARE CEK_KOSONG INT;
	DECLARE NAMA_K VARCHAR(100);
	DECLARE C INT;
	
	DECLARE LIST CURSOR FOR
		SELECT K.NAMA 
		FROM KARYAWAN K
		WHERE K.ID_MANAGER = MANAGER_ID
		ORDER BY LENGTH(K.NAMA) desc;
		
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET CEK_KOSONG=1;
	
	SET C = 1;
	
	SELECT M.ID INTO MANAGER_ID
	FROM MANAGER M
	WHERE UPPER(M.NAMA) LIKE UPPER(nama_manager);
	
	SELECT "#=============================#";
	SELECT CONCAT("|",nama_manager,"|");
	SELECT "#=============================#";
	
	OPEN LIST;
	
	LUPS: LOOP
		FETCH LIST INTO NAMA;
		
		IF CEK_KOSONG =1 THEN
			LEAVE LUPS;
		ELSE
			SELECT K.NAMA INTO NAMA_K
			FROM KARYAWAN K
			WHERE K.NAMA LIKE NAMA;
			SELECT CONCAT("| ",C,". ",RPAD(NAMA_K,25),"|");
			SET C = C+1;
		END IF;
	END LOOP LUPS;
	CLOSE LIST;
	SELECT "#=============================#";
END $
DELIMITER ;

CALL tugas2('PUTRI RATNA');

--3
CREATE OR REPLACE PROCEDURE tugas3()
BEGIN
	DECLARE BRAND INT;
	DECLARE CEK_KOSONG=1
	DECLARE LIST CURSOR FOR
		SELECT M.ID
		FROM MERK M
		
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET CEK_KOSONG = 1;
	
	OPEN LIST;
	
	LUPS: LOOP
		FETCH LIST INTO BRAND;
		
		
		
		SELECT 
	
	END LOOP LUPS;
	CLOSE LIST;
	
--4
delimiter $
CREATE OR REPLACE PROCEDURE tugas4(kodeSearch varchar(100))
BEGIN
	DECLARE TANGGAL VARCHAR(100);
	DECLARE TEMPTANGGAL DATETIME;
	DECLARE CEK_KOSONG INT;
	DECLARE CODEBARANG VARCHAR(100);
	DECLARE QTY_B INT;
	DECLARE NAMA_BARANG VARCHAR(100);
	DECLARE KODE VARCHAR(100);
	DECLARE TOTAL INT;
	
	DECLARE LIST CURSOR FOR 
		SELECT dp.id_barang 
		from d_pindah dp
		where kodeSearch=dp.kode;
		
	DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET CEK_KOSONG = 1;
	
	SELECT HP.TANGGAL INTO TEMPTANGGAL
	FROM H_PINDAH HP
	WHERE kodeSearch=HP.KODE;
	
	SET TANGGAL = CONCAT(DAY(TEMPTANGGAL)," ",MONTHNAME(TEMPTANGGAL)," ",YEAR(TEMPTANGGAL));
	SET TOTAL = 0;

	SELECT "========================================";
	SELECT "|        Data Perpindahan Barang       |";
	SELECT "========================================";
	SELECT CONCAT("| ",RPAD(kodeSearch,6),LPAD(TANGGAL,30)," |");
	SELECT "========================================";
	SELECT "| Daftar Barang :                      |";
	
	
	OPEN LIST;
	
	LUPS: LOOP
		FETCH LIST INTO KODE;
		
		IF CEK_KOSONG = 1 THEN
			LEAVE LUPS;
		ELSE
			SELECT B.KODE, B.NAMA, DP.QTY INTO CODEBARANG, NAMA_BARANG, QTY_B
			FROM D_PINDAH DP, BARANG B
			WHERE B.ID = KODE AND DP.KODE = kodeSearch
			group by b.nama;
			
			SET TOTAL = TOTAL + QTY_B;
			
			SELECT CONCAT("| <",CODEBARANG,"> ",rpad(NAMA_BARANG,25),"x",QTY_B," |");
		END IF;
	END LOOP LUPS;
	CLOSE LIST;
	
	SELECT "|--------------------------------------|";
	SELECT CONCAT("|                    Total Barang : ",RPAD(TOTAL,2)," |");
	SELECT "========================================";
	
END $
delimiter ;
	
--5
delimiter $
CREATE OR REPLACE FUNCTION tugas5(search_name varchar(100))
	returns varchar(100)
BEGIN
	DECLARE JUMLAH INT;
	DECLARE SEARCH_ID INT;
	DECLARE HASIL VARCHAR(100);
	
	SET JUMLAH = 0;
	SET SEARCH_ID = 0;
	
	SELECT S.ID INTO SEARCH_ID
	FROM SUPIR S
	WHERE UPPER(S.NAMA) LIKE UPPER(SEARCH_NAME);
	
	SELECT COUNT(HP.ID_SUPIR) INTO JUMLAH
	FROM H_PINDAH HP, SUPIR S
	WHERE HP.ID_SUPIR=search_id
	order by HP.KODE;
	
	SET JUMLAH = JUMLAH/10;
	
	IF SEARCH_ID = 0 THEN
		SET HASIL = CONCAT("Supir tersebut tidak dikenali.");
	ELSE
		SET HASIL = CONCAT(SEARCH_NAME," telah mengantar perpindahan barang sebanyak ",JUMLAH," kali.");
	END IF;
	
	RETURN HASIL;

END$

DELIMITER ;

CALL tugas5('AAAA');
CALL tugas5('Budi Hartono');