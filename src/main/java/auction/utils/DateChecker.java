package auction.utils;

import auction.model.ArticleInfo;
import auction.model.Date;
import auction.model.Time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <h1>Date Checker</h1>
 * Is a utility class used used to formulate Date queries.
 *
 * @author Cosimo Russo
 * @version 1.0
 */
public class DateChecker
{
    /**
     * Checks if the ending date and the ending time of the article is after the current time.
     *
     * @param  article  The ArticleInfo object which the date has to be checked.
     * @return true if the article is expired, false otherwise.
     * @see ArticleInfo
     */
    public static boolean isExpired(ArticleInfo article){
        LocalDateTime articleDateTime = LocalDateTime.of(article.getEndingDate().getYear(), article.getEndingDate().getMonth(),
                article.getEndingDate().getDay(), article.getEndingTime().getHour(), article.getEndingTime().getMinutes());
        return LocalDateTime.now(Clock.systemDefaultZone()).isAfter(articleDateTime);
    }//isExpired

    /**
     * Checks if the starting date and the starting time of the article is after the current time.
     *
     * @param  article  The ArticleInfo object which the date has to be checked.
     * @return true if the article is started, false otherwise.
     * @see ArticleInfo
     */
    public static boolean isStarted(ArticleInfo article){
        LocalDateTime articleDateTime = LocalDateTime.of(article.getStartingDate().getYear(), article.getStartingDate().getMonth(),
                article.getStartingDate().getDay(), article.getStartingTime().getHour(), article.getStartingTime().getMinutes());
        return LocalDateTime.now(Clock.systemDefaultZone()).isAfter(articleDateTime);
    }//isStarted

    /**
     * Given an article, it returns the time in seconds between the article (ending_date,ending_time)
     * and the current time.
     * It only works if the article is not expired.
     *
     * @param  article  The ArticleInfo object which the remaining time has to be calculated.
     * @return a long indicating the remaining time in seconds.
     * @see ArticleInfo
     */
    public static long getRemainingTimeInSeconds(ArticleInfo article){
        LocalDateTime articleExpireDate = LocalDateTime.of(article.getEndingDate().getYear(), article.getEndingDate().getMonth(),
                article.getEndingDate().getDay(), article.getEndingTime().getHour(), article.getEndingTime().getMinutes());
        return ChronoUnit.SECONDS.between(LocalDateTime.now(Clock.systemDefaultZone()),articleExpireDate);
    }//getRemainingTimeInSeconds

    /**
     * It returns a formatted representation of the received date and time.
     *
     * @param  date  The date to format.
     * @param  time  The time to format.
     * @return A LocalDateTime representation of the parameters.
     * @see LocalDateTime
     */
    public static LocalDateTime getLocalDateTime(Date date, Time time){
        return LocalDateTime.of(date.getYear(),date.getMonth(), date.getDay(), time.getHour(), time.getMinutes());
    }//getLocalDateTime
}//DateChecker
