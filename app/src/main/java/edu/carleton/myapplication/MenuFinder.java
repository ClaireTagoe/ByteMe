package edu.carleton.myapplication;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.io.PrintWriter;


public class MenuFinder {
    public static void menuSync(Context context) throws IOException {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.DAY_OF_WEEK - 1;
        //int dayOfWeek = 6;
        String dayNumber = "-" + dayOfWeek + "\">";
        Log.i("AAAAAAAAAAAAAAAAAAA",dayNumber);
        List<List<String>> LDCWholeMenuList = Get_WholeMenuList("http://legacy.cafebonappetit.com/weekly-menu/106685", dayNumber);
        List<List<String>> BurtonWholeMenuList = Get_WholeMenuList("http://legacy.cafebonappetit.com/weekly-menu/106686", dayNumber);
        List<List<String>> WeitzWholeMenuList = Get_WholeMenuList("http://legacy.cafebonappetit.com/weekly-menu/106642", dayNumber);
        List<List<String>> SaylesWholeMenuList = Get_Sayles_WholeMenuList("http://legacy.cafebonappetit.com/weekly-menu/106647", dayNumber);


        // code below generate whole menu txt files

        // convert LDC WholeMenu to a single giant String
        String LDCWholeMenuDisplay = "";
        // create the breakfast part
        if (LDCWholeMenuList.get(0).size() != 0) {
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "Breakfast\n";
            for (String dish : LDCWholeMenuList.get(0)) {
                LDCWholeMenuDisplay = LDCWholeMenuDisplay + dish + "\n";
            }
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "\n";
        }
        // create the brunch part
        if (LDCWholeMenuList.get(1).size() != 0) {
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "Brunch\n";
            for (String dish : LDCWholeMenuList.get(1)) {
                LDCWholeMenuDisplay = LDCWholeMenuDisplay + dish + "\n";
            }
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "\n";
        }
        // create the lunch part
        if (LDCWholeMenuList.get(2).size() != 0) {
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "Lunch\n";
            for (String dish : LDCWholeMenuList.get(2)) {
                LDCWholeMenuDisplay = LDCWholeMenuDisplay + dish + "\n";
            }
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "\n";
        }
        // create the dinner part
        if (LDCWholeMenuList.get(3).size() != 0) {
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "Dinner\n";
            for (String dish : LDCWholeMenuList.get(3)) {
                LDCWholeMenuDisplay = LDCWholeMenuDisplay + dish + "\n";
            }
            LDCWholeMenuDisplay = LDCWholeMenuDisplay + "\n";
        }

        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput("LDCWholeMenuDisplayMenu.txt", Context.MODE_PRIVATE);
            outputStream.write(LDCWholeMenuDisplay.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // convert Burton WholeMenu to a single giant String
        String BurtonWholeMenuDisplay = "";
        // create the breakfast part
        if (BurtonWholeMenuList.get(0).size() != 0) {
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "Breakfast\n";
            for (String dish : BurtonWholeMenuList.get(0)) {
                BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + dish + "\n";
            }
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "\n";
        }
        // create the brunch part
        if (BurtonWholeMenuList.get(1).size() != 0) {
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "Brunch\n";
            for (String dish : BurtonWholeMenuList.get(1)) {
                BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + dish + "\n";
            }
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "\n";
        }
        // create the lunch part
        if (BurtonWholeMenuList.get(2).size() != 0) {
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "Lunch\n";
            for (String dish : BurtonWholeMenuList.get(2)) {
                BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + dish + "\n";
            }
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "\n";
        }
        // create the dinner part
        if (BurtonWholeMenuList.get(3).size() != 0) {
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "Dinner\n";
            for (String dish : BurtonWholeMenuList.get(3)) {
                BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + dish + "\n";
            }
            BurtonWholeMenuDisplay = BurtonWholeMenuDisplay + "\n";
        }
        Log.i("BWMDDDDDDDDDDDDDDDDDDDDD",BurtonWholeMenuDisplay);

        try {
            outputStream = context.openFileOutput("BurtonWholeMenuDisplayMenu.txt", Context.MODE_PRIVATE);
            outputStream.write(BurtonWholeMenuDisplay.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // convert Weitz WholeMenu to a single giant String
        String WeitzWholeMenuDisplay = "";
        // create the breakfast part
        if (WeitzWholeMenuList.get(0).size() != 0) {
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "Breakfast\n";
            for (String dish : WeitzWholeMenuList.get(0)) {
                WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + dish + "\n";
            }
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "\n";
        }
        // create the brunch part
        if (WeitzWholeMenuList.get(1).size() != 0) {
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "Brunch\n";
            for (String dish : WeitzWholeMenuList.get(1)) {
                WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + dish + "\n";
            }
        }
        WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "\n";
        // create the lunch part
        if (WeitzWholeMenuList.get(2).size() != 0) {
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "Lunch\n";
            for (String dish : WeitzWholeMenuList.get(2)) {
                WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + dish + "\n";
            }
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "\n";
        }
        // create the dinner part
        if (WeitzWholeMenuList.get(3).size() != 0) {
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "Dinner\n";
            for (String dish : WeitzWholeMenuList.get(3)) {
                WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + dish + "\n";
            }
            WeitzWholeMenuDisplay = WeitzWholeMenuDisplay + "\n";
        }

        try {
            outputStream = context.openFileOutput("WeitzWholeDisplayMenu.txt", Context.MODE_PRIVATE);
            outputStream.write(WeitzWholeMenuDisplay.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // convert Weitz WholeMenu to a single giant String
        String SaylesWholeMenuDisplay = "";
        // create the breakfast part
        if (SaylesWholeMenuList.get(0).size() != 0) {
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "Breakfast\n";
            for (String dish : SaylesWholeMenuList.get(0)) {
                SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + dish + "\n";
            }
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "\n";
        }
        // create the brunch part
        if (SaylesWholeMenuList.get(1).size() != 0) {
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "Brunch\n";
            for (String dish : SaylesWholeMenuList.get(1)) {
                SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + dish + "\n";
            }
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "\n";
        }
        // create the lunch part
        if (SaylesWholeMenuList.get(2).size() != 0) {
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "Lunch\n";
            for (String dish : SaylesWholeMenuList.get(2)) {
                SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + dish + "\n";
            }
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "\n";
        }
        // create the dinner part
        if (SaylesWholeMenuList.get(3).size() != 0) {
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "Dinner\n";
            for (String dish : SaylesWholeMenuList.get(3)) {
                SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + dish + "\n";
            }
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "\n";
        }
        // create the late night part
        if (SaylesWholeMenuList.get(4).size() != 0) {
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "Late Night\n";
            for (String dish : SaylesWholeMenuList.get(4)) {
                SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + dish + "\n";
            }
            SaylesWholeMenuDisplay = SaylesWholeMenuDisplay + "\n";
        }

        try {
            outputStream = context.openFileOutput("SaylesWholeDisplayMenu.txt", Context.MODE_PRIVATE);
            outputStream.write(SaylesWholeMenuDisplay.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // the code below generates a giant string containing all the occurances of the preffered food
        List<List<List<String>>> PreferenceMenu = Generate_PreferenceList(MyFood.food, LDCWholeMenuList, BurtonWholeMenuList, WeitzWholeMenuList, SaylesWholeMenuList);
        String preferredMenuDisplay = "";
        // add Burton if not empty
        if (PreferenceMenu.size()>=2) {
            preferredMenuDisplay = preferredMenuDisplay + "Burton:\n";
            // add breakfast
            if (PreferenceMenu.get(1).size()>=1 && PreferenceMenu.get(1).get(0).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Breakfast:\n";
                for (String dish : PreferenceMenu.get(1).get(0)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add brunch
            if (PreferenceMenu.get(1).size()>=2 && PreferenceMenu.get(1).get(1).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Brunch:\n";
                for (String dish : PreferenceMenu.get(1).get(1)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
                preferredMenuDisplay = preferredMenuDisplay +"\n";
            }
            // add lunch
            if (PreferenceMenu.get(1).size()>=3 && PreferenceMenu.get(1).get(2).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Lunch:\n";
                for (String dish : PreferenceMenu.get(1).get(2)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add dinner
            if (PreferenceMenu.get(1).size()>=4 && PreferenceMenu.get(1).get(3).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Dinner:\n";
                for (String dish : PreferenceMenu.get(1).get(3)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            preferredMenuDisplay = preferredMenuDisplay +"\n";
        }

        // add LDC if not empty
        if ((PreferenceMenu.size()>=1)) {
            preferredMenuDisplay = preferredMenuDisplay + "LDC:\n";
            // add breakfast
            if (PreferenceMenu.get(0).size()>=1 && PreferenceMenu.get(0).get(0).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Breakfast:\n";
                for (String dish : PreferenceMenu.get(0).get(0)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add brunch
            if (PreferenceMenu.get(0).size()>=2 &&PreferenceMenu.get(0).get(1).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Brunch:\n";
                for (String dish : PreferenceMenu.get(0).get(1)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add lunch
            if (PreferenceMenu.get(0).size()>=3 && PreferenceMenu.get(0).get(2).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Lunch:\n";
                for (String dish : PreferenceMenu.get(0).get(2)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add dinner
            if (PreferenceMenu.get(0).size()>=4 && PreferenceMenu.get(0).get(3).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Dinner:\n";
                for (String dish : PreferenceMenu.get(0).get(3)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            preferredMenuDisplay = preferredMenuDisplay +"\n";
        }

        // add Sayles if not empty
        if ((PreferenceMenu.size()>=4)) {
            preferredMenuDisplay = preferredMenuDisplay + "Sayles:\n";
            // add breakfast
            if (PreferenceMenu.get(3).size()>=1 && PreferenceMenu.get(3).get(0).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Breakfast:\n";
                for (String dish : PreferenceMenu.get(3).get(0)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add brunch
            if (PreferenceMenu.get(3).size()>=2 && PreferenceMenu.get(3).get(1).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Brunch:\n";
                for (String dish : PreferenceMenu.get(3).get(1)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add lunch
            if (PreferenceMenu.get(3).size()>=3 && PreferenceMenu.get(3).get(2).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Lunch:\n";
                for (String dish : PreferenceMenu.get(3).get(2)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add dinner
            if (PreferenceMenu.get(3).size()>=4 && PreferenceMenu.get(3).get(3).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Dinner:\n";
                for (String dish : PreferenceMenu.get(3).get(3)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add latenight
            if (PreferenceMenu.get(3).size()>=5 && PreferenceMenu.get(3).get(4).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Late Night:\n";
                for (String dish : PreferenceMenu.get(3).get(4)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }

            }
            preferredMenuDisplay = preferredMenuDisplay +"\n";
        }

        // add Weitz if not empty
        if ((PreferenceMenu.size()>=3)) {
            preferredMenuDisplay = preferredMenuDisplay + "Weitz:\n";
            // add breakfast
            if (PreferenceMenu.get(2).size()>=1 && PreferenceMenu.get(2).get(0).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Breakfast:\n";
                for (String dish : PreferenceMenu.get(2).get(0)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add brunch
            if (PreferenceMenu.get(2).size()>=2 && PreferenceMenu.get(2).get(1).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Brunch:\n";
                for (String dish : PreferenceMenu.get(2).get(1)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add lunch
            if (PreferenceMenu.get(2).size()>=3 && PreferenceMenu.get(2).get(2).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Lunch:\n";
                for (String dish : PreferenceMenu.get(2).get(2)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
            // add dinner
            if (PreferenceMenu.get(2).size()>=4 && PreferenceMenu.get(2).get(3).size() != 0) {
                preferredMenuDisplay = preferredMenuDisplay + "Dinner:\n";
                for (String dish : PreferenceMenu.get(2).get(3)) {
                    preferredMenuDisplay = preferredMenuDisplay + dish + "\n";
                }
            }
        }
        FileOutputStream fos = context.openFileOutput("PreferenceDisplayMenu.txt", Context.MODE_PRIVATE);
        fos.write(preferredMenuDisplay.getBytes());
        fos.close();
//        PrintWriter writer5 = new PrintWriter("FreferenceDisplayMenu.txt", "UTF-8");
//        writer5.print(preferredMenuDisplay);
//        writer5.close();
    }


//    public void CreateEmptyInternalFile(String filename, List WriteData) {
//        // add-write text into file
//        try {
//            // assume can automatically overwrite
//            FileOutputStream fileout=openFileOutput(filename, MODE_PRIVATE);
//            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
//            outputWriter.write(textmsg.getText().toString());
//            outputWriter.close();
//
//            //display file saved message
//            Toast.makeText(getBaseContext(), "File saved successfully!",
//                    Toast.LENGTH_SHORT).show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }











    public static List<List<List<String>>> Generate_PreferenceList(List<String> PreferenceList, List<List<String>> LDCWholeMenuList,
                                                                   List<List<String>> BurtonWholeMenuList, List<List<String>> WeitzWholeMenuList,
                                                                   List<List<String>> SaylesWholeMenuList) throws MalformedURLException {

        // B,Br,L,D,(Ln)
        List<List<String>> PreferredLDCWholeMenuList = new ArrayList<List<String>>();
        List<List<String>> PreferredBurtonWholeMenuList = new ArrayList<List<String>>();
        List<List<String>> PreferredWeitzWholeMenuList = new ArrayList<List<String>>();
        List<List<String>> PreferredSaylesWholeMenuList = new ArrayList<List<String>>();

        //LDC Preferred

        int counter = 0;
        for (String item: PreferenceList){
            if (counter==0) {
                String itemCopy = item.toLowerCase();
                for (List<String> dayPart : LDCWholeMenuList) {
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, dayPart);
                    PreferredLDCWholeMenuList.add(MatchString);
                }
            }
            else {
                String itemCopy = item.toLowerCase();
                for (int k=0; k < LDCWholeMenuList.size(); k++){
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, LDCWholeMenuList.get(k));
                    PreferredLDCWholeMenuList.get(k).addAll(MatchString);
                }
            }
            counter ++;
        }

        //Burton Preferred
        counter = 0;
        for (String item: PreferenceList){
            if (counter==0) {
                String itemCopy = item.toLowerCase();
                for (List<String> dayPart : BurtonWholeMenuList) {
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, dayPart);
                    PreferredBurtonWholeMenuList.add(MatchString);
                }
            }
            else {
                String itemCopy = item.toLowerCase();
                for (int k=0; k < BurtonWholeMenuList.size(); k++){
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, BurtonWholeMenuList.get(k));
                    PreferredBurtonWholeMenuList.get(k).addAll(MatchString);
                }
            }
            counter ++;
        }

        //Sayles Preferred
        counter = 0;
        for (String item: PreferenceList){
            if (counter==0) {
                String itemCopy = item.toLowerCase();
                for (List<String> dayPart : SaylesWholeMenuList) {
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, dayPart);
                    PreferredSaylesWholeMenuList.add(MatchString);
                }
            }
            else {
                String itemCopy = item.toLowerCase();
                for (int k=0; k < SaylesWholeMenuList.size(); k++){
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, SaylesWholeMenuList.get(k));
                    PreferredSaylesWholeMenuList.get(k).addAll(MatchString);
                }
            }
            counter ++;
        }

        //Weitz Preferred
        counter = 0;
        for (String item: PreferenceList){
            if (counter==0) {
                String itemCopy = item.toLowerCase();
                for (List<String> dayPart : WeitzWholeMenuList) {
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, dayPart);
                    PreferredWeitzWholeMenuList.add(MatchString);
                }
            }
            else {
                String itemCopy = item.toLowerCase();
                for (int k=0; k < WeitzWholeMenuList.size(); k++){
                    String regex = ".*" + itemCopy + ".*";
                    List<String> MatchString = stringsThatMatch(regex, WeitzWholeMenuList.get(k));
                    PreferredWeitzWholeMenuList.get(k).addAll(MatchString);
                }
            }
            counter ++;
        }

        ArrayList WholePreferredMenuList = new ArrayList();
        WholePreferredMenuList.add(PreferredLDCWholeMenuList);
        WholePreferredMenuList.add(PreferredBurtonWholeMenuList);
        WholePreferredMenuList.add(PreferredWeitzWholeMenuList);
        WholePreferredMenuList.add(PreferredSaylesWholeMenuList);
        return WholePreferredMenuList;
    }

    public static List<String> stringsThatMatch(String regex, List<String> candidateStrings) {
        ArrayList<String> matchingStrings = new ArrayList<String>();
        for (String candidate: candidateStrings) {
            String candidateCopy = candidate.toLowerCase();
            if (candidateCopy.matches(regex)) {
                matchingStrings.add(candidate);
            }
        }
        return matchingStrings;
    }

    public static List<List<String>> Get_WholeMenuList(String website, String dayNumber) throws MalformedURLException {
        ArrayList List_B = new ArrayList();
        ArrayList List_Br = new ArrayList();
        ArrayList List_L = new ArrayList();
        ArrayList List_D = new ArrayList();
        Boolean RightCell = Boolean.valueOf(false);
        Boolean Period = Boolean.valueOf(false);
        URL DiningHall = new URL(website);
        URLConnection DiningHallconnect = null;

        try {
            DiningHallconnect = DiningHall.openConnection();
            InputStream ips = DiningHallconnect.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader WholeMenuList = new BufferedReader(ipsr);
            String dish = null;

            String inputLine;
            while((inputLine = WholeMenuList.readLine()) != null) {
                if(inputLine.contains("class=\"cell_menu_item\"")) {
                    if(inputLine.contains(dayNumber)) {
                        RightCell = Boolean.valueOf(true);
                    } else {
                        RightCell = Boolean.valueOf(false);
                    }
                }

                if(RightCell.booleanValue() && inputLine.contains("<strong><span class=\"font-size-90\">")) {
                    dish = inputLine.replace("<strong><span class=\"font-size-90\">", "");
                    dish = dish.replace("</span></strong>", "");
                    dish = dish.trim();
                    Period = Boolean.valueOf(true);
                }

                if(Period.booleanValue() && inputLine.contains("<span class=\"daypart-abbr\">")) {
                    String time = inputLine.replace("<span class=\"daypart-abbr\"><strong>[", "");
                    time = time.replaceAll("].*", "");
                    time = time.trim();
                    if(time.contains("Br")) {
                        List_Br.add(dish);
                        time = time.replace("Br", "");
                    }

                    if(time.contains("B")) {
                        List_B.add(dish);
                    }

                    if(time.contains("L")) {
                        List_L.add(dish);
                    }

                    if(time.contains("D")) {
                        List_D.add(dish);
                    }

                    Period = Boolean.valueOf(false);
                }
            }

            WholeMenuList.close();
        } catch (IOException var14) {
            var14.printStackTrace();
        }

        ArrayList WholeMenuList1 = new ArrayList();
        WholeMenuList1.add(List_B);
        WholeMenuList1.add(List_Br);
        WholeMenuList1.add(List_L);
        WholeMenuList1.add(List_D);
        return WholeMenuList1;
    }
    public static List<List<String>> Get_Sayles_WholeMenuList(String website, String dayNumber) throws MalformedURLException {
        ArrayList List_B = new ArrayList();
        ArrayList List_Br = new ArrayList();
        ArrayList List_L = new ArrayList();
        ArrayList List_Ln = new ArrayList();
        ArrayList List_D = new ArrayList();
        Boolean RightCell = Boolean.valueOf(false);
        Boolean Period = Boolean.valueOf(false);
        URL DiningHall = new URL(website);
        URLConnection DiningHallconnect = null;

        try {
            DiningHallconnect = DiningHall.openConnection();
            BufferedReader WholeMenuList = new BufferedReader(new InputStreamReader(DiningHallconnect.getInputStream()));
            String dish = null;

            String inputLine;
            while((inputLine = WholeMenuList.readLine()) != null) {
                if(inputLine.contains("class=\"cell_menu_item\"")) {
                    if(inputLine.contains(dayNumber)) {
                        RightCell = Boolean.valueOf(true);
                    } else {
                        RightCell = Boolean.valueOf(false);
                    }
                }

                if(RightCell.booleanValue() && inputLine.contains("<strong><span class=\"font-size-90\">")) {
                    dish = inputLine.replace("<strong><span class=\"font-size-90\">", "");
                    dish = dish.replace("</span></strong>", "");
                    dish = dish.trim();
                    Period = Boolean.valueOf(true);
                }

                if(Period.booleanValue() && inputLine.contains("<span class=\"daypart-abbr\">")) {
                    String time = inputLine.replace("<span class=\"daypart-abbr\"><strong>[", "");
                    time = time.replaceAll("].*", "");
                    time = time.trim();
                    if(time.contains("Br")) {
                        List_Br.add(dish);
                        time = time.replace("Br", "");
                    }

                    if(time.contains("B")) {
                        List_B.add(dish);
                    }

                    if(time.contains("Ln")) {
                        List_Ln.add(dish);
                        time = time.replace("Ln", "");
                    }

                    if(time.contains("L")) {
                        List_L.add(dish);
                    }

                    if(time.contains("D")) {
                        List_D.add(dish);
                    }

                    Period = Boolean.valueOf(false);
                }
            }

            WholeMenuList.close();
        } catch (IOException var15) {
            var15.printStackTrace();
        }

        ArrayList WholeMenuList1 = new ArrayList();
        WholeMenuList1.add(List_B);
        WholeMenuList1.add(List_Br);
        WholeMenuList1.add(List_L);
        WholeMenuList1.add(List_D);
        WholeMenuList1.add(List_Ln);
        return WholeMenuList1;
    }

}

