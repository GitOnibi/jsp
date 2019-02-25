  CREATE TABLE "ONIGAWARA"."MONSTER" 
   (	"IDX" NUMBER(3,0), 
	"LV" NUMBER(3,0), 
	"NAME" VARCHAR2(100 BYTE), 
	"STR" NUMBER(3,0), 
	"DEX" NUMBER(3,0), 
	"INT" NUMBER(3,0), 
	"SK1" VARCHAR2(100 BYTE), 
	"SK2" VARCHAR2(100 BYTE), 
	"SK3" VARCHAR2(100 BYTE), 
	"DR1" VARCHAR2(100 BYTE), 
	"DR2" VARCHAR2(100 BYTE), 
	"DR3" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into ONIGAWARA.MONSTER
SET DEFINE OFF;