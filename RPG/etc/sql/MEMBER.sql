-- 내부 생성기를 시도하는 DBMS_METADATA로 ONIGAWARA.MEMBER 객체에 대한 TABLE DDL을 렌더링할 수 없습니다.
CREATE TABLE MEMBER 
(
  USER_ID VARCHAR2(100 BYTE) 
, USER_PW VARCHAR2(100 BYTE) 
, NDATE DATE 
, USER_EMAIL VARCHAR2(100 BYTE) 
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
