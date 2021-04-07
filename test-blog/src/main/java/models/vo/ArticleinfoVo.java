package models.vo;

import Dao.ArticleinfoDao;
import models.Articleinfo;

public class ArticleinfoVo extends Articleinfo {
     private  String  username ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
