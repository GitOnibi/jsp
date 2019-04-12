-- ���� �����⸦ �õ��ϴ� DBMS_METADATA�� ONIGAWARA.EQUIP ��ü�� ���� TABLE DDL�� �������� �� �����ϴ�.
CREATE TABLE EQUIP 
(
  IDX NUMBER(2, 0) 
, ITEM_CODE NUMBER(4, 0) 
, CHAR_NAME VARCHAR2(100 BYTE) 
, USER_ID VARCHAR2(100 BYTE) 
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