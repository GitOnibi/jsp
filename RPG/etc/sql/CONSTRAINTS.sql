--------------------------------------------------------
--  Constraints for Table CHARACTER
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."CHARACTER" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."CHARACTER" MODIFY ("CHAR_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DEV
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."DEV" MODIFY ("DEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."DEV" MODIFY ("DEV_PW" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."ITEM" MODIFY ("ITEM_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."ITEM" MODIFY ("ITEM_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."MEMBER" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."MEMBER" MODIFY ("USER_PW" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MOB
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."MOB" MODIFY ("MOB_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."MOB" MODIFY ("MOB_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table NOTICE
--------------------------------------------------------

  ALTER TABLE "ONIGAWARA"."NOTICE" MODIFY ("USER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."NOTICE" MODIFY ("TITLE" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."NOTICE" MODIFY ("REGDATE" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."NOTICE" MODIFY ("MODDATE" NOT NULL ENABLE);
 
  ALTER TABLE "ONIGAWARA"."NOTICE" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
