//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Scanner;
//
//public class GetAPI {
//
//    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
//        StringBuilder sURL = new StringBuilder("https://jsonmock.hackerrank.com/api/transactions/search?userId=" + uid);
//        String[] split = monthYear.split("-");
//        String srcOutput = getApiData(sURL.toString());
//        PageInfo c = mapHoldingToResponse(srcOutput);
//        List<Data> list = new ArrayList<>();
//        for (int i = 2; i <= c.total_pages; i++) {
//            String nextURL = getApiData("https://jsonmock.hackerrank.com/api/transactions/search?userId=" + uid + "&page=" + i);
//            PageInfo pageInfo = mapHoldingToResponse(nextURL);
//            Data[] data = pageInfo.getData();
//            for (int m = 0; m < data.length; m++) {
//                if (data[m].getTxnType().equals(txnType)) {
//                    Long timeStampMillis = data[m].getTimestamp();
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTimeInMillis(timeStampMillis);
//                    String year = String.valueOf(cal.get(Calendar.YEAR));
//                    String month = "0" + (cal.get(Calendar.MONTH) + 1);
//                    if (month.equals(split[0]) && year.equals(split[1])) {
//                        list.add(data[m]);
//                    }
//                }
//            }
//        }
//        int averageValue = 0;
//        for (int k = 0; k < list.size(); k++) {
//            Data data = list.get(k);
//            System.out.println(data.getId());
//            String[] split1 = data.getAmount().replace("$", "").replace(",", "").split("\\.");
//            averageValue += Integer.valueOf(split1[0]);
//        }
//        int total = averageValue / list.size();
//        System.out.println(total);
//        return null;
//    }
//
//    public static void main(String[] args) {
//        getUserTransaction(4, "debit", "02-2019");
//    }
//
//
////    public static PageInfo mapHoldingToResponse(String holdingResponse) {
////        try {
////            Gson gson = new GsonBuilder().create();
////            PageInfo r = gson.fromJson(holdingResponse, PageInfo.class);
////            return r;
////        } catch (Exception ex) {
////            System.out.println("error in holding gson parding =[" + ex + "]");
////        }
////        return null;
////    }
//
//
//    public static String getApiData(String urll) {
//        try {
//            URL url = new URL(urll);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.connect();
//            String inline = "";
//            Scanner scanner = new Scanner(url.openStream());
//            while (scanner.hasNext()) {
//                inline += scanner.nextLine();
//            }
//            scanner.close();
//            return inline;
//        } catch (Exception e) {
//            System.out.println("exception code =" + e);
//        }
//        return "";
//    }
//
//}
