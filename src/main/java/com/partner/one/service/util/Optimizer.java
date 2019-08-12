package com.partner.one.service.util;

import com.partner.one.service.models.CleanRequest;
import com.partner.one.service.models.CleanResponse;

import java.util.ArrayList;
import java.util.List;

public class Optimizer {


    public static List<CleanResponse> optimizeWorkforce(CleanRequest request) {
        System.out.println(request.toString());
        List<CleanResponse> cleanResponseList = new ArrayList<>();
        //conditions for capacity
        //senior cleaners have more cleaning capacity than junior cleaners
        if(request.getSenior() < request.getJunior()) {
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
            if(rooms.get(i) > 100) {
                gtHundred++;
            }
        }
        if(gtHundred > 0) {
            return null;
        }

        for(int i = 0; i < rooms.size(); i++) {
             int noOfRooms = rooms.get(i);
            //assumptions for optimization, at least one senior at every room
            System.out.println(noOfRooms);
            CleanResponse response = new CleanResponse();
            int snrRequired = noOfRooms % request.getSenior();
            cleanResponseList.add(response);
        }
        return cleanResponseList;
    }
}
