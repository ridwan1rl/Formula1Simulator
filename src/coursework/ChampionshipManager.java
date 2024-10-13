package coursework;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public interface ChampionshipManager {


      class Formula1ChampionshipManager extends Formula1Driver implements ChampionshipManager {
          public static void main(String[] args) throws IOException {

              Formula1Driver[] myChampionship = new Formula1Driver[10];
              myChampionship[0] = new Formula1Driver();
              myChampionship[1] = new Formula1Driver();
              myChampionship[2] = new Formula1Driver();
              myChampionship[3] = new Formula1Driver();
              myChampionship[4] = new Formula1Driver();
              myChampionship[5] = new Formula1Driver();
              myChampionship[6] = new Formula1Driver();
              myChampionship[7] = new Formula1Driver();
              myChampionship[8] = new Formula1Driver();
              myChampionship[9] = new Formula1Driver();
              int TeamSlot = 0;




              displayMenu();
              initial(myChampionship);


              Scanner ds = new Scanner(System.in);
              String Display = ds.next();
              while (!Display.equals("P")) {

                  switch (Display) {
                      case "V":
                          ViewTeams(myChampionship);
                          break;
                      case "A":
                          AllocateDriver(myChampionship);
                          break;
                      case "D":
                          DeleteDriverFromTeam(myChampionship);

                          break;
                      case "F":
                          FindTeamFromDriverName(myChampionship);
                          break;
                      case "O":
                          sortNoOfPoints(myChampionship , TeamSlot);

                          break;
                      case "S":
                          storeFile(myChampionship);

                          break;
                      case "E":
                          CheckIfEmpty(myChampionship);
                          break;
                      case "L":
                          loadFile(myChampionship);
                          break;
                      case "R":
                          raceInfo(myChampionship, TeamSlot);
                          break;

                  }


                  displayMenu();
                  Display = ds.next();


              }
          }


          private static void displayMenu() {
              System.out.println("======================================================");
              System.out.println("please choose a letter from the menu");
              System.out.println("Select A)  to create  a new driver ");
              System.out.println("Select V)  to view all the teams and drivers");
              System.out.println("Select E)  to display all the teams with no drivers ");
              System.out.println("Select D)  to delete a driver from a team");
              System.out.println("Select F)  to find driver and display its statistics");
              System.out.println("Select R)  to add the name of the race and the date ");
              System.out.println("Select S)  to store programme data into a file");
              System.out.println("Select L)  to load data from the file");
              System.out.println("Select O)  to view Positions in order");
              System.out.println("Select P)  to end the programme");
              System.out.println("======================================================");


          }

          private static void initial(Formula1Driver[] myChampionship) {

              for (int x = 0; x < myChampionship.length; x++) {
                  myChampionship[x].setName(".");
              }


          }

          private static void CheckIfEmpty(Formula1Driver[] myChampionship) {
              for (int x = 0; x < myChampionship.length; x++) {
                  if (myChampionship[x].getName().equals(".")) {
                      System.out.println("Team " + x + " does not have any drivers");
                  }
              }
          }

          private static void AllocateDriver(Formula1Driver[] myChampionship) {
              String DriverName;
              Scanner input = new Scanner(System.in);

              System.out.println("Enter Team number (0-8):");
              int TeamSlot = input.nextInt();
              System.out.println("Enter the name of the driver " + (TeamSlot) + " :");
              DriverName = input.next();
              myChampionship[TeamSlot].setName(DriverName);
              int position;
              System.out.println("What is  " + DriverName + " position at the end of the race: ");
              position = input.nextInt();
              myChampionship[TeamSlot].setDriverPoints(position);
              myChampionship[TeamSlot].setPosition(position);


          }

          private static void raceInfo(Formula1Driver[] myChampionship, int TeamSlot) {
              Scanner input = new Scanner(System.in);
              String race;
              String Date;
              System.out.println("enter the name of the race:  ");
              race = input.next();
              System.out.println("enter the date for the race:  ");
              Date = input.next();
              myChampionship[TeamSlot].setDate(Date);
              myChampionship[TeamSlot].setRace(race);
              for (int x = 0; x < myChampionship.length; x++) {
                  myChampionship[x].setDate(Date);
                  myChampionship[x].setRace(race);


                  System.out.println("the name of the race is::  " + myChampionship[x].getRace() + " The name of the Drivers is:: " + myChampionship[x].getName() +
                          "\n The Driver ended the race at position:: " + myChampionship[x].getPosition() + " And this race was completed at the date:: " + myChampionship[x].getDate());
                  System.out.println("===================================================================================================");
              }


          }

          private static void ViewTeams(Formula1Driver[] myChampionship) {
              for (int x = 0; x < myChampionship.length; x++) {
                  System.out.println("Team " + x + " has the driver:  " + myChampionship[x].getName() + " and has ended the race at position:  " + myChampionship[x].getPosition());
                  System.out.println(" The team has a total of  " + myChampionship[x].getDriverPoints() + " points ");
                  System.out.println("==============================================================================");
              }


          }




          private static void DeleteDriverFromTeam(Formula1Driver[] myChampionship) {
              Scanner input = new Scanner(System.in);
              System.out.println("Enter Team number to delete(0-8):");
              int TeamSlot = input.nextInt();
              myChampionship[TeamSlot].setName(".");
              System.out.println("Driver has been deleted ");



          }

          private static void FindTeamFromDriverName(Formula1Driver[] myChampionship) {
              Scanner input = new Scanner(System.in);
              String NameOfDriver;
              System.out.println("Enter the name of the driver you want to Search for:");
              NameOfDriver = input.next();
              int x;
              boolean Checker = false;
              for (x = 0; x < myChampionship.length; x++) {
                  if (NameOfDriver.equals(myChampionship[x].getName())) {
                      System.out.println("The Driver is at Team number " + x + " and is at the position " + myChampionship[x].getPosition() + "\n" + myChampionship[x].getName() + " Has the the total number of:: " + myChampionship[x].getDriverPoints() + " Points");
                      Checker = true;
                  }
              }
              if (!Checker) {
                  System.out.println("There are no Teams that have that driver \n" +
                          "please type in the name of the driver correctly ");
              }
          }

          private static void storeFile(Formula1Driver[] myChampionship) {

              try {
                  PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\44757\\OneDrive\\Documents\\output.txt"));
                  for (int x = 0; x < myChampionship.length; x++) {
                      out.println("Team " + x + " has the driver:  " + myChampionship[x].getName() + " and has ended the race at position:  " + myChampionship[x].getPosition());
                      out.println("Based on the position of this driver " + myChampionship[x].getDriverPoints() + " points have been given ");
                      out.println("==============================================================================");


                  }
                  out.close();


              } catch (IOException e) {
                  System.out.println("error");
              }
              System.out.println("All Team info have been Saved.");
          }

          private static void loadFile(Formula1Driver[] myChampionship) throws FileNotFoundException {
              File file = new File("C:\\Users\\44757\\OneDrive\\Documents\\output.txt");
              Scanner scan = new Scanner(file);
              while (scan.hasNextLine()) {
                  System.out.println(scan.nextLine());

              }


          }


          private static void sortNoOfPoints(Formula1Driver[] myChampionship, int TeamSlot) {


              int[] myStrArray = new int[myChampionship.length];
              for (int i = 0; i < myChampionship.length; i++) {
                  myStrArray[i] = (myChampionship[i].getDriverPoints());
              }
              for (int j = 0; j < myStrArray.length-1; j++) {
                  for (int x=0; x< myStrArray.length-1-j; x++){
                      if (myStrArray[x]< myStrArray[x+1]){
                          int temp = myStrArray[x+1];
                          myStrArray[x+1]= myStrArray[x];
                          myStrArray[x]= temp;
                      }
                  }
              }
              System.out.println(Arrays.toString(myStrArray));

          }
      }






      }






