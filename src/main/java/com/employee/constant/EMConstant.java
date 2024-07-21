package com.employee.constant;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EMConstant {
	public static final Timestamp CURRENT_TIME = Timestamp.valueOf(LocalDateTime.now());
    public static final String YES_FLAG = "Y";
    public static final String CALL_RESULT_FAILURE = "Failure";
}
