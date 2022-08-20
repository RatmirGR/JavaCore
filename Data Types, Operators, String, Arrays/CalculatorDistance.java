/* пример использования целочисленных типов*/
enum Type{
    SECOND, MINUTE, HOUR, DAY
}

class CalculatorDistance {
    public static final int LIGHT_SPEED_KM = 300000;
    public static final int SECOND = 60;
    public static final int MINUTE = 60;
    public static final int HOUR = 60;

    public static void main(String[] args) {
        long second = 6205;
        calculate(second, Type.SECOND);

        long minutes = 200;
        calculate(minutes, Type.MINUTE);

        long hour = 12;
        calculate(hour, Type.HOUR);

        long day = 25;
        calculate(day, Type.DAY);
    }

    static void calculate(long time, Type type){
        String resTime = convertFormatOutput(time);
        String distance = null;
        String text = null;

        switch (type.toString()){
            case "SECOND":
                text = textSecTime(time);
                distance = convertFormatOutput(LIGHT_SPEED_KM * time);
                break;
            case "MINUTE":
                text = textMinTime(time);
                distance = convertFormatOutput(LIGHT_SPEED_KM * (time * SECOND));
                break;
            case "HOUR":
                text = textHourTime(time);
                distance = convertFormatOutput(LIGHT_SPEED_KM * (time * SECOND * MINUTE));
                break;
            case "DAY":
                text = textDayTime(time);
                distance = convertFormatOutput(LIGHT_SPEED_KM * (time * SECOND * MINUTE * HOUR));
        }
        printResult(resTime, text, distance);
    }

    private static String textSecTime(long sec) {
        if (sec % 10 == 1 && sec != 11) return "секунду";
        else if ((sec % 10 == 2 && sec != 12) ||
                (sec % 10 == 3 && sec != 13) ||
                (sec % 10 == 4 && sec != 14)) return "секунды";
        return "секунд";
    }

    private static String textMinTime(long min) {
        if (min % 10 == 1 && min != 11) return "минуту";
        else if ((min % 10 == 2 && min != 12) ||
                (min % 10 == 3 && min != 13) ||
                (min % 10 == 4 && min != 14)) return "минуты";
        return "минут";
    }

    private static String textHourTime(long hour) {
        if (hour % 10 == 1 && hour != 11) return "час";
        else if ((hour % 10 == 2 && hour != 12) ||
                (hour % 10 == 3 && hour != 13) ||
                (hour % 10 == 4 && hour != 14)) return "часа";
        return "часов";
    }

    private static String textDayTime(long day) {
        if (day % 10 == 1 && day != 11) return "день";
        else if ((day % 10 == 2 && day != 12) ||
                (day % 10 == 3 && day != 13) ||
                (day % 10 == 4 && day != 14)) return "дня";
        return "дней";
    }

    private static String convertFormatOutput(long time) {
        String str = String.valueOf(time);
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (count == 3) {
                result.append(".");
                count = 0;
            }
            count++;
            result.append(str.charAt(i));
        }
        return new StringBuffer(result.toString()).reverse().toString();
    }

    private static void printResult(String time, String format, String distance) {
        System.out.printf("За %s %s свет пройдет около %s километров.\n", time, format, distance);
    }
}
