class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posSpeedMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            posSpeedMap.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        Stack<Double> stack = new Stack<>();
        for(int i = position.length - 1; i >= 0; i--){
            int pos = position[i];
            int spd = posSpeedMap.get(pos);
            double time = (double)(target - pos) / spd;

            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time); // New fleet
            }
        }

        return stack.size();
    }
}

// hash map is used to tie all positions to speed
// position is sorted so that greater positions are compared to lesser
// stack stores values of time to compare against cars
// the loop finds that the time it takes a car to reach target 
// if the car reaches the target in a time less then the current stack value nothing is done
// in the case where it is slower the time is pushed to the stack
// the stack represents fleets if a car fails to catch up mathematically to its led
// a new fleet is generated