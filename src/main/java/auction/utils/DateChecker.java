package auction.utils;

import auction.model.ArticleInfo;
import auction.model.Date;
import auction.model.Time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateChecker
{
    public static boolean isExpired(ArticleInfo article){
        LocalDateTime articleDateTime = LocalDateTime.of(article.getEndingDate().getYear(), article.getEndingDate().getMonth(),
                article.getEndingDate().getDay(), article.getEndingTime().getHour(), article.getEndingTime().getMinutes());
        return LocalDateTime.now(Clock.systemDefaultZone()).isAfter(articleDateTime);
    }//isExpired

    public static boolean isStarted(ArticleInfo article){
        LocalDateTime articleDateTime = LocalDateTime.of(article.getStartingDate().getYear(), article.getStartingDate().getMonth(),
                article.getStartingDate().getDay(), article.getStartingTime().getHour(), article.getStartingTime().getMinutes());
        return LocalDateTime.now(Clock.systemDefaultZone()).isAfter(articleDateTime);
    }//isStarted

    public static long getRemainingTimeInSeconds(ArticleInfo article){
        LocalDateTime articleExpireDate = LocalDateTime.of(article.getEndingDate().getYear(), article.getEndingDate().getMonth(),
                article.getEndingDate().getDay(), article.getEndingTime().getHour(), article.getEndingTime().getMinutes());
        return ChronoUnit.SECONDS.between(LocalDateTime.now(Clock.systemDefaultZone()),articleExpireDate);
    }//getRemainingTimeInSeconds

    public static LocalDateTime getLocalDateTime(Date date, Time time){
        return LocalDateTime.of(date.getYear(),date.getMonth(), date.getDay(), time.getHour(), time.getMinutes());
    }//getLocalDateTime
}//DateChecker
