INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 101,'Springboot',sysdate() ,sysdate());
INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 102,'Microservices',sysdate() ,sysdate() );
INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 103,'Kubernetes',sysdate() ,sysdate() );

INSERT INTO STUDENT ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 300,'madhav',sysdate() ,sysdate());
INSERT INTO STUDENT ( ID , NAME,CREATED_DATE,LAST_UPDATED) VALUES ( 301,'teja',sysdate() ,sysdate());
INSERT INTO STUDENT ( ID , NAME,CREATED_DATE,LAST_UPDATED ) VALUES ( 302,'kumar',sysdate() ,sysdate());

INSERT INTO STUDENT_COURSE  ( STUDENT_ID , COURSE_ID ) VALUES (300,101);
INSERT INTO STUDENT_COURSE  ( STUDENT_ID , COURSE_ID ) VALUES (301,101);

INSERT INTO STUDENT_COURSE  ( STUDENT_ID , COURSE_ID ) VALUES (300,102);
INSERT INTO STUDENT_COURSE  ( STUDENT_ID , COURSE_ID ) VALUES (301,103);
INSERT INTO STUDENT_COURSE  ( STUDENT_ID , COURSE_ID ) VALUES (302,102);



