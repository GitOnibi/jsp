-- 내부 생성기를 시도하는 DBMS_METADATA로 ONIGAWARA.NOTICE 객체에 대한 TABLE DDL을 렌더링할 수 없습니다.
CREATE TABLE NOTICE 
(
  NUM NUMBER(10, 0) NOT NULL 
, USER_ID VARCHAR2(100 BYTE) 
, TITLE VARCHAR2(100 BYTE) 
, REGDATE DATE 
, MODDATE DATE 
, READ_CNT NUMBER(10, 0) 
) 
LOGGING 
TABLESPACE SYSTEM 
PCTFREE 10 
PCTUSED 40 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  FREELISTS 1 
  FREELIST GROUPS 1 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL
