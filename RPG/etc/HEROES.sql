  CREATE TABLE "ONIGAWARA"."HEROES" 
   (	"IDX" NUMBER(2,0), 
	"CLASS" NUMBER(1,0), 
	"STR" NUMBER(3,0), 
	"DEX" NUMBER(3,0), 
	"INT" NUMBER(3,0), 
	"SK1" VARCHAR2(100 BYTE), 
	"SK2" VARCHAR2(100 BYTE), 
	"SK3" VARCHAR2(100 BYTE), 
	"SK4" VARCHAR2(100 BYTE), 
	"SK5" VARCHAR2(100 BYTE), 
	"NAME" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into ONIGAWARA.HEROES
SET DEFINE OFF;