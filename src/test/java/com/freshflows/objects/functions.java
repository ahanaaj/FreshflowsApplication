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

    private String verificationMail;

    public String getVerificationMail() {
        return verificationMail;
    }

    public void setVerificationMail(String verificationMail) {
        this.verificationMail = verificationMail;
    }

    private String password;
    private String shortEmail;
    private String shortPassword;
    private String invalidEmail;
    private String longPassword;
    private String validEmail;
    private String validPswd;
    private String shortPswdErrorMsg;
    private String shortEmailErrorMsg;
    private String passd;

    public String getVerificationMailSent() {
        return verificationMailSent;
    }

    public void setVerificationMailSent(String verificationMailSent) {
        this.verificationMailSent = verificationMailSent;
    }

    private String verificationMailSent;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getShortEmail() {
        return shortEmail;
    }

    public void setShortEmail(String shortEmail) {
        this.shortEmail = shortEmail;
    }
    public String getShortPassword() {
        return shortPassword;
    }
    public void setShortPassword(String shortPassword) {
        this.shortPassword = shortPassword;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }
    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

    public String getLongPassword() {
        return longPassword;
    }
    public void setLongPassword(String longPassword) {
        this.longPassword = longPassword;
    }

    public String getValidEmail() {
        return validEmail;
    }
    public void setValidEmail(String validEmail) {
        this.validEmail = validEmail;
    }

    public String getValidPswd() {
        return validPswd;
    }
    public void setValidPswd(String validPswd) {
        this.validPswd = validPswd;
    }

    public String getShortPswdErrorMsg() {
        return shortPswdErrorMsg;
    }
    public void setShortPswdErrorMsg(String shortPswdErrorMsg) {
        this.shortPswdErrorMsg = shortPswdErrorMsg;
    }

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
