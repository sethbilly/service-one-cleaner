package com.partner.one.service.util;

import com.partner.one.service.models.CleanRequest;
import com.partner.one.service.models.CleanResponse;

import java.util.ArrayList;
import java.util.List;

public class Optimizer {


    public static List<CleanResponse> optimizeWorkforce(CleanRequest request) {
        System.out.println(request.toString());
        //senior cleaner capacity
        int seniorCap = request.getSenior();
        //junior cleaner capacity
        int juniorCap = request.getJunior();
        List<CleanResponse> cleanResponseList = new ArrayList<>();
        //conditions for capacity
        //senior cleaners have more cleaning capacity than junior cleaners
        if(seniorCap < juniorCap) {
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
            System.out.println(noOfRooms);
            CleanResponse response = new CleanResponse();
            //assumptions for optimization, at least one senior at every room
            int quotient = noOfRooms / seniorCap;
            int remainder = noOfRooms % seniorCap;

            if(remainder > juniorCap){

            }

            //Assumption 1. If
            cleanResponseList.add(response);
        }
        return cleanResponseList;
    }
}
