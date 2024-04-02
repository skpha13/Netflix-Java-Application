create audit policy audit_all_operations
    ACTIONS select on FILM,
            insert on FILM,
            update on FILM,
            delete on FILM,
            select on SERIAL,
            insert on SERIAL,
            update on SERIAL,
            delete on SERIAL,
            select on SUBSCRIPTIE,
            insert on SUBSCRIPTIE,
            update on SUBSCRIPTIE,
            delete on SUBSCRIPTIE,
            select on UTILIZATOR,
            insert on UTILIZATOR,
            update on UTILIZATOR,
            delete on UTILIZATOR;

audit policy audit_all_operations;

-- SQL STATEMENT TO GET ALL ACTIONS DONE UNDER "AUDIT_ALL_OPERATIONS"
-- under UTILIZATOR user
select object_schema,
       object_name,
       sql_text
from UNIFIED_AUDIT_TRAIL
where current_user = 'UTILIZATOR' and UNIFIED_AUDIT_POLICIES = 'AUDIT_ALL_OPERATIONS';

-- PL/SQL STATEMENT TO PURGE UNIFIED_AUDIT_TRAIL
BEGIN
    DBMS_AUDIT_MGMT.CLEAN_AUDIT_TRAIL(
            AUDIT_TRAIL_TYPE => DBMS_AUDIT_MGMT.AUDIT_TRAIL_UNIFIED,
            USE_LAST_ARCH_TIMESTAMP => FALSE,
            CONTAINER => dbms_audit_mgmt.container_current);
END;
/