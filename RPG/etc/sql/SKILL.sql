-- 내부 생성기를 시도하는 DBMS_METADATA로 ONIGAWARA.SKILL 객체에 대한 TABLE DDL을 렌더링할 수 없습니다.
CREATE TABLE SKILL 
(
  SK_CODE NUMBER(4, 0) 
, SK_NAME VARCHAR2(100 BYTE) 
, SK_ATK NUMBER(4, 0) 
, SK_DEF NUMBER(4, 0) 
, SK_SUB VARCHAR2(1000 BYTE) 
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
