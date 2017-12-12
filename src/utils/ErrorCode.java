package utils;

import java.util.HashMap;

public class ErrorCode {
    private int errorCode = 0;

    private static final int MAX_ERROR_NUMBER = 32;
    public static final int CANNOT_GET_CONNECTION = 1;
    public static final int UPDATE_ERROR = 2;
    public static final int CANNOT_CLOSE_STATEMENT = 4;
    public static final int CANNOT_CLOSE_CONNECTION = 8;
    public static final int INSERT_ERROR = 16;
    public static final int LOGIN_ERROR = 32;

    private final String[] errorName = {
            "CANNOT_GET_CONNECTION",
            "UPDATE_ERROR",
            "CANNOT_CLOSE_STATEMENT",
            "CANNOT_CLOSE_CONNECTION",
            "INSERT_ERROR",
            "LOGIN_ERROR"
    };

    private final String[] errorExpression = {
            "cannot get connection",
            "update user error",
            "cannot close statement",
            "cannot close connection",
            "cannot insert the new user",
            "login error"
    };

    private int getIndex(int state) {
        int index = 0;
        for (state >>= 1; state > 0; state >>= 1) {
            index++;
        }
        return index;
    }

    public void setErrorState(int state) {
        errorCode |= state;
    }

    public HashMap<String, String> parseErrorCode() {
        if (errorCode == 0) return null;
        HashMap<String, String> map = new HashMap<>();
        for (int i = 1; i <= MAX_ERROR_NUMBER; i <<= 1) {
            if ((errorCode & i) != 0) {
                int index = getIndex(i);
                map.put(errorName[index], errorExpression[index]);
            }
        }
        return map;
    }

}
