package auction.controller;

import auction.model.ArticleInfo;
import auction.service.AdminClient;

import java.io.IOException;
import java.util.Collection;

public class AdminController
{
    private AdminClient adminClient;

    public AdminController() throws IOException {
        adminClient = new AdminClient("0.0.0.0", 8080);
    }

    public boolean deleteArticle(int id){
        boolean upshot = adminClient.deleteArticle(id);
        if( upshot ) System.out.println("Article deleted");
        else System.out.println("Something went wrong while trying to delete the article");
        return upshot;
    }//deleteArticle

    public Collection<ArticleInfo> getArticles(){
        return adminClient.getArticles();
    }//getArticles
}//AdminController
