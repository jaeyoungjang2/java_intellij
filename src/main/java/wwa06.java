public class wwa06 {

    public static void main(String[] args) {
        double time = 3.5;
//        String[][] plans =  {{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}};
        String[][] plans =  {{"홍콩", "11PM", "9AM"}, {"엘에이", "7PM", "2PM"}};
        String answer = "호치민";

        int fridayOffTime = 6;
        int mondayOnTime = 1;
        for (String[] plan: plans) {
            String city = plan[0];
            String start = plan[1];
            String end = plan[2];

            Integer startTime = Integer.parseInt(start.substring(0, start.length() - 2));
            Integer endTime = Integer.parseInt(end.substring(0, end.length() - 2));

            // 금요일 여행 출발
            if (start.endsWith("PM") && startTime < fridayOffTime) {
                // 금요일 오후, 퇴근 시간 전에 휴가를 갈 경우
                Integer minusVacationTime = fridayOffTime - startTime;
                time -= minusVacationTime;

            } else if (start.endsWith("AM")) {
                // 금요일 오전에 휴가를 갈 경우
                if (startTime <= 9) {
                    // 출근 시간 전에 휴가를 갈 경우
                    Double minusVacationTime = 12 - 9.5 + fridayOffTime;
                    time -= minusVacationTime;
                } else {
                    // 출근 이후에 휴가를 갈 경우
                    Integer minusVacationTime = 12 - startTime + fridayOffTime;
                    time -= minusVacationTime;
                }

            }

            // 월요일 여행 도착시간이 출근 시간보다 늦을 경우
            if (end.endsWith("PM") && endTime > mondayOnTime) {
                Integer minusVacationTime = endTime - mondayOnTime;
                time -= minusVacationTime;
            }
            if (time < 0) {
                break;
            }
            answer = city;
        }
        System.out.println(answer);
        System.out.println(time);
    }
}
