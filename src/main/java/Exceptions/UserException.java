package Exceptions;

public class UserException extends Exception{

UserExceptionCode userExceptionCode;

    public enum UserExceptionCode {
        USER_EXISTS(1,"User exists"),
        USER_UPDATE_ERROR(2,"Update of user failed");

        int code;

        UserExceptionCode(int code, String s) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }


    public UserException() {}

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, UserExceptionCode userExceptionCode) {
        super(message);
        this.userExceptionCode = userExceptionCode;
    }



}
