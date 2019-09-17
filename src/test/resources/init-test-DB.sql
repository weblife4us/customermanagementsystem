-- create table Persons
-- (
--   PID           nvarchar(10),
--   PName         nvarchar(100),
--   PAddress      ntext,
--   PICHID        nvarchar(10),
--   PPhone        nvarchar(150),
--   PEmail        nvarchar(255),
--   DOBDOI        datetime,
--   Gender        nvarchar(11),
--   Auth bit constraint DF_Persons_Authorization default 0 not null,
--   Gone          bit constraint DF_Persons_Gone default 0          not null,
--   T1Done        nvarchar(4),
--   PEmailC       nvarchar(255),
--   T2Books       date,
--   FName         nvarchar(98),
--   MStatus       smallint,
--   Citizen       bit constraint DF_Persons_Citizen default 0,
--   DepQty        smallint,
--   SPID          nvarchar(10),
--   LoginName     nvarchar(64),
--   LoginPW       nvarchar(64),
--   WebAccess     bit constraint DF_Persons_WebAccess default 0
-- );



INSERT INTO [customer_management].[dbo].[Persons] ([PID], [PName], [PAddress], [PICHID], [PPhone], [PEmail], [DOBDOI], [Gender], [Authorization], [Gone], [T1Done], [PEmailC], [T2Books], [FName], [MStatus], [Citizen], [DepQty], [SPID], [LoginName], [LoginPW], [WebAccess]) VALUES (''B701175127'', ''10344397 CANADA INC'', ''1504-55 WYNFORD HEIGHTS CRES.
TORONTO, ON  M3C 1L5'', ''S519106793'', ''2192215559'', ''test@yahoo.ca'', ''2017-08-01 00:00:00.000'', ''Corporation'', DEFAULT, DEFAULT, ''NULL'', ''NULL'', ''NULL'', ''NULL'', NULL, DEFAULT, NULL, ''NULL'', ''NULL'', ''NULL'', DEFAULT);
UPDATE [customer_management].[dbo].[Personsmvn clean ] SET [Authorization] = DEFAULT, [Citizen] = DEFAULT, [WebAccess] = DEFAULT WHERE [PID] LIKE ''B701175127'' ESCAPE ''#'' AND [PName] LIKE ''10344397 CANADA INC'' ESCAPE ''#'' AND [PAddress] LIKE ''1504-55 WYNFORD HEIGHTS CRES.
TORONTO, ON  M3C 1L5'' ESCAPE ''#'' AND [PICHID] LIKE ''S519106793'' ESCAPE ''#'' AND [PPhone] LIKE ''2192215559'' ESCAPE ''#'' AND [PEmail] LIKE ''test@yahoo.ca'' ESCAPE ''#'' AND [DOBDOI] = ''2017-08-01 00:00:00.000'' AND [Gender] LIKE ''Corporation'' ESCAPE ''#'' AND [Authorization] = 0 AND [Gone] = 0 AND [T1Done] IS NULL AND [PEmailC] IS NULL AND [T2Books] IS NULL AND [FName] IS NULL AND [MStatus] IS NULL AND [Citizen] = 0 AND [DepQty] IS NULL AND [SPID] IS NULL AND [LoginName] IS NULL AND [LoginPW] IS NULL AND [WebAccess] = 0 AND %%physloc%% = 0x7001000001000000;
INSERT INTO [customer_management].[dbo].[Persons] ([PID], [PName], [PAddress], [PICHID], [PPhone], [PEmail], [DOBDOI], [Gender], [Authorization], [Gone], [T1Done], [PEmailC], [T2Books], [FName], [MStatus], [Citizen], [DepQty], [SPID], [LoginName], [LoginPW], [WebAccess]) VALUES (''S519106793'', ''JARINOV VIKTOR'', ''415-1875 STEELES AVE WEST'', ''S519106793'', ''4169499869'', ''test@yahoo.ca'', ''1961-08-17 00:00:00.000'', ''Male'', 1, 1, ''2016'', '''', ''NULL'', ''NULL'', NULL, DEFAULT, NULL, ''NULL'', ''NULL'', ''NULL'', DEFAULT);
INSERT INTO [customer_management].[dbo].[Persons] ([PID], [PName], [PAddress], [PICHID], [PPhone], [PEmail], [DOBDOI], [Gender], [Authorization], [Gone], [T1Done], [PEmailC], [T2Books], [FName], [MStatus], [Citizen], [DepQty], [SPID], [LoginName], [LoginPW], [WebAccess]) VALUES (''S730913779'', ''STARITSINA GALINA'', ''110-383 PRINCE OF WALES DR'', ''S730913761'', ''5143494555'', ''test@yahoo.ca'', ''1969-04-16 00:00:00.000'', ''Female'', DEFAULT, DEFAULT, ''2014'', ''NULL'', ''NULL'', ''NULL'', NULL, DEFAULT, NULL, ''NULL'', ''NULL'', ''NULL'', DEFAULT);
