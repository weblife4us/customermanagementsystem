create table Persons
(
  PID           nvarchar(10),
  PName         nvarchar(100),
  PAddress      ntext,
  PICHID        nvarchar(10),
  PPhone        nvarchar(150),
  PEmail        nvarchar(255),
  DOBDOI        datetime,
  Gender        nvarchar(11),
  Auth bit constraint DF_Persons_Authorization default 0 not null,
  Gone          bit constraint DF_Persons_Gone default 0          not null,
  T1Done        nvarchar(4),
  PEmailC       nvarchar(255),
  T2Books       date,
  FName         nvarchar(98),
  MStatus       smallint,
  Citizen       bit constraint DF_Persons_Citizen default 0,
  DepQty        smallint,
  SPID          nvarchar(10),
  LoginName     nvarchar(64),
  LoginPW       nvarchar(64),
  WebAccess     bit constraint DF_Persons_WebAccess default 0
)
go

