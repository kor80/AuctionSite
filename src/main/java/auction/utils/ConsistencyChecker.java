package auction.utils;

import auction.controller.ClientController;
import auction.model.ArticleInfo;
import auction.model.auctions.AuctionInfo;

import javax.swing.*;
import java.util.LinkedList;

/**
 * <h1>Consistency Checker</h1>
 * Is a utility class used to check the consistency of articles and dates.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class ConsistencyChecker
{
    /**
     * Checks the cosistency of the specified ArticleInfo.
     *
     * @param  info  The ArticleInfo object which the consistency has to be checked.
     * @return true if the article is consistent, false otherwise.
     * @see ArticleInfo
     */
    public static boolean isArticleInfoConsistent(ArticleInfo info){
        if( !ConsistencyChecker.areDatesConsistent(info) ) return false;
        if( info.getStartingPrice() < 0 ) return false;
        if( info.getBuyNowPrice() < 0 ) return false;
        return true;
    }//isArticleInfoConsistent

    /**
     * Checks the cosistency of the specified dates.
     * Two dates Ds and De are consistent only if:
     * - Ds is chronologically before De.
     * - Ds is chronologically after the current time.
     * - De is chronologically after the current time.
     * - Dx month is coherent with Dx day (es. month=february and day=31 are not coherent).
     *
     * @param  info  The ArticleInfo object which the date consistency has to be checked.
     * @return true if the dates are consistent, false otherwise.
     * @see ArticleInfo
     */
    private static boolean areDatesConsistent(ArticleInfo info){
        if( DateChecker.isExpired(info) ) return false;
        if( DateChecker.isStarted(info) ) return false;
        if( DateChecker.getLocalDateTime(info.getEndingDate(),info.getEndingTime())
                .isBefore(DateChecker.getLocalDateTime(info.getStartingDate(),info.getStartingTime())))
            return false;

        LinkedList<Integer> thirtyDaysMonths = new LinkedList<>();
        thirtyDaysMonths.add(4);
        thirtyDaysMonths.add(6);
        thirtyDaysMonths.add(9);
        thirtyDaysMonths.add(11);
        if( (info.getStartingDate().getDay() == 31 && thirtyDaysMonths.contains(info.getStartingDate().getMonth()))
            || (info.getEndingDate().getDay() == 31 && thirtyDaysMonths.contains(info.getEndingDate().getMonth())))
            return false;

        if( (info.getStartingDate().getDay() > 28 && info.getStartingDate().getMonth() == 2 )
                || (info.getEndingDate().getDay() > 28 && info.getEndingDate().getMonth() == 2 ))
            return false;

        return true;
    }

    /**
     * Checks is the username of the client that call this method is set.
     * If it is not set, an error dialogue will show up.
     *
     * @param  client A ClientController object pointing to the client that calls this method.
     * @return true if the user is set, false otherwise.
     * @see ClientController
     */
    public static boolean isUserSet(ClientController client){
        if( client.getUsername() == null ){
            JOptionPane.showMessageDialog(null,
                    "Devi prima inserire un username nella pagina account.", "Errore", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }//isUserSet
}//ConsistencyChecker
