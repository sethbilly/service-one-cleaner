package com.partner.one.service.util;

import com.partner.one.service.models.CleanRequest;
import com.partner.one.service.models.CleanResponse;

import java.util.ArrayList;
import java.util.List;


//Utility class for performing optimization
public class Optimizer {

    // Constant upper bound on rooms
    private static final int MAX_ROOMS = 100;

    public static List<CleanResponse> optimizeWorkforce(CleanRequest request) {
        //senior cleaner capacity
        int snrCapacity = request.getSenior();
        //junior cleaner capacity
        int jnrCapacity = request.getJunior();

        //conditions for capacity
        //senior cleaners have more cleaning capacity than junior cleaners
        if(snrCapacity < jnrCapacity) {
            //return error response here
            return null;
        }
        //condition for room capacity
        //structure cannot have more than 100 rooms
        //array of rooms cannot be empty
        List<Integer> rooms = request.getRooms();
        if(rooms.isEmpty()) {
            return null;
        }

        int gtHundred = 0;
        for(int i = 0; i < rooms.size(); i++){
            if(rooms.get(i) > MAX_ROOMS) {
                gtHundred++;
            }
        }
        if(gtHundred > 0) {
            return null;
        }

        // assuming we are deploying only seniors,
        // then given the max number of rooms
        // we can get an upper bound onf the number of seniors
        double maxSnr = Math.ceil(MAX_ROOMS * 1.0 / snrCapacity);

        // there must be at least one senior, so the lower bound on senior cleaner
        int minSnr = 1;

        // for junior cleaners, we get upper and lower bounds
        double maxJnr = Math.ceil(MAX_ROOMS * 1.0 / jnrCapacity);
        int minJnr = 0;

        // foreach room keyed by the variable i
        // we iterate from minSnr to maxSnr and determine a 'j' that satisfies constraints
        // snrCapacity * s + jnrCapacity * j >= rooms[i]
        // while maximizing the objective function
        // Z = snrCapacity * s + jnrCapacity * j
        List<CleanResponse> cleanResponseList = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++) {
            int Z = Integer.MAX_VALUE; // initializing with an arbitrarily large value
            int snrOptimal = minSnr;
            int jnrOptimal = minJnr;

            for(int s = minSnr; s < maxSnr; s++) {
                // making j subject of constraint we get j >= (rooms[i] - sCapacity * s) / jCapacity
                int j = (int)Math.ceil((rooms.get(i) - snrCapacity * s) * 1.0 / jnrCapacity);
                // check if all constraints are satisfied before moving on
                if (!(j >= minJnr && s >= minSnr && j <= maxJnr && s <= maxSnr && (snrCapacity * s + jnrCapacity * j >= rooms.get(i))))
                {
                    continue;
                }

                int objective = snrCapacity * s + jnrCapacity * j;

                // if current solution results in a lower objective function evaluation, then current solutions is best
                if (objective < Z)
                {
                    Z = objective;
                    snrOptimal = s;
                    jnrOptimal = j;
                }

            }
            CleanResponse response = new CleanResponse();
            response.setSenior(snrOptimal);
            response.setJunior(jnrOptimal);
            cleanResponseList.add(response);
        }
        return cleanResponseList;
    }
}
