CREATE TABLE "public"."erequest"
(
    "id"      VARCHAR(255) NOT NULL,
    "payload" VARCHAR(255),
    CONSTRAINT "erequest_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "public"."estats"
(
    "id"         VARCHAR(255) NOT NULL,
    "entry"      INTEGER,
    "word"       VARCHAR(255),
    "request_id" VARCHAR(255) NOT NULL,
    CONSTRAINT "estats_pkey" PRIMARY KEY ("id")
);

ALTER TABLE "public"."estats"
    ADD CONSTRAINT "fk1e8a96jpt2liiar6yisw2ivl0" FOREIGN KEY ("request_id") REFERENCES "public"."erequest" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION;

