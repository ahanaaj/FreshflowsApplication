package com.freshflows.objects;

public class functions  {
    public functions()
    {}
    private String mail;

    public String getMail() {
        return mail;
    }
    public functions setMail(String mail) {
        this.mail = mail;
        return this;
    }


    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String shortEmail;
    public String getShortEmail() {
        return shortEmail;
    }

    public void setShortEmail(String shortEmail) {
        this.shortEmail = shortEmail;
    }
    private String shortPassword;
    public String getShortPassword() {
        return shortPassword;
    }
    public void setShortPassword(String shortPassword) {
        this.shortPassword = shortPassword;
    }

    private String invalidEmail;
    public String getInvalidEmail() {
        return invalidEmail;
    }
    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    private String longPassword;
    public String getLongPassword() {
        return longPassword;
    }
    public void setLongPassword(String longPassword) {
        this.longPassword = longPassword;
    }

    private String validEmail;
    public String getValidEmail() {
        return validEmail;
    }
    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    private String validPswd;
    public String getValidPswd() {
        return validPswd;
    }
    public void setValidPswd(String validPswd) {
        this.validPswd = validPswd;
    }

    private String shortPswdErrorMsg;
    public String getShortPswdErrorMsg() {
        return shortPswdErrorMsg;
    }
    public void setShortPswdErrorMsg(String shortPswdErrorMsg) {
        this.shortPswdErrorMsg = shortPswdErrorMsg;
    }

    private String shortEmailErrorMsg;
    public String getShortEmailErrorMsg() {
        return shortEmailErrorMsg;
    }
    public void setShortEmailErrorMsg(String shortEmailErrorMsg) {
        this.shortEmailErrorMsg = shortEmailErrorMsg;
    }

    public functions(String mail, String password) {
        this.mail = mail;
        this.password = password;

    }


    private String passd;
    public String getPassd() {
        return password;
    }
    public functions setPassd(String passd) {
        this.password = passd;
        return this;
    }

    private String workspaceName;
    public String getWorkspaceName() {
        return workspaceName;
    }
    public functions setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
        return this;
    }


}
