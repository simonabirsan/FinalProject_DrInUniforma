package POJO;

public class LoginModel {
    private AccountModel account;
    private String loginError;
    private String validationMessage;

    public LoginModel() {
    }

    public LoginModel(String username, String password, String loginError, String validationMessage) {
        this.account = new AccountModel(username, password);
        this.loginError = loginError;
        this.validationMessage= validationMessage;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    @Override
    public String toString() {
        return "LoginModel value: {\n " +
                "account:{\n \t email: " + account.getEmail() + "," +
                "\n \t password: " + account.getPassword() +
                "\n}, \n loginError: " + loginError +
                "\n validationMessage: " + getValidationMessage() +
                "\n }";
    }
}
