package auction.controller;

import auction.model.ArticleInfo;
import auction.model.ArticleType;
import auction.model.Date;
import auction.model.Time;
import auction.model.auctions.AuctionInfo;
import auction.search.SearchInfo;
import auction.service.ArticleClient;
import auction.utils.ConsistencyChecker;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class ClientController extends AbstractController
{
    private ArticleClient articleClient;
    private final String ip;
    private String username = null;

    public ClientController() throws IOException {
        ip = "0.0.0.0";
    }

    public boolean createArticle(ArticleInfo info){
        if( !ConsistencyChecker.isArticleInfoConsistent(info) ) return false;
        boolean upshot = articleClient.createArticle(info);
        if( upshot ) System.out.println("Article loaded");
        else System.out.println("Something went wrong while trying to load the article");
        return upshot;
    }//createArticle

    public Collection<ArticleInfo> searchArticles(SearchInfo searchInfo){
        return articleClient.searchArticle(searchInfo);
    }//searchArticles

    public Collection<AuctionInfo> getOwnedAuctions(){
        return articleClient.getOwnedAuctions();
    }//getOwnedAuctions

    public Collection<AuctionInfo> getUserActiveAuctions(){
        return articleClient.getUserActiveAuctions();
    }//getUserActiveAuctions

    public Collection<ArticleInfo> getRegisteredAuctions(){
        return articleClient.getRegisteredAuctions();
    }//getRegisteredAuctions

    public boolean registerToTheAuction( int auctionId ){
        boolean upshot = articleClient.registerToTheAuction(auctionId);
        if( upshot ) System.out.println("Registration successful");
        else System.out.println("Something went wrong with registration..");
        return upshot;
    }//registerToTheAuction

    public void updateOffer(AuctionInfo info){
        notifyListeners(info);
    }//updateOffer

    public boolean makeOffer(int auctionId, double amount){
        boolean upshot = articleClient.makeOffer(auctionId,amount);
        if( upshot ) System.out.println("The offer was accepted");
        else System.out.println("The offer was refused");
        return upshot;
    }//makeOffer

    public Collection<AuctionInfo> getClosedAuctions(){
        return articleClient.getClosedAuctions();
    }//getClosedAuctions

    public boolean buyNow(int auctionId){
        boolean upshot = articleClient.buyNow(auctionId);
        if( upshot ) System.out.println("Article "+auctionId+" bought");
        else System.out.println("Unable to buy now article  "+auctionId);
        return upshot;
    }//buyNow

    public void setUsername(String username) throws IOException {
        this.username = username;
        Random rand = new Random();
        int clientPort = rand.nextInt(65536);
        articleClient = new ArticleClient("0.0.0.0", 8080,username,clientPort, ip,this);
    }//setUsername

    public String getUsername(){
        return username;
    }//getUsername

    private static void printArticleInfo(ArticleInfo info ){
        StringBuilder sb = new StringBuilder();
        sb.append(info.getEndingDate().getYear());
        sb.append("/");
        sb.append(info.getEndingDate().getMonth());
        sb.append("/");
        sb.append(info.getEndingDate().getDay());
        String date = sb.toString();
        System.out.format("Article with id %d:\n" +
                        "Name: %s\nEnding date: %s\nType: %s\nDescription: %s\n\n",
                info.getId(), info.getName(), date, info.getType(), info.getDescription());
    }

    private static void printAuctionInfo( AuctionInfo info ){
        System.out.format("Article with id %d:\n" +
                        "Name: %s\nFinal price: %.2f\nWinner: %s\n\n",
                info.getArticleId(), info.getArticleName(), info.getCurrentOffer(), info.getCurrentWinner());
    }

    private static ArticleInfo createArticleTest(){
        Date sDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(11).build();
        Date eDate = Date.newBuilder().setYear(2023).setMonth(5).setDay(12).build();
        Time sTime = Time.newBuilder().setHour(8).setMinutes(20).build();
        Time eTime = Time.newBuilder().setHour(12).setMinutes(0).build();
        ArticleInfo info = ArticleInfo.newBuilder().setName("Prova").setStartingDate(sDate).setEndingDate(eDate).setStartingTime(sTime).setEndingTime(eTime)
                .setStartingPrice(1.50).setBuyNowPrice(1.0).setType(ArticleType.BOOKS).setDescription("Test description").build();
        return info;
    }//createArticleTest

    private static SearchInfo searchArticleTest(){
        return SearchInfo.newBuilder().setName("pallina").setMaxPrice(10000).build();
    }//searchArticleTest

    private void activeAuctionsTest(Collection<ArticleInfo> auctions){
        System.out.println("Active auctions:");
        for( ArticleInfo info : auctions ) printArticleInfo(info);
    }//activeAuctionsTest

    private void registeredAuctionsTest(Collection<ArticleInfo> auctions){
        System.out.println("Registered auctions:");
        for( ArticleInfo info : auctions ) printArticleInfo(info);
    }//registeredAuctionsTest

    private void closedAuctionsTest(Collection<AuctionInfo> auctions){
        System.out.println("Expired auctions:");
        for( AuctionInfo info : auctions ) printAuctionInfo(info);
    }//closedAuctionsTest

    private void makeOfferTest(Scanner sc, int auctionId, ClientController client){
        double offer = 0;
        while( offer>-1 ){
            System.out.print('>');
            offer = sc.nextDouble();
            client.makeOffer(auctionId,offer);
        }
    }//MakeOfferTest

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire username:");
        System.out.print('>');
        String username = sc.nextLine();
        ClientController client = new ClientController();

        //client.registerToTheAuction(1);
        //sc.nextInt();
        //client.buyNow(1);
        client.closedAuctionsTest(client.getClosedAuctions());


        //client.makeOfferTest(sc,1,client);
        //client.createArticle(createArticleTest());
        //client.searchArticle(searchArticleTest());
        //client.getOwnedAuctions();
        //client.registerToTheAuction(0);
        //client.getUserActiveAuctions();
        //for( ArticleInfo info : client.getRegisteredAuctions() )
        //    client.printArticleInfo(info);
    }//main
}//ClientController
