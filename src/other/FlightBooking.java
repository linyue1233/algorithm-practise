package other;

public class FlightBooking {
    // 1109 difference method
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for(int[] item : bookings){
            ans[item[0]-1] += item[2];
            if(item[1] < n){
                ans[item[1]] -= item[2];
            }
        }

        for(int i = 1;i<n;++i){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
