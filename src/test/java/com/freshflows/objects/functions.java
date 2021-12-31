package com.freshflows.objects;

public class functions  {

    private String mail;
    private String password;
    private String workspaceName;

    public functions()
    {

    }
    public functions(String mail, String password) {
        this.mail = mail;
        this.password = password;

    }

    public String getMail() {
        return mail;
    }

    public functions setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getPassd() {
        return password;
    }

    public functions setPassd(String passd) {
        this.password = passd;
        return this;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public functions setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
        return this;
    }


}
