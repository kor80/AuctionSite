package auction.utils;

import auction.managment.ArticleInfo;

import java.util.LinkedList;

public class ConsistencyChecker
{
    public static boolean isArticleInfoConsistent(ArticleInfo info){
        if( !ConsistencyChecker.areDatesConsistent(info) ) return false;
        if( info.getStartingPrice() < 0 ) return false;
        if( info.getBuyNowPrice() < 0 ) return false;
        return true;
    }//isArticleInfoConsistent

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

    public static boolean isNumber(String text){
        return text.matches("[0-9]+");

    }
}//ConsistencyChecker
