-- 내부 생성기를 시도하는 DBMS_METADATA로 ONIGAWARA.MOB 객체에 대한 TABLE DDL을 렌더링할 수 없습니다.
CREATE TABLE MOB 
(
  MOB_CODE NUMBER(4, 0) 
, MOB_NAME VARCHAR2(100 BYTE) 
, MOB_LV NUMBER(4, 0) 
, MOB_STR NUMBER(4, 0) 
, MOB_DEX NUMBER(4, 0) 
, MOB_PROP NUMBER(2, 0) 
, MOB_SK1 NUMBER(4, 0) 
, MOB_SK2 NUMBER(4, 0) 
, MOB_SK3 NUMBER(4, 0) 
, MOB_SUB VARCHAR2(1000 BYTE) 
, MOB_ATK NUMBER(4, 0) 
, MOB_DEF NUMBER(4, 0) 
, MOB_HP NUMBER 
, MOB_EXP NUMBER(4, 0) 
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
