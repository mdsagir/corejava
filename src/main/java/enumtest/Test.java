package enumtest;

enum Week {
    SUNDAY(1), MONDAY(2), TUESDAY(3);

    private int value;

    Week(int value) {
        this.value = value;
    }

//
}

public class Test {
    public static void main(String[] args) {
        Week[] values = Week.values();
        for (Week  week:values){
           // System.out.println(week);
        }

        Week sunday = Week.SUNDAY;


        switch (sunday){
            case MONDAY:
                System.out.println(Week.MONDAY);
                break;
            case SUNDAY:
                System.out.println(Week.SUNDAY.values());
        }

    }
}


