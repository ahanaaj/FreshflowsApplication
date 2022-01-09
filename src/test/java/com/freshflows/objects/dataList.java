package com.freshflows.objects;

import com.freshflows.utils.Jacksonutil;

import java.io.IOException;

public class dataList {

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String mail;
    private String password;

    public dataList(){}

    public dataList(String mail, String password) throws IOException {
        dataList[] dataLists = Jacksonutil.fnJson("datafile.json", dataList[].class);
        for(dataList list : dataLists)
        {
            if(list.getMail() == mail)
            {
                this.mail = mail;
                this.password = password;
            }
        }
    }

}
