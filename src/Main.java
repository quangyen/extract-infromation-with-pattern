import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String txtData = "agribank: 10h54p 23/05 tk 66666666666666: +4,997,800vnd mb(8888888). sd: 285,574,239vnd.";
        Pattern pattern = Pattern.compile("agribank:\\s(?<hour>\\d{1,2})h(?<minute>\\d{1,2})p\\s\\d{1,2}\\/\\d{1,2}\\stk\\s(?<account>\\d+):\\s\\+(?<amount>(\\d|\\,)+)vnd\\s(\\(tmn (?<agentId1>\\d+)\\)|mb\\((?<agentId2>\\d+)\\))\\.\\ssd\\:\\s(?<balance>(\\d|\\,)+)vnd\\.");
        Matcher matcher = pattern.matcher(txtData);
        while (matcher.find()) {
            System.out.printf("hour: %s\n",matcher.group("hour"));
            System.out.printf("minute: %s\n",matcher.group("minute"));
            System.out.printf("account: %s\n",matcher.group("account"));
            System.out.printf("amount: %s\n",matcher.group("amount"));
            System.out.printf("agentId1: %s\n",matcher.group("agentId1"));
            System.out.printf("agentId2: %s\n",matcher.group("agentId2"));
            System.out.printf("balance: %s\n",matcher.group("balance"));
        }

        txtData = "sinh 09/06/1990 Sinh ngay 01-11.2000. 09/06/1990";
        pattern = Pattern.compile("[^\\d]*(?<day>\\d{2})[\\/,\\.,\\-](?<month>\\d{2})[\\/,\\.,\\-](?<year>\\d{4})[^\\d]*");
        matcher = pattern.matcher(txtData);
        while (matcher.find()) {
            System.out.printf("day: %s\n",matcher.group("day"));
            System.out.printf("month: %s\n",matcher.group("month"));
            System.out.printf("year: %s\n",matcher.group("year"));
        }
    }
}
