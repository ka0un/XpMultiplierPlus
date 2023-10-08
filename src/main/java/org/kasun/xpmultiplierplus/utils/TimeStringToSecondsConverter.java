package org.kasun.xpmultiplierplus.Utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeStringToSecondsConverter {

    public static long convertToSeconds(String timeString) {
        if (timeString == null || timeString.isEmpty()) {
            throw new IllegalArgumentException("Input time string is null or empty.");
        }

        // Remove spaces and convert to upper case
        timeString = timeString.replaceAll("\\s", "").toUpperCase();

        Pattern pattern = Pattern.compile("(\\d+)([YMDHMS])");
        Matcher matcher = pattern.matcher(timeString);

        long totalSeconds = 0;
        while (matcher.find()) {
            int value = Integer.parseInt(matcher.group(1));
            char unit = matcher.group(2).charAt(0);

            switch (unit) {
                case 'Y':
                    totalSeconds += value * 365 * 24 * 60 * 60;  // Assume 1 year = 365 days
                    break;
                case 'M':
                    totalSeconds += value * 30 * 24 * 60 * 60;  // Assume 1 month = 30 days
                    break;
                case 'D':
                    totalSeconds += value * 24 * 60 * 60;
                    break;
                case 'H':
                    totalSeconds += value * 60 * 60;
                    break;
                case 'N': // Handling lowercase 'm' as minutes
                case 'I':
                    totalSeconds += value * 60;
                    break;
                case 'S':
                    totalSeconds += value;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown time unit: " + unit);
            }
        }

        return totalSeconds;
    }

    public static String convertToTimeString(long totalSeconds) {
        long years = totalSeconds / (365 * 24 * 60 * 60);
        totalSeconds %= (365 * 24 * 60 * 60);

        long months = totalSeconds / (30 * 24 * 60 * 60);
        totalSeconds %= (30 * 24 * 60 * 60);

        long days = totalSeconds / (24 * 60 * 60);
        totalSeconds %= (24 * 60 * 60);

        long hours = totalSeconds / (60 * 60);
        totalSeconds %= (60 * 60);

        long minutes = totalSeconds / 60;
        totalSeconds %= 60;

        StringBuilder result = new StringBuilder();

        if (years > 0)
            result.append(years).append("Y ");

        if (months > 0)
            result.append(months).append("M ");

        if (days > 0)
            result.append(days).append("D ");

        if (hours > 0)
            result.append(hours).append("H ");

        if (minutes > 0)
            result.append(minutes).append("M ");

        if (totalSeconds > 0)
            result.append(totalSeconds).append("S ");

        return result.toString().trim();
    }

}