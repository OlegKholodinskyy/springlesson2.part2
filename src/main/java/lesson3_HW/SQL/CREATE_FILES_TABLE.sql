CREATE TABLE FILES(
ID NUMBER,
CONSTRAINT ID_FILE PRIMARY KEY (ID),
NAME NVARCHAR2(50) NOT NULL,
FORMAT NVARCHAR2(50) NOT NULL,
FILE_SIZE NUMBER,
STORAGE_ID NUMBER,
CONSTRAINT ID_STORAGE_FK FOREIGN KEY (STORAGE_ID) REFERENCES STORAGE(ID));


CREATE SEQUENCE SEQ_FILE MINVALUE 300 MAXVALUE 4000  START WITH 301 INCREMENT BY 1;