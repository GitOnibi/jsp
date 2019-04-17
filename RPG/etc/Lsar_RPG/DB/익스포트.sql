--------------------------------------------------------
--  파일이 생성됨 - 목요일-3월-28-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table AVATAR
--------------------------------------------------------

  CREATE TABLE "AVATAR" 
   (	"M_ID" VARCHAR2(20), 
	"M_LEVEL" NUMBER(3,0) DEFAULT 1, 
	"M_RANK" VARCHAR2(20) DEFAULT 1, 
	"HP" NUMBER(15,0) DEFAULT 100, 
	"MP" NUMBER(15,0) DEFAULT 10, 
	"DP" NUMBER(15,0) DEFAULT 10, 
	"SWORD" NUMBER(10,0) DEFAULT 0, 
	"SPELL" NUMBER(10,0) DEFAULT 0, 
	"DIVINE" NUMBER(10,0) DEFAULT 0, 
	"FATIGUE" NUMBER(10,0) DEFAULT 100, 
	"NATIONAL" VARCHAR2(20)
   )
--------------------------------------------------------
--  DDL for Table EQUIP
--------------------------------------------------------

  CREATE TABLE "EQUIP" 
   (	"CODE" NUMBER(10,0), 
	"EQUIP_NAME" VARCHAR2(40), 
	"EQUIP_TYPE" VARCHAR2(20), 
	"EQUIP_OPTION1" NUMBER(8,0) DEFAULT 0, 
	"EQUIP_OPTION2" NUMBER(8,0) DEFAULT 0, 
	"EQUIP_OPTION3" NUMBER(8,0) DEFAULT 0, 
	"EQUIP_OPTION4" NUMBER(8,0) DEFAULT 0, 
	"EQUIP_PART" VARCHAR2(20)
   )
--------------------------------------------------------
--  DDL for Table JKR
--------------------------------------------------------

  CREATE TABLE "JKR" 
   (	"ID" NUMBER(10,0), 
	"NUM" NUMBER(3,0), 
	"TYPE" NUMBER(2,0), 
	"USING" NUMBER(1,0), 
	"PROF" NUMBER(3,0)
   )
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER" 
   (	"MEMBER_ID" VARCHAR2(20), 
	"EMAIL" VARCHAR2(40), 
	"PASSWORD" VARCHAR2(30), 
	"J_DATE" DATE, 
	"LOCATION" VARCHAR2(20), 
	"N_DATE" DATE
   )
--------------------------------------------------------
--  DDL for Table SKILL
--------------------------------------------------------

  CREATE TABLE "SKILL" 
   (	"CODE" NUMBER(10,0), 
	"SKILL_NAME" VARCHAR2(40), 
	"SKILL_TYPE" VARCHAR2(20), 
	"SKILL_OPTION1" NUMBER(8,0) DEFAULT 0, 
	"SKILL_OPTION2" NUMBER(8,0) DEFAULT 0, 
	"SKILL_OPTION3" NUMBER(8,0) DEFAULT 0, 
	"SKILL_OPTION4" NUMBER(8,0) DEFAULT 0, 
	"SKILL_KIND" VARCHAR2(20) DEFAULT 0
   )
REM INSERTING into AVATAR
SET DEFINE OFF;
Insert into AVATAR (M_ID,M_LEVEL,M_RANK,HP,MP,DP,SWORD,SPELL,DIVINE,FATIGUE,NATIONAL) values ('jkr',1,'1',100,10,10,12,23,8,100,'와이트');
REM INSERTING into EQUIP
SET DEFINE OFF;
REM INSERTING into JKR
SET DEFINE OFF;
REM INSERTING into MEMBER
SET DEFINE OFF;
Insert into MEMBER (MEMBER_ID,EMAIL,PASSWORD,J_DATE,LOCATION,N_DATE) values ('1','1','1',to_date('19/03/25','RR/MM/DD'),'산악마을',to_date('19/03/25','RR/MM/DD'));
Insert into MEMBER (MEMBER_ID,EMAIL,PASSWORD,J_DATE,LOCATION,N_DATE) values ('jkr','naver','1234',to_date('19/03/25','RR/MM/DD'),'산악마을',to_date('19/03/25','RR/MM/DD'));
Insert into MEMBER (MEMBER_ID,EMAIL,PASSWORD,J_DATE,LOCATION,N_DATE) values ('a','1','1',to_date('19/03/25','RR/MM/DD'),'산악마을',to_date('19/03/25','RR/MM/DD'));
REM INSERTING into SKILL
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0011413
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011413" ON "AVATAR" ("M_ID")
--------------------------------------------------------
--  DDL for Index SYS_C0011442
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011442" ON "EQUIP" ("CODE")
--------------------------------------------------------
--  DDL for Index JKR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JKR_PK" ON "JKR" ("NUM")
--------------------------------------------------------
--  DDL for Index SYS_C0011258
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011258" ON "MEMBER" ("MEMBER_ID")
--------------------------------------------------------
--  DDL for Index SYS_C0011434
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0011434" ON "SKILL" ("CODE")
--------------------------------------------------------
--  Constraints for Table AVATAR
--------------------------------------------------------

  ALTER TABLE "AVATAR" MODIFY ("M_ID" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("M_LEVEL" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("M_RANK" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("HP" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("MP" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("DP" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("SWORD" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("SPELL" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("DIVINE" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" MODIFY ("FATIGUE" NOT NULL ENABLE)
 
  ALTER TABLE "AVATAR" ADD PRIMARY KEY ("M_ID") ENABLE
--------------------------------------------------------
--  Constraints for Table EQUIP
--------------------------------------------------------

  ALTER TABLE "EQUIP" MODIFY ("CODE" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_NAME" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_TYPE" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_OPTION1" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_OPTION2" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_OPTION3" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_OPTION4" NOT NULL ENABLE)
 
  ALTER TABLE "EQUIP" ADD PRIMARY KEY ("CODE") ENABLE
 
  ALTER TABLE "EQUIP" MODIFY ("EQUIP_PART" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table JKR
--------------------------------------------------------

  ALTER TABLE "JKR" ADD CONSTRAINT "JKR_PK" PRIMARY KEY ("NUM") ENABLE
 
  ALTER TABLE "JKR" MODIFY ("NUM" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE)
 
  ALTER TABLE "MEMBER" MODIFY ("PASSWORD" NOT NULL ENABLE)
 
  ALTER TABLE "MEMBER" MODIFY ("J_DATE" NOT NULL ENABLE)
 
  ALTER TABLE "MEMBER" MODIFY ("LOCATION" NOT NULL ENABLE)
 
  ALTER TABLE "MEMBER" ADD PRIMARY KEY ("MEMBER_ID") ENABLE
 
  ALTER TABLE "MEMBER" MODIFY ("N_DATE" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table SKILL
--------------------------------------------------------

  ALTER TABLE "SKILL" MODIFY ("CODE" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_NAME" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_TYPE" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_OPTION1" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_OPTION2" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_OPTION3" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_OPTION4" NOT NULL ENABLE)
 
  ALTER TABLE "SKILL" ADD PRIMARY KEY ("CODE") ENABLE
 
  ALTER TABLE "SKILL" MODIFY ("SKILL_KIND" NOT NULL ENABLE)
