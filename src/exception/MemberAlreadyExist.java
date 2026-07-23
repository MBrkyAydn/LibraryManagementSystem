package exception;

public class MemberAlreadyExist extends RuntimeException {

    public MemberAlreadyExist(String message) {
        super(message);
    }
}
