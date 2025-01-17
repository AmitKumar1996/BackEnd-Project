SELECT u1_0.id,
		u1_0.clazz_,
		u1_0.email,
		u1_0.name,
		u1_0.average_rating,
		u1_0.atandance,
		u1_0.psp
FROM
	(SELECT id,
		 email,
		 name,
		 NULL AS average_rating,
		 NULL AS atandance,
		 NULL AS psp,
		 0 AS clazz_
	FROM tpc_user
	UNION
	allSELECT id,
		 email,
		 name,
		 average_rating,
		 NULL AS atandance,
		 NULL AS psp,
		 1 AS clazz_
	FROM tpc_mentor
	UNION
	allSELECT id,
		 email,
		 name,
		 NULL AS average_rating,
		 atandance,
		 psp,
		 2 AS clazz_
	FROM tpc_student
	UNION
	allSELECT id,
		 email,
		 name,
		 average_rating,
		 NULL AS atandance,
		 NULL AS psp,
		 3 AS clazz_
	FROM tpc_ta) u1_0