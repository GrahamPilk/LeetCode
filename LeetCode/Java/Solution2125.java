public class Solution2125 {
    public int numberOfBeams(String[] bank) {
        int total = 0;
        int prevDeviceCount = 0;
        for(String row : bank) {
            int currDeviceCount = 0;
            for(char cell : row.toCharArray()) {
                if(cell == '1') {
                    currDeviceCount++;
                }
            }
            if (currDeviceCount > 0) {
                total += prevDeviceCount * currDeviceCount;
                prevDeviceCount = currDeviceCount;
            }
        }
        return total;
    }
}

/*
 * Goal: Return the total number of laser beams in the bank. 
 * Each device shoots to the next security device in the next row that has at least one device. 
 * Approach: 
 * - Initialize total beams to 0 and previous device count to 0.
 * - Iterate through each row in the bank:
 * - Count the number of devices (1s) in the current row.
 * - If the current row has devices, calculate the beams formed with the previous row's devices
 *   and update the total.
 * - Update the previous device count to the current row's device count.
 * - Return the total number of beams.
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the bank.
 * Space Complexity: O(1), as we are using a constant amount of extra space.
 */