--------------------------------------------------------
--  File created - Friday-April-08-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MANTRANSACTION
--------------------------------------------------------

  CREATE TABLE "ORA1"."MANTRANSACTION" 
   (	"TRANSID" NUMBER(*,0) GENERATED BY DEFAULT AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE , 
	"ACCOUNTID" NUMBER(*,0), 
	"TRANSTYPE" VARCHAR2(5 BYTE), 
	"AMOUNT" NUMBER(7,2), 
	"TRANSDATE" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into ORA1.MANTRANSACTION
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0011128
--------------------------------------------------------

  CREATE UNIQUE INDEX "ORA1"."SYS_C0011128" ON "ORA1"."MANTRANSACTION" ("TRANSID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MANTRANSACTION
--------------------------------------------------------

  ALTER TABLE "ORA1"."MANTRANSACTION" ADD PRIMARY KEY ("TRANSID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ORA1"."MANTRANSACTION" MODIFY ("TRANSID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table MANTRANSACTION
--------------------------------------------------------

  ALTER TABLE "ORA1"."MANTRANSACTION" ADD CONSTRAINT "FK_ACCOUNTID" FOREIGN KEY ("ACCOUNTID")
	  REFERENCES "ORA1"."MANACCOUNT" ("ACCOUNTID") ENABLE;
