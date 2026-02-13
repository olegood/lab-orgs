create table if not exists ORGANIZATION
(
    ID                  bigint                   not null,
    CODE                varchar(15)              not null,
    NAME                varchar(64)              not null,
    WEBSITE             varchar(64),
    COUNTRY             varchar(64)              not null,
    DESCRIPTION         varchar(300),
    FOUNDED             integer,
    INDUSTRY            varchar(100)             not null,
    NUMBER_OF_EMPLOYEES integer,
    STATUS              varchar(16)              not null,
    CREATED_DATE        timestamp with time zone not null,
    LAST_MODIFIED_DATE  timestamp with time zone not null,
    constraint pk_organization primary key (ID),
    constraint uk_organization_code unique (CODE),
    constraint check_founded check (FOUNDED >= 1970),
    constraint check_number_of_employees check (NUMBER_OF_EMPLOYEES > 0)
);

create table if not exists ENROLLMENT
(
    ID              bigint      not null,
    ORGANIZATION_ID bigint      not null,
    TYPE            varchar(16) not null,
    STATUS          varchar(16) not null,
    constraint pk_enrollment unique (ID),
    constraint fk_organization_id foreign key (ORGANIZATION_ID) references ORGANIZATION (ID)
);

create table if not exists MARKER
(
    ID            bigint      not null,
    ENROLLMENT_ID bigint      not null,
    TYPE          varchar(16) not null,
    START_DATE    date        not null,
    END_DATE      date,
    constraint pk_marker primary key (ID),
    constraint fk_enrollment_id foreign key (ENROLLMENT_ID) references ENROLLMENT (ID)
);
