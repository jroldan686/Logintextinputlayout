package deint.jroldan.loginrelative;

/**
 * Created by usuario on 6/10/16.
 */
public interface ILoginMvp {

    //public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;
    public static final int DATA_EMPTY = 4;

    interface View{
        public void setMessageError(String messageError, int idView);
    }

    interface Presenter{
        public void validateCredentials(String user, String password);
    }
}
